package com.ale.curso.spring.backend.repositores;

import com.ale.curso.spring.backend.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> { }
