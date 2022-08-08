package com.example.Bootcamp.SinauKoding.controller;

import com.example.Bootcamp.SinauKoding.model.User;
import com.example.Bootcamp.SinauKoding.model.dto.UserDTO;
import com.example.Bootcamp.SinauKoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<?> findAllUser() {
        return new ResponseEntity(service.findAllUser(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDTO param) {
        return new ResponseEntity(service.createUser(param), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
        return new ResponseEntity("Berhasil dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id,
                                        @RequestBody User user) {
        return new ResponseEntity(service.updateUser(id, user), HttpStatus.OK);
    }
}
