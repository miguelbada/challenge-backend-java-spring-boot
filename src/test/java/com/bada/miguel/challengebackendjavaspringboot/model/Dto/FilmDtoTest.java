package com.bada.miguel.challengebackendjavaspringboot.model.Dto;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

public class FilmDtoTest {
    private ModelMapper modelMapper;
    private Film film;
    private FilmDto filmDto;

    @Before
    public void setUp() {
        modelMapper = new ModelMapper();
        film = new Film();
        filmDto = new FilmDto();
    }

    @Test
    public void convertFilmEntityToFilmDto() {
        film.setImagen("https://imagen.com");
        film.setTitulo("Hawkeye");
        film.setFechaCreacion(Date.valueOf("2021-11-24"));

        filmDto = modelMapper.map(film, FilmDto.class);

        assertEquals(film.getImagen(), filmDto.getImagen());
        assertEquals(film.getTitulo(), filmDto.getTitulo());
        assertEquals(film.getFechaCreacion(), filmDto.getFechaCreacion());
    }

    @Test
    public void convertFilmDtoToFilmEntity() {
        filmDto.setImagen("https://imagenDto.com");
        filmDto.setTitulo("HawkeyeDto");
        filmDto.setFechaCreacion(Date.valueOf("2021-11-22"));

        film = modelMapper.map(filmDto, Film.class);

        assertEquals(filmDto.getImagen(), film.getImagen());
        assertEquals(filmDto.getTitulo(), film.getTitulo());
        assertEquals(filmDto.getFechaCreacion(), filmDto.getFechaCreacion());
    }
}
