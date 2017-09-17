package com.geekshubsacademy.junit.v9;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class RulesTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Test
	public void capturaSystemOut() {
		System.out.print("hello world");
		assertEquals("hello world", systemOutRule.getLog());
	}

	@Test
	public void testNegativo() {
		System.out.print("un texto distinto");
		assertThat(systemOutRule.getLog(), not(containsString("hello world")));
	}

}