package com.beta.coffee.betacoffee.models;

import javax.persistence.*;

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

    public User(String nameUser, String email, String password, LevelsOfAccess type){
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    Long id;

    String nameUser;

    String email;

    String password;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    LevelsOfAccess type;

}