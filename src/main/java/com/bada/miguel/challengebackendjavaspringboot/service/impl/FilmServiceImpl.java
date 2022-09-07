package com.bada.miguel.challengebackendjavaspringboot.service.impl;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import com.bada.miguel.challengebackendjavaspringboot.model.Genero;
import com.bada.miguel.challengebackendjavaspringboot.repository.FilmRepository;
import com.bada.miguel.challengebackendjavaspringboot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository repository;

    @Override
    public ArrayList<Film> getAllFilms() {
        return (ArrayList<Film>) repository.findAll();
    }

    @Override
    public Film saveFilm(Film film) {
        return repository.save(film);
    }

    @Override
    public Optional<Film> getFilmById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteFilm(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Film updateFilm(Long id, Film filmUpdate) {
        Optional<Film> option = repository.findById(id);

        return option.map(film -> {
            film.setType(filmUpdate.getType());
            film.setImagen(filmUpdate.getImagen());
            film.setTitulo(filmUpdate.getTitulo());
            film.setFechaCreacion(filmUpdate.getFechaCreacion());
            film.setCalificacion(filmUpdate.getCalificacion());

            return repository.save(film);
        }).orElse(null);
    }
}
