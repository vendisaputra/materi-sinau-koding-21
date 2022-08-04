package com.example.Bootcamp.SinauKoding.controller;

import com.example.Bootcamp.SinauKoding.model.RoleUser;
import com.example.Bootcamp.SinauKoding.service.RoleUserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/role")
public class RoleUserController {
    @Autowired
    RoleUserService roleUserService;

    @PostMapping
    public ResponseEntity<?> createRoleUser(@RequestBody RoleUser param){
        return new ResponseEntity(roleUserService.create(param), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listRole(){
        return new ResponseEntity(roleUserService.listRole(), HttpStatus.OK);
    }
}
