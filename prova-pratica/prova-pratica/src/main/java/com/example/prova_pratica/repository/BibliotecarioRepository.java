package com.example.prova_pratica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.prova_pratica.model.Bibliotecario;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
}
