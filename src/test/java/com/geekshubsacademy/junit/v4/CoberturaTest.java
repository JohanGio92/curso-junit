package com.geekshubsacademy.junit.v4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Ejemplo de un Test con 100% de cobertura de la clase Direccion
 * pero que sin embargo no salva de que el método getCodigoPostal()
 * lance un java.lang.NullPointerException si se le pasa una direccion nula.
 * @author mefernandez
 */
public class CoberturaTest {

	@Test
	public void obtenerCodigoPostal() {
		Direccion direccion = new Direccion("Calle Vicente Barrera Cambra 6 bajo (46020)");
		String codigoPostal = direccion.getCodigoPostal();
		assertEquals("46020", codigoPostal);
	}

	@Test
	public void noHayCodigoPostal() {
		Direccion direccion = new Direccion("Calle Vicente Barrera Cambra 6 bajo");
		String codigoPostal = direccion.getCodigoPostal();
		assertNull(codigoPostal);
	}

	@Test(expected = NullPointerException.class)
	public void lanzaExcepcionSiLePasoUnStringNulo() {
		Direccion direccion = new Direccion(null);
		String codigoPostal = direccion.getCodigoPostal();
		assertNull(codigoPostal);
	}

}
