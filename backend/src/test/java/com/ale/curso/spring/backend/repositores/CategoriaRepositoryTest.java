package com.ale.curso.spring.backend.repositores;

import com.ale.curso.spring.backend.builders.CategoriaBuilder;
import com.ale.curso.spring.backend.domain.Categoria;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoriaRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void deveSalvarUmaNovaCategoria() {
        Categoria categoria = CategoriaBuilder.umaCategoria().agora();

        Categoria persistReturn = testEntityManager.persist(categoria);
        testEntityManager.flush();
        Categoria categoriaNoBanco = categoriaRepository.findById(categoria.getId()).get();

        Assert.assertThat(persistReturn, is(equalTo(categoria)));
        Assert.assertThat(categoriaNoBanco, is(equalTo(categoria)));
    }

}