package com.example.Bootcamp.SinauKoding.service;

import com.example.Bootcamp.SinauKoding.model.RoleUser;
import com.example.Bootcamp.SinauKoding.repository.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleUserService {
    @Autowired
    RoleUserRepository roleUserRepository;

    public RoleUser create(RoleUser param){
        return roleUserRepository.save(param);
    }

    public List<RoleUser> listRole(){
        return roleUserRepository.findAll();
    }
}
