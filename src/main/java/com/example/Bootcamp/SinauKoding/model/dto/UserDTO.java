package com.example.Bootcamp.SinauKoding.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String username;
    private String name;
    private String address;
    private String phone;
    private DetailUserDTO detailUser;
}
