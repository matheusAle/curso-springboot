package com.ale.curso.spring.backend.services;

import com.ale.curso.spring.backend.domain.Categoria;
import com.ale.curso.spring.backend.exceptions.CategoriaException;
import com.ale.curso.spring.backend.repositores.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    public CategoriaService() {}

    public Categoria obterPorID(Integer id) throws CategoriaException.NaoEncontrada {
        return repository.findById(id)
                .orElseThrow(() -> new CategoriaException.NaoEncontrada());
    }

}
