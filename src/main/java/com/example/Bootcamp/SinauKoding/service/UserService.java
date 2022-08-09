package com.example.Bootcamp.SinauKoding.service;

import com.example.Bootcamp.SinauKoding.config.JwtTokenUtil;
import com.example.Bootcamp.SinauKoding.model.User;
import com.example.Bootcamp.SinauKoding.model.dto.AuthRequestDTO;
import com.example.Bootcamp.SinauKoding.model.dto.RegistrationDTO;
import com.example.Bootcamp.SinauKoding.model.mapper.UserMapper;
import com.example.Bootcamp.SinauKoding.model.dto.UserDTO;
import com.example.Bootcamp.SinauKoding.repository.DetailUserRepository;
import com.example.Bootcamp.SinauKoding.repository.RoleUserRepository;
import com.example.Bootcamp.SinauKoding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    DetailUserRepository detailUserRepository;

    @Autowired
    RoleUserRepository roleUserRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public List<UserDTO> findAllUser() {
        return UserMapper.INSTANCE.toListDTO(repository.findAll());
    }

    @Transactional
    public UserDTO createUser(UserDTO param) {
        User user = UserMapper.INSTANCE.toEntity(param);
        user = repository.save(user);

//        DetailUser detailUser = detailUserRepository.save(param.getDetailUser());
//
//        RoleUser roleUser = roleUserRepository.save(param.getRole());
//
//        user.setDetailUser(detailUser);
//        user.setRole(roleUser);
        return UserMapper.INSTANCE.toDto(user);
    }

    public boolean deleteUser(int id) {
        User data = repository.findById(id).orElseThrow(null);

        try {
            repository.delete(data);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public User updateUser(int id, User user) {
        User data = repository.findById(id).orElseThrow(null);
        data.setUsername(user.getUsername() != null ? user.getUsername() : data.getUsername());
        data.setAddress(user.getAddress() != null ? user.getAddress() : data.getAddress());
        data.setProfileName(user.getProfileName() != null ? user.getProfileName() : data.getProfileName());
        data.setPhone(user.getPhone() != null ? user.getPhone() : data.getPhone());

        return repository.save(data);
    }

    public UserDTO findById(Integer id){
        return UserMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(null));
    }

    public UserDTO doLogin(AuthRequestDTO user){
        User currentUser = repository.findByUsername(user.getUsername());

        //mengecek apakan user kosong, jika kosong maka akan mengembalikan data null
        if (currentUser == null){
            return UserMapper.INSTANCE.toDto(currentUser);
        }else if (currentUser.getPassword() != null && BCrypt.checkpw(user.getPassword(), currentUser.getPassword())){ //mengecek value password dari currentUser apakah tidak sama dengan null, dan membandingkan passwod dari param dan current user menggunakan BCrypt
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

            currentUser.setToken(jwtTokenUtil.doGenerateToken(userDetails));

            return UserMapper.INSTANCE.toDto(currentUser);
        }

        return null;
    }

    public RegistrationDTO doRegister(RegistrationDTO param){
        User user = repository.findByUsername(param.getUsername());

        if (user != null){
            return null;
        }

        //menyimpan value dari encripsi password dari parameter menggunakan BCrypt
        param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

        user = repository.save(UserMapper.INSTANCE.toUserFromRegistationDTO(param));

        return UserMapper.INSTANCE.toRegistrationDto(user);
    }
}
