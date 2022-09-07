package com.bada.miguel.challengebackendjavaspringboot.service;

import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PersonajeService {
    ArrayList<Personaje> getAllPersonajes();
    Personaje savePersonaje(Personaje personaje);
    Optional<Personaje> getPersonajeById(Long id);
    void deletePersonaje(Long id);
    Personaje updatePersonaje(Long id, Personaje personaje);
    List<Personaje> getPersonajesByNombre(String nombre);
    List<Personaje> getPersonajesByEdad(Integer edad);
}
