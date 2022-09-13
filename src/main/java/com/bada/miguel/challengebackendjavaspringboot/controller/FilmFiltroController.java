package com.bada.miguel.challengebackendjavaspringboot.controller;

import com.bada.miguel.challengebackendjavaspringboot.model.Dto.FilmDto;
import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import com.bada.miguel.challengebackendjavaspringboot.service.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class FilmFiltroController {
    @Autowired
    private FilmService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<FilmDto>> findAllFilms() {
        List<Film> films = service.getAllFilms();

        return ResponseEntity.ok().body(films.stream().map(this::convertToFilmDto).collect(Collectors.toList()));
    }

    @GetMapping(value = "", params = "name")
    public ResponseEntity<List<FilmDto>> findAllFilmsByName(@RequestParam(name = "name", required = false) String titulo, @RequestParam(name = "order", defaultValue = "asc", required = false) String sortOrder) {
        List<Film> films = service.findAllFilmsByName(titulo, sortOrder);

        return ResponseEntity.ok().body(films.stream().map(this::convertToFilmDto).collect(Collectors.toList()));
    }

    @GetMapping(value = "", params = "genre")
    public ResponseEntity<List<FilmDto>> findAllFilmsByGenre(@RequestParam(name = "genre", required = false) Long id) {
        List<Film> films = service.findAllFilmsByGenero(id);

        return ResponseEntity.ok().body(films.stream().map(this::convertToFilmDto).collect(Collectors.toList()));
    }

    @PostMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Film> addPersonaje(@PathVariable Long idMovie, @PathVariable Long idCharacter) {
        return ResponseEntity.ok().body(service.addPersonaje(idMovie, idCharacter));
    }

    @DeleteMapping("/{idMovie}/characters/{idCharacter}")
    public void deletePersonaje(@PathVariable Long idMovie, @PathVariable Long idCharacter) {
        service.deletePersonaje(idMovie, idCharacter);
    }

    private FilmDto convertToFilmDto(Film film) {
        return modelMapper.map(film, FilmDto.class);
    }
}
