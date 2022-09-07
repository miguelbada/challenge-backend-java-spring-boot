package com.bada.miguel.challengebackendjavaspringboot.controller;

import com.bada.miguel.challengebackendjavaspringboot.model.Genero;
import com.bada.miguel.challengebackendjavaspringboot.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    private GeneroService service;

    @GetMapping("/all")
    public ResponseEntity<List<Genero>> getAllGeneros() {
        return ResponseEntity.ok().body(service.getAllGeneros());
    }

    @PostMapping("/save")
    public ResponseEntity<Genero> saveGenero(@RequestBody Genero genero) {
        return ResponseEntity.ok().body(service.saveGenero(genero));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable Long id) {
        return ResponseEntity.of(service.getGeneroById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Genero> updateGenero(@PathVariable Long id, @RequestBody Genero genero) {
        Genero update = service.updateGenero(id, genero);

        if(update != null) {
            return ResponseEntity.ok().body(update);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGenero(@PathVariable Long id) {
        service.deleteGenero(id);
    }
}
