package com.bada.miguel.challengebackendjavaspringboot.service;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface FilmService {
    ArrayList<Film> getAllFilms();
    Film saveFilm(Film film);
    Optional<Film> getFilmById(Long id);
    void deleteFilm(Long id);
    Film updateFilm(Long id, Film film);
    List<Film> findAllFilmsByName(String name, String order);
    List<Film> findAllFilmsByGenero(Long id);
    Film addPersonaje(Long idFilm, Long idPersonaje);
    void deletePersonaje(Long idFilm, Long idPersonaje);
}
