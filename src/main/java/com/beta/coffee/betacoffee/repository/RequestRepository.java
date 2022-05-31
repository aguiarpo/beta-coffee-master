package com.beta.coffee.betacoffee.repository;

import com.beta.coffee.betacoffee.models.Request;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RequestRepository extends PagingAndSortingRepository<Request, Long> {
    @Query(value = "SELECT * FROM request where name like :name%",
    nativeQuery = true)
    Page<Request> findByNameLike(String name, Pageable pageable);
} 