package com.bada.miguel.challengebackendjavaspringboot.service;

import com.bada.miguel.challengebackendjavaspringboot.model.Genero;
import java.util.ArrayList;
import java.util.Optional;

public interface GeneroService {
    ArrayList<Genero> getAllGeneros();
    Genero saveGenero(Genero genero);
    Optional<Genero> getGeneroById(Long id);
    void deleteGenero(Long id);
    Genero updateGenero(Long id, Genero genero);
}
