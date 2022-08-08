package com.example.Bootcamp.SinauKoding.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class DetailUserDTO {
    private Integer id;

    private String gender;

    private String religion;
}
