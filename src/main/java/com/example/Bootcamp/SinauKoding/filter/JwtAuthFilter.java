package com.example.Bootcamp.SinauKoding.filter;

import com.example.Bootcamp.SinauKoding.config.JwtTokenUtil;
import com.example.Bootcamp.SinauKoding.model.User;
import com.example.Bootcamp.SinauKoding.repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    //configurasi untuk mengecek header dan token dengan ketentuan key header "Authorization"
    //value Authorization harus ada kata "Bearer " agar token diproses
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if (header != null && header.startsWith("Bearer ")) {
            token = header.replace("Bearer ", "");

            try {
                username = jwtTokenUtil.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                logger.error("Error mendapatkan username from token");
            } catch (ExpiredJwtException e) {
                logger.warn("Token expired");
            } catch (SignatureException e) {
                logger.error("Username atau password tidak sesuai");
            }
        } else {
            logger.warn("header tidak di set / tidak dapat menemukan kata Bearer");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userRepository.findByUsername(username);

            if (jwtTokenUtil.validateToken(token, user)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }

}
