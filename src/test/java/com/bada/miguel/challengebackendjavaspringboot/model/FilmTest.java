package com.bada.miguel.challengebackendjavaspringboot.model;

import com.bada.miguel.challengebackendjavaspringboot.service.FilmService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmTest {

    @Autowired
    FilmService service;

    private Film film;

    @Before
    public void setUp() {
        film = new Film();
        film.setType(FilmType.Pelicula);
        film.setImagen("https://pics.filmaffinity.com/thor_ragnarok-115636540-large.jpg");
        film.setTitulo("Thor Ragnarok");
        film.setFechaCreacion(Date.valueOf("2017-05-07"));
        film.setCalificacion(5);
    }

    @Test
    public void crearFilm() {
        Film filmSaved = service.saveFilm(film);

        assertEquals(filmSaved.getType(), film.getType());
        assertEquals(filmSaved.getImagen(), film.getImagen());
        assertEquals(filmSaved.getTitulo(), film.getTitulo());
        assertEquals(filmSaved.getFechaCreacion(), film.getFechaCreacion());
        assertEquals(filmSaved.getCalificacion(), film.getCalificacion());

        service.deleteFilm(filmSaved.getId());
    }
}
