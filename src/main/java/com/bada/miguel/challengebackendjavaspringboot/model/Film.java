package com.bada.miguel.challengebackendjavaspringboot.model;

import javax.persistence.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FilmType type;

    private String imagen;
    private String titulo;

    @Basic
    private Date fechaCreacion;

    private Integer calificacion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "film_personaje",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private List<Personaje> personajesAsociados;

    public Film() {
        this.personajesAsociados = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FilmType getType() {
        return type;
    }

    public void setType(FilmType type) {
        this.type = type;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public List<Personaje> getPersonajesAsociados() {
        return  personajesAsociados;
    }

    public void setPersonajesAsociados(List<Personaje> personajesAsociados) {
        this.personajesAsociados = personajesAsociados;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", type=" + type +
                ", imagen='" + imagen + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", calificacion=" + calificacion +
                ", personajesAsociados=" + personajesAsociados +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) && type == film.type && Objects.equals(imagen, film.imagen) && Objects.equals(titulo, film.titulo) && Objects.equals(fechaCreacion, film.fechaCreacion) && Objects.equals(calificacion, film.calificacion) && Objects.equals(personajesAsociados, film.personajesAsociados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, imagen, titulo, fechaCreacion, calificacion, personajesAsociados);
    }
}
