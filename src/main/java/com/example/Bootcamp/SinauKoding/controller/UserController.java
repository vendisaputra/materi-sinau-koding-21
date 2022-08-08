package com.example.Bootcamp.SinauKoding.controller;

import com.example.Bootcamp.SinauKoding.common.Response;
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
    public Response findAllUser() {
        return new Response(
                service.findAllUser(),
                service.findAllUser().size(),
                HttpStatus.OK);
    }

    @PostMapping
    public Response saveUser(@RequestBody UserDTO param) {
        return new Response(
                service.createUser(param),
                "Data Berhasil Disimpan!",
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable Integer id) {
        if (service.deleteUser(id)){
            return new Response("Berhasil dihapus", HttpStatus.OK);
        }

        return new Response("Gagal dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id,
                                        @RequestBody User user) {
        return new ResponseEntity(service.updateUser(id, user), HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public Response getById(@PathVariable Integer id){
        return new Response(service.findById(id), "Data ditemukan", HttpStatus.OK);
    }
}
