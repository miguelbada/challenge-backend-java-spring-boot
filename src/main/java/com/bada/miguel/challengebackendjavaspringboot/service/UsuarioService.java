package com.bada.miguel.challengebackendjavaspringboot.service;

import com.bada.miguel.challengebackendjavaspringboot.model.Usuario;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {
    Usuario saveUsuario(Usuario usuario);
    Optional<Usuario> findUsuarioByNombre(String username);
    Usuario updateUsuario(UUID id, Usuario usuario);
    void deleteUsuario(Usuario usuario);
}
