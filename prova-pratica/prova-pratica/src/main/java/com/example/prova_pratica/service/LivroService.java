package com.example.prova_pratica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prova_pratica.model.Livro;
import com.example.prova_pratica.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // Lista todos os livros
    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    // Salva ou atualiza um livro
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    // Busca livro pelo ID
    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    // Verifica se um livro existe pelo ID
    public boolean existePorId(Long id) {
        return livroRepository.existsById(id);
    }

    // Deleta um livro pelo ID
    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
