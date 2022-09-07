package com.bada.miguel.challengebackendjavaspringboot.service;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import com.bada.miguel.challengebackendjavaspringboot.model.Genero;

import java.util.ArrayList;
import java.util.Optional;

public interface FilmService {
    ArrayList<Film> getAllFilms();
    Film saveFilm(Film film);
    Optional<Film> getFilmById(Long id);
    void deleteFilm(Long id);
    Film updateFilm(Long id, Film film);
}
