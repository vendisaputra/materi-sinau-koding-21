package com.example.Bootcamp.SinauKoding.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    private DetailUserDTO detailUser;
}
