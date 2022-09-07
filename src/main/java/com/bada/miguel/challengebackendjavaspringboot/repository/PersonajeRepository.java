package com.bada.miguel.challengebackendjavaspringboot.repository;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Long> {

    @Query(value = "SELECT p FROM Personaje p WHERE p.nombre LIKE %:name%")
    ArrayList<Personaje> findAllPersonajesByNombre(@Param("name") String name);

    @Query(value = "SELECT * FROM personaje WHERE edad = ?1", nativeQuery = true)
    ArrayList<Personaje> findAllPersonajesByEdad(Integer edad);

}
