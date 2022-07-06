package com.beta.coffee.betacoffee.repository;

import java.util.List;

import com.beta.coffee.betacoffee.models.User;
import com.beta.coffee.betacoffee.models.enums.LevelsOfAccess;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByType(LevelsOfAccess levelAccess);
    User findByName(String name);
    User findByEmail(String name);
    @Query(value = "SELECT * FROM `user` where name like :name%",
    nativeQuery = true)
    Page<User> findByNameLike(String name, Pageable pageable);
} 