package com.revan.SpringStarter.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
//@Table(name = "user")
public class User {

//    @Column(name = "id", nullable = false, unique = true, columnDefinition = "INT")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "name", nullable = false)
    private String name;

//    @Column(name = "role", nullable = false)
    private String role;

    public User() {}

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
