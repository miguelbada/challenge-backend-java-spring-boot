package com.bada.miguel.challengebackendjavaspringboot.repository;

import com.bada.miguel.challengebackendjavaspringboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByUsername(String username);
}
