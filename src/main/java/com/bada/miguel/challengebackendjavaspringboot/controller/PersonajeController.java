package com.bada.miguel.challengebackendjavaspringboot.controller;

import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;
import com.bada.miguel.challengebackendjavaspringboot.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {
    @Autowired
    private PersonajeService service;

    @PostMapping("/save")
    public ResponseEntity<Personaje> savePersonaje(@RequestBody Personaje personaje) {
        return ResponseEntity.ok().body(service.savePersonaje(personaje));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Personaje>> getAllPersonajes() {
        return ResponseEntity.ok().body(service.getAllPersonajes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personaje> getPersonajeById(@PathVariable Long id) {
        return ResponseEntity.of(service.getPersonajeById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Personaje> updatePersonaje(@PathVariable Long id, @RequestBody Personaje personajeUpdate) {
        Personaje update = service.updatePersonaje(id, personajeUpdate);

        if(update != null) {
            return ResponseEntity.ok().body(update);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonaje(@PathVariable Long id) {
        service.deletePersonaje(id);
    }
}
