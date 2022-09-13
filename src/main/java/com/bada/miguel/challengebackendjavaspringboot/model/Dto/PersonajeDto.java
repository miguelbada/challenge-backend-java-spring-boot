package com.bada.miguel.challengebackendjavaspringboot.model.Dto;

import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.PercentEscaper;

public class PersonajeDto {
    private String imagen;
    private String nombre;

    public PersonajeDto() {
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
}
