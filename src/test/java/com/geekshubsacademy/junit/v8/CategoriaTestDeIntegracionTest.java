package com.geekshubsacademy.junit.v8;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(TestDeIntegracion.class)
public class CategoriaTestDeIntegracionTest {

	@Test
	public void test() {
		System.out.println("Soy un test de integracion");
	}

}
