package com.bada.miguel.challengebackendjavaspringboot.controller;

import com.bada.miguel.challengebackendjavaspringboot.model.Dto.PersonajeDto;
import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;
import com.bada.miguel.challengebackendjavaspringboot.service.FilmService;
import com.bada.miguel.challengebackendjavaspringboot.service.PersonajeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/characters")
public class PersonajeFiltroController {
    @Autowired
    private PersonajeService service;

    @Autowired
    private FilmService filmService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<PersonajeDto>> findAllPersonajes() {
        List<Personaje> personajes= service.getAllPersonajes();

        return ResponseEntity.ok().body(personajes.stream().map(this::convertToPersonajeDto).collect(Collectors.toList()));
    }

    @GetMapping(value  = "", params = "name")
    public ResponseEntity<List<PersonajeDto>> findAllPersonajesByNombre(@RequestParam(name="name", required = false) String nombre) {
        List<Personaje> personajes = service.getPersonajesByNombre(nombre);

        return ResponseEntity.ok().body(personajes.stream().map(this::convertToPersonajeDto).collect(Collectors.toList()));
    }

    @GetMapping(value  = "", params = "age")
    public ResponseEntity<List<PersonajeDto>> findAllPersonajesByEdad(@RequestParam(name="age", required = false) Integer edad) {
        List<Personaje> personajes = service.getPersonajesByEdad(edad);

        return ResponseEntity.ok().body(personajes.stream().map(this::convertToPersonajeDto).collect(Collectors.toList()));
    }

    @GetMapping(value  = "", params = "movies")
    public ResponseEntity<List<PersonajeDto>> findAllPersonajesByMovie(@RequestParam(name="movies", required = false) Long id) {
        Optional<Film> optional = filmService.getFilmById(id);
        List<Personaje> personajes = new ArrayList<>();

        if(optional.isPresent()) {
            personajes = optional.get().getPersonajesAsociados();
        }

        return ResponseEntity.ok().body(personajes.stream().map(this::convertToPersonajeDto).collect(Collectors.toList()));
    }

    private PersonajeDto convertToPersonajeDto(Personaje personaje) {
        return modelMapper.map(personaje, PersonajeDto.class);
    }

}
