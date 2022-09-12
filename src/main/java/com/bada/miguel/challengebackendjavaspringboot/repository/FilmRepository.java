package com.bada.miguel.challengebackendjavaspringboot.repository;

import com.bada.miguel.challengebackendjavaspringboot.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query(value = "SELECT f FROM Film f WHERE f.titulo LIKE %:name%")
    ArrayList<Film> findAllFilmsByNombre(@Param("name") String name);
}
