package com.geekshubsacademy.junit.v11;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidadorDNITest {

	@Test
	public void lasPrimeras8PosicionesDebeSerDigitos() {
		assertTrue(ValidadorDNI.validar("12345678Z"));
	}

}
