package com.bada.miguel.challengebackendjavaspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Transactional
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;

    @ManyToMany(mappedBy = "personajesAsociados", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("personajesAsociados")
    private List<Film> filmaciones;

    public Personaje() {
        this.filmaciones = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public List<Film> getFilmaciones() {
        return filmaciones;
    }

    public void setFilmaciones(List<Film> filmaciones) {
        this.filmaciones = filmaciones;
    }

    public void addFilmacion(Film film) {
        if(!this.filmaciones.contains(film)) {
            this.filmaciones.add(film);
        }
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", historia='" + historia + '\'' +
                ", filmaciones=" + filmaciones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(id, personaje.id) && Objects.equals(imagen, personaje.imagen) && Objects.equals(nombre, personaje.nombre) && Objects.equals(edad, personaje.edad) && Objects.equals(peso, personaje.peso) && Objects.equals(historia, personaje.historia) && Objects.equals(filmaciones, personaje.filmaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imagen, nombre, edad, peso, historia, filmaciones);
    }
}
