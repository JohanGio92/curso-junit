package com.geekshubsacademy.junit.reto.testing;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.geekshubsacademy.junit.v6.Tarea;
import com.geekshubsacademy.junit.v6.TareaRepository;
import com.geekshubsacademy.junit.v6.TareaRepository.FechaActualProvider;

public class UnaSolucionNivelFacilAlRetoTest {

	@Test
	public void unaTareaSeGuardaConLaFechaActual() throws SQLException {
		// Preparar
		Tarea tarea = new Tarea("Reto Testing");
		Connection connection = mock(Connection.class);
		PreparedStatement preparedStatement = mock(PreparedStatement.class);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

		TareaRepository repository = new TareaRepository(connection);
		FechaActualProvider fechaActualProvider = mock(FechaActualProvider.class);
		repository.setFechaActualProvider(fechaActualProvider);
		Date fechaActual = new Date();
		when(fechaActualProvider.getFechaActual()).thenReturn(fechaActual);
		
		// Probar
		repository.save(tarea);

		// ¿Cómo compruebo que la tarea se guarda con la fecha actual?
		long fechaActualMillis = fechaActual.getTime();
		long fechaCreacionMillis = tarea.getFechaCreacion().getTime();
		long diferencia = fechaActualMillis - fechaCreacionMillis;
		System.out.println("La diferencia de fecha es: " + diferencia);
		assertTrue(diferencia < 30);
	}

}
