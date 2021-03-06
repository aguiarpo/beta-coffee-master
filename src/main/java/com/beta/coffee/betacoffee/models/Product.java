package com.beta.coffee.betacoffee.models;

import java.util.List;

import javax.persistence.*;
import com.beta.coffee.betacoffee.models.enums.CupSize;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq",
        initialValue = 1, allocationSize = 1)
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    Long id;

    String name;

    Float price;

    Boolean hot;

    @Enumerated(EnumType.STRING)
    CupSize cupSize;

    @ManyToOne
    Category category;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    List<Request> requests;

}