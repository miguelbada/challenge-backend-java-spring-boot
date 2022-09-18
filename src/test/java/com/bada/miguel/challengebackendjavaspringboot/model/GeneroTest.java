package com.bada.miguel.challengebackendjavaspringboot.model;

import com.bada.miguel.challengebackendjavaspringboot.service.GeneroService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroTest {

    @Autowired
    GeneroService service;

    private Genero genero;

    @Before
    public void setUp() {
        genero = new Genero();
        genero.setNombre("Aventura");
        genero.setImagen("imagen de aventura");
    }

    @Test
    public void crearGenero() {
        Genero generoSaved = service.saveGenero(genero);

        assertEquals(generoSaved.getImagen(), genero.getImagen());
        assertEquals(generoSaved.getNombre(), genero.getNombre());

        service.deleteGenero(generoSaved.getId());
    }

}
