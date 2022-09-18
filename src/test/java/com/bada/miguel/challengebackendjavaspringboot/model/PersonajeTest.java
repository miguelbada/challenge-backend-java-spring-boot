package com.bada.miguel.challengebackendjavaspringboot.model;

import com.bada.miguel.challengebackendjavaspringboot.service.PersonajeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonajeTest {

    @Autowired
    PersonajeService service;

    private Personaje chris;

    @Before
    public void setUp() {
        chris = new Personaje();
        chris.setImagen("https://upload.wikimedia.org/wikipedia/commons/e/e8/Chris_Hemsworth_by_Gage_Skidmore_2_%28cropped%29.jpg");
        chris.setNombre("Chris Hemsworth");
        chris.setEdad(39);
        chris.setPeso(91.0);
        chris.setHistoria("Conocido simplemente como Chris Hemsworth, es un actor, actor de voz y productor australiano.");

    }

    @Test
    public void creacionDePersonaje() {
        Personaje personajeSaved = service.savePersonaje(chris);

        assertEquals(personajeSaved.getImagen(), chris.getImagen());
        assertEquals(personajeSaved.getNombre(), chris.getNombre());
        assertEquals( personajeSaved.getEdad(), chris.getEdad(), 0.0);
        assertEquals(personajeSaved.getPeso(), chris.getPeso(), 0.0);
        assertEquals( personajeSaved.getHistoria(), chris.getHistoria());

        service.deletePersonaje(personajeSaved.getId());
    }

}
