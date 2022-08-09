package com.example.Bootcamp.SinauKoding.controller;

import com.example.Bootcamp.SinauKoding.common.Response;
import com.example.Bootcamp.SinauKoding.model.dto.AuthRequestDTO;
import com.example.Bootcamp.SinauKoding.model.dto.RegistrationDTO;
import com.example.Bootcamp.SinauKoding.model.dto.UserDTO;
import com.example.Bootcamp.SinauKoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;


    //untuk login api
    @PostMapping("/do-login")
    public Response doLogin(@RequestBody AuthRequestDTO param) {
        UserDTO data = userService.doLogin(param);

        return new Response(data, data != null ? "Login Sukses" : "Login gagal", HttpStatus.OK);
    }


    //untuk registration api
    @PostMapping("/do-register")
    public Response doRegister(@RequestBody RegistrationDTO param){
        RegistrationDTO data = userService.doRegister(param);
        return new Response(data, data != null ? "Registrasi berhasil" : "Registrasi gagal", HttpStatus.OK);
    }
}
