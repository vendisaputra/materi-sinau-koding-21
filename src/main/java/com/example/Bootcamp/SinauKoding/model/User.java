package com.example.Bootcamp.SinauKoding.model;

import com.example.Bootcamp.SinauKoding.enumeration.RoleUser;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "profile_name")
    private String profileName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, allowSetters = true, allowGetters = false)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_user_id")
    @JsonManagedReference
    private DetailUser detailUser;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleUser role = RoleUser.SUPERVISOR;

}
