package com.bada.miguel.challengebackendjavaspringboot.controller;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;
import com.bada.miguel.challengebackendjavaspringboot.service.FilmService;
import com.bada.miguel.challengebackendjavaspringboot.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class PersonajeFiltroController {
    @Autowired
    private PersonajeService service;

    @Autowired
    private FilmService filmService;

    @GetMapping("")
    public ResponseEntity<List<Personaje>> findAllPersonajes() {
        return ResponseEntity.ok().body(service.getAllPersonajes());
    }

    @GetMapping(value  = "", params = "name")
    public ResponseEntity<List<Personaje>> findAllPersonajesByNombre(@RequestParam(name="name", required = false) String nombre) {
        return ResponseEntity.ok().body(service.getPersonajesByNombre(nombre));
    }

    @GetMapping(value  = "", params = "age")
    public ResponseEntity<List<Personaje>> findAllPersonajesByEdad(@RequestParam(name="age", required = false) Integer edad) {
        return ResponseEntity.ok().body(service.getPersonajesByEdad(edad));
    }

    @GetMapping(value  = "", params = "movies")
    public ResponseEntity<List<Personaje>> findAllPersonajesByMovie(@RequestParam(name="movies", required = false) Long id) {

        Optional<Film> optional = filmService.getFilmById(id);
        List<Personaje> personajes = new ArrayList<>();

        if(optional.isPresent()) {
            personajes = optional.get().getPersonajesAsociados();
        }

        return ResponseEntity.ok().body(personajes);
    }
}
