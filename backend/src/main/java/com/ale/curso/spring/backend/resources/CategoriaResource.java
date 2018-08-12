package com.ale.curso.spring.backend.resources;

import com.ale.curso.spring.backend.domain.Categoria;
import com.ale.curso.spring.backend.exceptions.CategoriaException;
import com.ale.curso.spring.backend.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(method = RequestMethod.GET)
    public String listar() {
        return "works";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obter(@PathVariable() Integer id) {
        try {
            Categoria cat = service.obterPorID(id);
            return ResponseEntity.ok().body(cat);
        } catch (CategoriaException.NaoEncontrada naoEncontrada) {
            return ResponseEntity.notFound().build();
        }

    }
}
