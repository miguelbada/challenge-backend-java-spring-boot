package com.bada.miguel.challengebackendjavaspringboot.controller;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;
import com.bada.miguel.challengebackendjavaspringboot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class FilmFiltroController {
    @Autowired
    private FilmService service;

    @GetMapping("")
    public ResponseEntity<List<Film>> findAllFilms() {
        return ResponseEntity.ok().body(service.getAllFilms());
    }

    @GetMapping(value = "", params = "name")
    public ResponseEntity<List<Film>> findAllFilmsByName(@RequestParam(name = "name", required = false) String titulo, @RequestParam(name = "order", defaultValue = "asc", required = false) String sortOrder) {
        return ResponseEntity.ok().body(service.findAllFilmsByName(titulo, sortOrder));
    }

    @GetMapping(value = "", params = "genre")
    public ResponseEntity<List<Film>> findAllFilmsByGenre(@RequestParam(name = "genre", required = false) Long id) {
        return ResponseEntity.ok().body(service.findAllFilmsByGenero(id));
    }

    @PostMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Film> addPersonaje(@PathVariable Long idMovie, @PathVariable Long idCharacter) {
        return ResponseEntity.ok().body(service.addPersonaje(idMovie, idCharacter));
    }

    @DeleteMapping("/{idMovie}/characters/{idCharacter}")
    public void deletePersonaje(@PathVariable Long idMovie, @PathVariable Long idCharacter) {
        service.deletePersonaje(idMovie, idCharacter);
    }
}
