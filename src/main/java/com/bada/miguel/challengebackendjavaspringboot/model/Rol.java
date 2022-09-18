package com.bada.miguel.challengebackendjavaspringboot.model;

import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Rol implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RolType nombre;


    @Override
    public String getAuthority() {
        return this.nombre.toString();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RolType getNombre() {
        return nombre;
    }

    public void setNombre(RolType nombre) {
        this.nombre = nombre;
    }
}
