package com.geekshubsacademy.junit.v1;

import static org.junit.Assert.*;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class ResultadosDeUnTest {

	@Test
	public void esteTestRompe() throws Exception {
		throw new Exception("Este test rompe");
	}

	@Test
	public void esteTestFalla() {
		assertEquals(3, 1+1);
	}

	@Test
	public void esteTestPasa() {
		assertEquals(2, 1+1);
	}

}
