package com.bada.miguel.challengebackendjavaspringboot.model.Dto;

import java.sql.Date;

public class FilmDto {
    private String imagen;
    private String titulo;
    private Date fechaCreacion;

    public FilmDto() {
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
}
