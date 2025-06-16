package com.example.prova_pratica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prova_pratica.model.Bibliotecario;
import com.example.prova_pratica.repository.BibliotecarioRepository;

@Service
public class BibliotecarioService {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    // Lista todos os bibliotecários
    public List<Bibliotecario> listar() {
        return bibliotecarioRepository.findAll();
    }

    // Salva ou atualiza um bibliotecário
    public Bibliotecario salvar(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    // Busca bibliotecário pelo ID
    public Optional<Bibliotecario> buscarPorId(Long id) {
        return bibliotecarioRepository.findById(id);
    }

    // Verifica se um bibliotecário existe pelo ID
    public boolean existePorId(Long id) {
        return bibliotecarioRepository.existsById(id);
    }

    // Deleta um bibliotecário pelo ID
    public void deletar(Long id) {
        bibliotecarioRepository.deleteById(id);
    }
}
