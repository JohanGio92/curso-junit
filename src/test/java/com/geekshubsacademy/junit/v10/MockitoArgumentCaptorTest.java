package com.geekshubsacademy.junit.v10;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class MockitoArgumentCaptorTest {

	@Test
	public void test() {
		List<String> lista = mock(List.class);
		lista.add("Hola");
		lista.add("Mundo");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(lista, times(2)).add(captor.capture());
		assertThat(captor.getAllValues(), containsInAnyOrder("Hola", "Mundo"));
	}

}
