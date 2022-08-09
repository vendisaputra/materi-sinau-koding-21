package com.example.Bootcamp.SinauKoding.repository;

import com.example.Bootcamp.SinauKoding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
