package com.geekshubsacademy.junit.v7;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.*;


public class HamcrestJSONTest {

	@Test
	public void testVerificarJSON() {
		String json = "{ message: 'Hi there', quantity: 5, price: 34.56, store: { book: [ {author: 'Evelyn Waugh'}] }}";
		// Verify evaluation of JSON path
		assertThat(json, hasJsonPath("$.message", equalTo("Hi there")));
		assertThat(json, hasJsonPath("$.quantity", equalTo(5)));
		assertThat(json, hasJsonPath("$.price", equalTo(34.56)));
		assertThat(json, hasJsonPath("$.store.book[*].author", hasItem("Evelyn Waugh")));		
	}

}
