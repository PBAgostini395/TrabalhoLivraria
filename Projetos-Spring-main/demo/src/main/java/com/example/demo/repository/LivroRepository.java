package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Livro;
import java.util.List;
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByNomeContaining(String nome);
}

