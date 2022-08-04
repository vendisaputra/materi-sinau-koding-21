package com.example.Bootcamp.SinauKoding.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role_user")
@Getter
@Setter
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role")
    private String role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "menu_role", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"))
    private List<Menu> menuRole;

    @OneToMany(mappedBy = "roleUser")
    private List<RoleMenu> roleMenus;

    @Transient
    @OneToMany(mappedBy = "role")
    private List<User> userList;
}
