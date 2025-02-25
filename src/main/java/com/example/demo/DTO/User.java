package com.example.demo.DTO;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "Users")
public class User {
    private String firstName;
    private String lastName;
    @Id
    @Column(unique=true)
    private String login;
    private String email;
    private String password;
    @Transient
    private String confirmPassword;
}
