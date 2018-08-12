package com.ale.curso.spring.backend.builders;

import com.ale.curso.spring.backend.domain.Categoria;

import java.util.Optional;

public class CategoriaBuilder {

    private Categoria categria;
    private CategoriaBuilder() { }

    public static CategoriaBuilder umaCategoria() {
        CategoriaBuilder categoriaBuilder = new CategoriaBuilder();
        categoriaBuilder.categria = new Categoria(null, "foo");
        return categoriaBuilder;
    }

    public Categoria agora() {
        return categria;
    }

    public Optional<Categoria> wapperPorOptionalAgora() {
        return Optional.of(categria);
    }

    public CategoriaBuilder comId(int i) {
        categria.setId(i);
        return this;
    }
}
