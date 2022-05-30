package com.beta.coffee.betacoffee.models;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq",
        initialValue = 1, allocationSize = 1)
@Table(name="`User`")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    Long id;

    String nameUser;

    String email;

    String password;

    @ManyToOne
    UserLevelAccess levelAccess;

}