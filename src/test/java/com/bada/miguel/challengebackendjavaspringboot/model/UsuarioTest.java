package com.bada.miguel.challengebackendjavaspringboot.model;

import com.bada.miguel.challengebackendjavaspringboot.service.UsuarioService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {

    @Autowired
    UsuarioService service;

    @Autowired
    private PasswordEncoder encoder;

    private Usuario usuario;

    @Before
    public void setUp() {
        usuario = new Usuario();
    }

    @After
    public void tearDown() {
        service.findUsuarioByNombre("Miguel Enrique Bada").ifPresent(user -> service.deleteUsuario(user) );
        service.findUsuarioByNombre("Noemi Nagel").ifPresent(user -> service.deleteUsuario(user) );
    }

    @Test
    public void crearUsuarioTest() {
        usuario.setUsername("Miguel Enrique Bada");
        usuario.setPassword(encoder.encode("789"));

        Usuario usuarioSaved = service.saveUsuario(usuario);

        assertEquals(usuarioSaved.getUsername(), usuario.getUsername());
        assertEquals(usuarioSaved.getPassword(), usuario.getPassword());
    }

    @Test
    public void actualizarUsuario() {
        usuario.setUsername("Nancy Nagel");
        usuario.setPassword(encoder.encode("123"));

        Usuario usuarioParaActualizar = new Usuario();
        usuarioParaActualizar.setUsername("Noemi Nagel");
        usuarioParaActualizar.setPassword("321");

        service.saveUsuario(usuario);
        Usuario usuarioActualizado = service.updateUsuario(usuario.getId(), usuarioParaActualizar);

        assertEquals(usuarioParaActualizar.getUsername(), usuarioActualizado.getUsername());
        assertEquals(usuarioParaActualizar.getPassword(), usuarioActualizado.getPassword());
    }

}
