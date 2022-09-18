package com.bada.miguel.challengebackendjavaspringboot.service.impl;

import com.bada.miguel.challengebackendjavaspringboot.model.Usuario;
import com.bada.miguel.challengebackendjavaspringboot.model.exception.UserNotFoundException;
import com.bada.miguel.challengebackendjavaspringboot.model.exception.UsernameNotFoundException;
import com.bada.miguel.challengebackendjavaspringboot.repository.UsuarioRepository;
import com.bada.miguel.challengebackendjavaspringboot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Optional<Usuario> findUsuarioByNombre(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Usuario updateUsuario(UUID id, Usuario usuarioUpdate) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new UserNotFoundException("No se pudo encontrar al usuario con el id " + id));

        usuario.setUsername(usuarioUpdate.getUsername());
        usuario.setPassword(usuarioUpdate.getPassword());

        return repository.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        repository.delete(usuario);
    }

}
