package com.beta.coffee.betacoffee.models;

import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "request_seq", sequenceName = "request_seq",
        initialValue = 1, allocationSize = 1)
public class Request{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_seq")
    Long id;

    String nameUser;

    String email;

    String cpf;

    String telefone;

    Boolean prepared;

    @ManyToMany
    @JoinTable(
        name = "request_product",
        joinColumns = @JoinColumn(name = "request_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;

}