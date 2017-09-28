package com.geekshubsacademy.junit.v6;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class VerificacionDeMocksTest {

	@Test
	public void testVerificarLaLlamadaAlMockDePreparedStatement() throws SQLException {
		// Preparar
		Tarea tarea = new Tarea("Aprender Mock.verify()");
		Connection connection = mock(Connection.class);
		PreparedStatement preparedStatement = mock(PreparedStatement.class);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

		// Probar
		TareaRepository repository = new TareaRepository(connection);
		repository.save(tarea);

		// Dado que save() no devuelve nada, 
		// uso mock.verify() para saber si se ha guardado la Tarea 
		verify(preparedStatement).executeUpdate();
		verify(preparedStatement).setString(1, "Aprender Mock.verify()");
	}

	@Test
	public void testVerificarQueSeCierraLaConexionEnCasoDeError() throws SQLException {
		// Preparar
		Tarea tarea = new Tarea("Aprender Mock.verify()");
		Connection connection = mock(Connection.class);
		PreparedStatement preparedStatement = mock(PreparedStatement.class);
		when(preparedStatement.executeUpdate())
			.thenThrow(new SQLException("Excepcion lanzada por Mockito de forma intencionada"));
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

		TareaRepository repository = new TareaRepository(connection);
		repository.save(tarea);

		// Puedo verificar llamadas a métodos que no he programado
		verify(connection).close();
		verify(preparedStatement).close();
		
		// Ejercicio: Nota que estos asserts fallarían, ¿Por qué?
		//assertTrue(connection.isClosed());
		//assertTrue(preparedStatement.isClosed());

	}

	@Test
	public void testEspiarElMetodoGetNombreDeLaTarea() throws SQLException {
		// Preparar
		Tarea tarea = new Tarea("Aprender Mock.verify()");
		Tarea spy = spy(tarea);

		Connection connection = mock(Connection.class);
		PreparedStatement preparedStatement = mock(PreparedStatement.class);
		when(preparedStatement.executeUpdate())
			.thenThrow(new SQLException("Excepcion lanzada por Mockito de forma intencionada"));
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

		// Probar
		TareaRepository repository = new TareaRepository(connection);
		repository.save(spy);

		// Verifico que el Repository ha consultado el nombre de la tarea
		verify(spy).getNombre();
	}
}
