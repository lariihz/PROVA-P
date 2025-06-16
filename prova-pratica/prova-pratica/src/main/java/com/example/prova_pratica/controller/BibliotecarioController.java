package com.example.prova_pratica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.prova_pratica.model.Bibliotecario;
import com.example.prova_pratica.service.BibliotecarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bibliotecarios")
@CrossOrigin(origins = "*")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioService service;

    @GetMapping
    public List<Bibliotecario> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Bibliotecario> cadastrar(@RequestBody Bibliotecario biblio) {
        Bibliotecario salvo = service.salvar(biblio);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Bibliotecario novo) {
        Optional<Bibliotecario> existente = service.buscarPorId(id);
        if (!existente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        novo.setId(id);
        Bibliotecario atualizado = service.salvar(novo);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        Optional<Bibliotecario> existente = service.buscarPorId(id);
        if (!existente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
