package com.geekshubsacademy.junit.v7;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestSimpleTest {

	@Test
	public void testComparacionDeNumerosDePuntoFlotante() {
		// PI ~ 3 ± 0.2
	    assertThat(Math.PI, closeTo(3, 0.2));
	}

	@Test
	public void testComparacionTexto() {
	    assertThat("El Principito", equalToIgnoringCase("el principito"));
	}
	
	@Test
	public void testColecciones() {
		List<String> collection = Arrays.asList("ab", "cd", "ef");
		assertThat(collection, hasItem("cd"));
		assertThat(collection, not(hasItem("zz")));
	}
}
