package com.geekshubsacademy.junit.v4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CienPorCienCoberturaConErroresTest {

	@Test
	public void esteTestCubreElCienPorCienDeLaClaseCalculadora() {
		assertEquals(2, Calculadora.dividir(4, 2));
	}

	@Test
	public void sinEmbargoEsteTestLanzaArithmeticExceptionAlDividirPorCero() {
		assertEquals(2, Calculadora.dividir(4, 0));
	}
}
