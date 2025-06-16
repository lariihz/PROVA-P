package com.example.prova_pratica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.prova_pratica.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
