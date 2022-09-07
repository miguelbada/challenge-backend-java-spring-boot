package com.bada.miguel.challengebackendjavaspringboot.service.impl;

import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;
import com.bada.miguel.challengebackendjavaspringboot.repository.PersonajeRepository;
import com.bada.miguel.challengebackendjavaspringboot.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements PersonajeService {
    @Autowired
    private PersonajeRepository repository;

    @Override
    public ArrayList<Personaje> getAllPersonajes() {
        return (ArrayList<Personaje>) repository.findAll();
    }

    @Override
    public Personaje savePersonaje(Personaje personaje) {
        return repository.save(personaje);
    }

    @Override
    public Optional<Personaje> getPersonajeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deletePersonaje(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Personaje updatePersonaje(Long id, Personaje personajeUpdate) {
        Optional<Personaje> option = repository.findById(id);

        return option.map(personaje -> {
            personaje.setImagen(personajeUpdate.getImagen());
            personaje.setNombre(personajeUpdate.getNombre());
            personaje.setEdad(personajeUpdate.getEdad());
            personaje.setPeso(personajeUpdate.getPeso());
            personaje.setHistoria(personajeUpdate.getHistoria());

            return repository.save(personaje);
        }).orElse(null);
    }

    @Override
    public List<Personaje> getPersonajesByNombre(String nombre) {
        return repository.findAllPersonajesByNombre(nombre);
    }

    @Override
    public List<Personaje> getPersonajesByEdad(Integer edad) {
        return repository.findAllPersonajesByEdad(edad);
    }
}
