package com.bada.miguel.challengebackendjavaspringboot.model.Dto;

import com.bada.miguel.challengebackendjavaspringboot.model.Personaje;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class PersonajeDtoTest {
    private ModelMapper modelMapper;
    private Personaje personaje;
    private PersonajeDto personajeDto;

    @Before
    public void setUp() {
        modelMapper = new ModelMapper();
        personaje = new Personaje();
        personajeDto = new PersonajeDto();
    }
    @Test
    public void convertPersonajeEntityToPersonajeDto() {
        personaje.setImagen("https://imagen.com");
        personaje.setNombre("Miguel Bada");

        personajeDto = modelMapper.map(personaje, PersonajeDto.class);

        assertEquals(personaje.getImagen(), personajeDto.getImagen());
        assertEquals(personaje.getNombre(), personajeDto.getNombre());
    }

    @Test
    public void convertPersonajeDtoToPersonajeEntity() {
        personajeDto.setImagen("https://imagenDto");
        personajeDto.setNombre("Miguel Bada Dto");

        personaje = modelMapper.map(personajeDto, Personaje.class);

        assertEquals(personajeDto.getImagen(), personaje.getImagen());
        assertEquals(personajeDto.getNombre(), personaje.getNombre());
    }
}
