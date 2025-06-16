package com.example.prova_pratica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.prova_pratica.model.Livro;
import com.example.prova_pratica.repository.LivroRepository;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins = "*")
public class LivroController {

    @Autowired
    private LivroRepository repo;

    @GetMapping
    public List<Livro> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro) {
        return repo.save(livro);
    }

    @PutMapping("/{id}")
    public Livro editar(@PathVariable Long id, @RequestBody Livro novo) {
        novo.setId(id);
        return repo.save(novo);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
