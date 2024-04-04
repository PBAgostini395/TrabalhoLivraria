package com.example.demo.service;

import java.util.Comparator;
import java.util.Optional;
import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro criar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizar(Long id, Livro livro) {
        if(livroRepository.existsById(id)) {
            livro.setId(id);
            return livroRepository.save(livro);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if(livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Livro buscarLivroMaisCaro() {
        List<Livro> livros = livroRepository.findAll();
        Optional<Livro> livroMaisCaro = livros.stream()
                .max(Comparator.comparing(Livro::getPreco));
        return livroMaisCaro.orElse(null);
    }

    public List<Livro> buscarPorNome(String nome) {
        return livroRepository.findByNomeContaining(nome);
    }
}
