package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente extends Pessoa{

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String idade) {
        super(nome, cpf, idade);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
