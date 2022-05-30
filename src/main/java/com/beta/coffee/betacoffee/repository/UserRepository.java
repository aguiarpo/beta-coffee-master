package com.beta.coffee.betacoffee.repository;

import java.util.List;

import com.beta.coffee.betacoffee.models.User;
import com.beta.coffee.betacoffee.models.enums.LevelsOfAccess;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByType(LevelsOfAccess levelAccess);
    User findByName(String name);
} 