package com.mealti.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String name;

    private String email;

    private String password;

}
