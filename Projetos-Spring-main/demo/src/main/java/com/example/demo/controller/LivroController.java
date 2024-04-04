package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping
    public List<Livro> listarLivros () {
        return livroService.listarLivros();
    }

    @PostMapping
    public Livro criar(@Valid @RequestBody Livro livro) {
        return livroService.criar(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        if(livroService.atualizar(id, livro) == null) {

            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(livroService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/livroMaiscaro")
    public Livro buscarLivroMaisCaro() {return livroService.buscarLivroMaisCaro();}

    @GetMapping("/buscarPorNome")
    public List<Livro> buscarPorNome(@RequestParam String nome) {
        return livroService.buscarPorNome(nome);
    }
}
