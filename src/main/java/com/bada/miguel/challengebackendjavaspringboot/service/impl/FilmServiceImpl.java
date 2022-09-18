package com.bada.miguel.challengebackendjavaspringboot.service.impl;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import com.bada.miguel.challengebackendjavaspringboot.model.Genero;
import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;
import com.bada.miguel.challengebackendjavaspringboot.repository.FilmRepository;
import com.bada.miguel.challengebackendjavaspringboot.repository.GeneroRepository;
import com.bada.miguel.challengebackendjavaspringboot.repository.PersonajeRepository;
import com.bada.miguel.challengebackendjavaspringboot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository repository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

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

    @Override
    public List<Film> findAllFilmsByName(String name, String order) {
        List<Film> films = repository.findAllFilmsByNombre(name);
        List<Film> filmsOrder = new ArrayList<>();

        if(order.equalsIgnoreCase("asc")) {
            filmsOrder = films.stream().sorted(Comparator.comparing(Film::getFechaCreacion)).collect(Collectors.toList());
        } else if(order.equalsIgnoreCase("desc")) {
            filmsOrder = films.stream().sorted(Comparator.comparing(Film::getFechaCreacion).reversed()).collect(Collectors.toList());
        }

        return filmsOrder;
    }

    @Override
    public List<Film> findAllFilmsByGenero(Long id) {
        List<Film> films = new ArrayList<>();
        Optional<Genero> genero = generoRepository.findById(id);

        if(genero.isPresent()) {
            films = genero.get().getFilmaciones();
        }

        return films;
    }

    @Override
    public Film addPersonaje(Long idFilm, Long idPersonaje) {
        Optional<Film> optioalFilm = repository.findById(idFilm);
        Optional<Personaje> optionalPersonaje = personajeRepository.findById(idPersonaje);

        if(optioalFilm.isPresent() && optionalPersonaje.isPresent()) {
            Film film = optioalFilm.get();
            Personaje personaje = optionalPersonaje.get();

            personaje.addFilmacion(film);
            film.addPersonaje(personaje);
            repository.save(film);
            personajeRepository.save(personaje);

            return film;
        } else {
            return null;
        }

    }

    @Override
    public void deletePersonaje(Long idFilm, Long idPersonaje) {
        Optional<Film> optioalFilm = repository.findById(idFilm);
        Optional<Personaje> optionalPersonaje = personajeRepository.findById(idPersonaje);

        if(optioalFilm.isPresent() && optionalPersonaje.isPresent()) {
            Film film = optioalFilm.get();
            Personaje personaje = optionalPersonaje.get();

            film.deletePersonaje(personaje);
            repository.save(film);
        }
    }
}
