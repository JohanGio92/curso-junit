package com.geekshubsacademy.junit.v0;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;


public class EstructuraDeUnTest {

	/**
	 * Estructura clásica de un Test (AAA en inglés).
	 * - Arrange (Preparar)
	 * - Act (Probar)
	 * - Assert (Verificar) 
	 */
	@Test
	public void test() {
		// Preparar
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Calendar calendario = Calendar.getInstance();
		calendario.set(2017, 8, 15);
		
		// Probar
		String fechaConFormato = dateFormat.format(calendario.getTime());
		
		// Verificar
		assertEquals("15/09/2017", fechaConFormato);
	}

}
