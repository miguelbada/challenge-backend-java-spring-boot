package com.bada.miguel.challengebackendjavaspringboot.controller;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import com.bada.miguel.challengebackendjavaspringboot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService service;

    @PostMapping("/save")
    public ResponseEntity<Film> saveFilm(@RequestBody Film film) {
        return ResponseEntity.ok().body(service.saveFilm(film));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Film>> getAllFims() {
        return ResponseEntity.ok().body(service.getAllFilms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        return ResponseEntity.of(service.getFilmById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        Film update = service.updateFilm(id, film);

        if(update != null) {
            return ResponseEntity.ok().body(update);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFilm(@PathVariable Long id) {
        service.deleteFilm(id);
    }
}
