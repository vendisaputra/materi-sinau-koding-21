package com.example.Bootcamp.SinauKoding.model.dto;

import com.example.Bootcamp.SinauKoding.enumeration.RoleUser;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationDTO {
    private String username;
    private String password;
    private String profileName;
    private RoleUser role;
}
