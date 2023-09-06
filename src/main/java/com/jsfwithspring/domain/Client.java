package com.jsfwithspring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Client implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    private String email;

}
