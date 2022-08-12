package com.example.Bootcamp.SinauKoding.enumeration;

import lombok.Getter;


public enum RoleUser {
    SUPERADMIN("SUPERADMIN"),
    MANAGER("MANAGER"),
    SUPERVISOR("SUPERVISOR");

    @Getter
    private String name;
    RoleUser(String name) {
        this.name = name;
    }
}
