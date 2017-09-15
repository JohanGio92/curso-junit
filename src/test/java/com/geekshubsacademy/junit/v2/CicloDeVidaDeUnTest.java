package com.geekshubsacademy.junit.v2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CicloDeVidaDeUnTest {
	
	private static String ciclo = "";
	
	@BeforeClass
	public static void beforeClass() {
		ciclo += "@BeforeClass";
		assertEquals("@BeforeClass", ciclo);
	}

	@Before
	public void before() {
		ciclo += " @Before";
		assertEquals("@BeforeClass @Before", ciclo);
	}

	@Test
	public void test() {
		ciclo += " @Test 1";
		assertEquals("@BeforeClass @Before @Test 1", ciclo);
	}

	@After
	public void after() {
		ciclo += " @After";
		assertEquals("@BeforeClass @Before @Test 1 @After", ciclo);
	}

	@AfterClass
	public static void afterClass() {
		ciclo += " @AfterClass";
		assertEquals("@BeforeClass @Before @Test 1 @After @AfterClass", ciclo);
	}

}
