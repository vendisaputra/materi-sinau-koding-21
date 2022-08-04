package com.example.Bootcamp.SinauKoding.controller;

import com.example.Bootcamp.SinauKoding.model.DetailUser;
import com.example.Bootcamp.SinauKoding.service.DetailUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detail-user")
public class DetailUserController {
    @Autowired
    private DetailUserService service;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody DetailUser param){
        return new ResponseEntity(service.createUser(param), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listDetail(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }
}
