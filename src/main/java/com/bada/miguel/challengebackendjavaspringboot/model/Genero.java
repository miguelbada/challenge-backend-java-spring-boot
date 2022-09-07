package com.bada.miguel.challengebackendjavaspringboot.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String imagen;

    @ManyToMany
    @JoinTable(
        name="genero_film",
        joinColumns = @JoinColumn(name = "genero_id"),
        inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> filmaciones;

    public Genero() {
        this.filmaciones = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Film> getFilmaciones() {
        return filmaciones;
    }

    public void setFilmaciones(List<Film> filmaciones) {
        this.filmaciones = filmaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(id, genero.id) && Objects.equals(nombre, genero.nombre) && Objects.equals(imagen, genero.imagen) && Objects.equals(filmaciones, genero.filmaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, imagen, filmaciones);
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", filmaciones=" + filmaciones +
                '}';
    }
}
