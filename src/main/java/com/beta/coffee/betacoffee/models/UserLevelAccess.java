package com.beta.coffee.betacoffee.models;

import java.util.List;

import javax.persistence.*;

import com.beta.coffee.betacoffee.models.enums.LevelsOfAccess;

@Entity
@SequenceGenerator(name = "user_level_access_seq", sequenceName = "user_level_access_seq",
        initialValue = 1, allocationSize = 1)
public class UserLevelAccess{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_level_access_seq")
    Byte id;

    @Enumerated(EnumType.STRING)
    LevelsOfAccess type;

    @OneToMany(mappedBy="levelAccess")
    List<User> users;

} 