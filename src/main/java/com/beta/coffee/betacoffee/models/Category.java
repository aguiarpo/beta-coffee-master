package com.beta.coffee.betacoffee.models;

import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "category_seq", sequenceName = "category_seq",
        initialValue = 1, allocationSize = 1)
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    Long id;

    String name;
    
    @OneToMany(mappedBy="category")
    List<Product> products;

}