package com.example.Bootcamp.SinauKoding.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "path")
    private String path;

    @ManyToMany(mappedBy = "menuRole")
    private List<RoleUser> roleUsers;

    @OneToMany(mappedBy = "menu")
    private List<RoleMenu> list;
}
