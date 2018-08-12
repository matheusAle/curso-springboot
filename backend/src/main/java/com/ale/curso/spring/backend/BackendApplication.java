package com.ale.curso.spring.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.jmx.export.annotation.ManagedResource;

import javax.annotation.Resources;

@SpringBootApplication
/*@EntityScan("com.ale.curso.spring.backend.domain")
@ComponentScan(basePackages={"com.ale.curso.spring"})*/
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
