package com.beta.coffee.betacoffee.models;

import javax.persistence.*;
import javax.validation.constraints.Email;

import com.beta.coffee.betacoffee.models.enums.LevelsOfAccess;

import lombok.Getter;
import lombok.Setter;

@Entity
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq",
        initialValue = 1, allocationSize = 1)
@Table(name="`User`")
@Getter
@Setter
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    Long id;

    String name;

    @Email
    @Column(unique = true)
    String email;

    String password;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    LevelsOfAccess type;

    public User() {

    }
}