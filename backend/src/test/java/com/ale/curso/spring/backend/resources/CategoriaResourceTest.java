package com.ale.curso.spring.backend.resources;

import com.ale.curso.spring.backend.builders.CategoriaBuilder;
import com.ale.curso.spring.backend.domain.Categoria;
import com.ale.curso.spring.backend.exceptions.CategoriaException;
import com.ale.curso.spring.backend.services.CategoriaService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/* PACOE QUE CONTEM OS MATHERS DE ASSERÇÃO PARA RESPSOTAS REST */
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoriaResource.class)
public class CategoriaResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoriaService service;

    @Test
    public void deveRetornarUmaListaDecategorias() throws Exception {
        Categoria categoria = CategoriaBuilder.umaCategoria().comId(1).agora();
        Mockito.doReturn(categoria).when(service).obterPorID(1);

        mvc.perform(get("/categorias/1"))
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void deveRetornar404AoBuscarUmaCAtegoariaQueNaoExiste() throws Exception {
        Mockito.doThrow(CategoriaException.NaoEncontrada.class).when(service).obterPorID(1);

        mvc.perform(get("/categorias/1"))
                .andExpect(content().string(""))
                .andExpect(status().isNotFound());
    }
}