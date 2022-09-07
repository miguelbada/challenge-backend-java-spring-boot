package com.bada.miguel.challengebackendjavaspringboot.service.impl;

import com.bada.miguel.challengebackendjavaspringboot.model.Genero;
import com.bada.miguel.challengebackendjavaspringboot.repository.GeneroRepository;
import com.bada.miguel.challengebackendjavaspringboot.service.GeneroService;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {
    @Autowired
    private GeneroRepository repository;

    @Override
    public ArrayList<Genero> getAllGeneros() {
        return (ArrayList<Genero>) repository.findAll();
    }

    @Override
    public Genero saveGenero(Genero genero) {
        return repository.save(genero);
    }

    @Override
    public Optional<Genero> getGeneroById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteGenero(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Genero updateGenero(Long id, Genero generoUpdate) {
        Optional<Genero> option = repository.findById(id);

        return option.map(genero -> {
            genero.setNombre(generoUpdate.getNombre());
            genero.setImagen(generoUpdate.getImagen());

            return repository.save(genero);
        }).orElse(null);
    }
}
