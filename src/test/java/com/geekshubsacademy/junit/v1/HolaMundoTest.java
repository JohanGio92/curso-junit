package com.geekshubsacademy.junit.v1;

import static org.junit.Assert.*;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class HolaMundoTest {

	@Test
	public void esteTestFalla() {
		fail("Not yet implemented");
	}

	@Test
	public void esteTestRompe() throws Exception {
		throw new Exception("Este test rompe");
	}

	@Test
	public void esteTestPasa() {
		int resultado = suma(1, 2);
		assertEquals(3, resultado);
	}

	public int suma(int a, int b) {
		return a + b;
	}
}
