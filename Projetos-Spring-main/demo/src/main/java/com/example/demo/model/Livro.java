package com.example.demo.model;

import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String editora;

    private String autor;

    private double preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Livro() {
    }

    public Livro(Long id, String nome, String editora, String autor, double preco) {
        this.id = id;
        this.nome = nome;
        this.editora = editora;
        this.autor = autor;
        this.preco = preco;
    }
}
