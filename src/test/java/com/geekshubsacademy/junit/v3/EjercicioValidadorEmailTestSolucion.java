package com.geekshubsacademy.junit.v3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Escribe tests para indagar cómo de bien funciona 
 * la clase ValidadorEmail que está en este mismo paquete.
 * @author random
 *
 */
public class EjercicioValidadorEmailTestSolucion {
	
	ValidadorEmail validador = ValidadorEmail.getInstance();

	@After
	public void after() {
		validador.reset();
	}
	
	@Test
	public void emailValido() {
		assertTrue(validador.validarEmail("email@valido.com"));
	}

	@Test
	public void dominioSinTLD() {
		assertFalse(validador.validarEmail("email@novalido"));
	}

	@Test
	public void dominioTerminadoEnPunto() {
		assertFalse(validador.validarEmail("email@novalido."));
	}
}
