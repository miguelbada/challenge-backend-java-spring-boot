package com.bada.miguel.challengebackendjavaspringboot.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonajeTest {
    private Personaje Chris = new Personaje();
    //private Pelicula thorRagnarok = new Pelicula();
   // private Serie got = new Serie();

    @Before
    public void setUp() {
        Chris.setImagen("https://upload.wikimedia.org/wikipedia/commons/e/e8/Chris_Hemsworth_by_Gage_Skidmore_2_%28cropped%29.jpg");
        Chris.setNombre("Chris Hemsworth");
        Chris.setEdad(39);
        Chris.setPeso(91.0);
        Chris.setHistoria("Conocido simplemente como Chris Hemsworth, es un actor, actor de voz y productor australiano.");

        //thorRagnarok.setImagen("https://pics.filmaffinity.com/thor_ragnarok-115636540-mmed.jpg");
        //got.setImagen("https://pics.filmaffinity.com/game_of_thrones-293142110-large.jpg");
    }

    @Test
    public void creacionDePersonaje() {

        assertEquals("El link de la imagen debería ser ", "https://upload.wikimedia.org/wikipedia/commons/e/e8/Chris_Hemsworth_by_Gage_Skidmore_2_%28cropped%29.jpg", Chris.getImagen());
        assertEquals("El nombre debería ser ", "Chris Hemsworth", Chris.getNombre());
        assertEquals("La edad debería ser ", 39, Chris.getEdad(), 0.0);
        assertEquals("El peso debería ser ", 91.0,Chris.getPeso(), 0.0);
        assertEquals("La historia debería ser ", "Conocido simplemente como Chris Hemsworth, es un actor, actor de voz y productor australiano.", Chris.getHistoria());
    }

    @Test
    public void agragarUnaPelicula() {

    }
}
