package com.example.Bootcamp.SinauKoding.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detail_user")
@Getter
@Setter
public class DetailUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "religion")
    private String religion;

    @Transient
    @OneToOne(mappedBy = "detailUser", fetch = FetchType.LAZY)
    private User user;
}
