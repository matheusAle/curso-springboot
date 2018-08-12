package com.ale.curso.spring.backend.services;

import com.ale.curso.spring.backend.builders.CategoriaBuilder;
import com.ale.curso.spring.backend.domain.Categoria;
import com.ale.curso.spring.backend.exceptions.CategoriaException;
import com.ale.curso.spring.backend.repositores.CategoriaRepository;
import jdk.nashorn.internal.runtime.regexp.joni.Matcher;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaServiceTest {

    @Autowired
    public CategoriaService service;

    @MockBean
    public CategoriaRepository repository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void obterCategoriaPorID() throws CategoriaException.NaoEncontrada {
        Mockito.doReturn(CategoriaBuilder.umaCategoria().comId(1).wapperPorOptionalAgora())
                .when(repository).findById(1);

        Categoria categoria = service.obterPorID(1);
        assertThat(categoria.getId(), is(equalTo(1)));
    }

    @Test
    public void obterErroAoBuscarUmaCategoriaQueNaoExiste() throws CategoriaException.NaoEncontrada {
        Mockito.doReturn(Optional.empty())
                .when(repository).findById(1);
        expectedException.expect(CategoriaException.NaoEncontrada.class);

        service.obterPorID(1);

    }

}