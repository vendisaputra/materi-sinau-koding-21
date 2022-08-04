package com.example.Bootcamp.SinauKoding.service;

import com.example.Bootcamp.SinauKoding.model.DetailUser;
import com.example.Bootcamp.SinauKoding.repository.DetailUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailUserService {
    @Autowired
    DetailUserRepository repository;

    public DetailUser createUser(DetailUser detailUser){
        return repository.save(detailUser);
    }

    public List<DetailUser> findAll(){
        return repository.findAll();
    }
}
