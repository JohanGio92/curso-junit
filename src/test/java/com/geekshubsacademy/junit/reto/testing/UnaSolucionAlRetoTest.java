package com.geekshubsacademy.junit.reto.testing;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
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

public class UnaSolucionAlRetoTest {

	/**
	 * Esta es una posible solución al Reto de verificar
	 * que TareaRepository asigna a Tarea la fecha y hora actual
	 * sin tener que modificar ni Tarea, ni TareaRepository.
	 * La verificación es laxa, es decir, toma el instante medio 
	 * entre que la ejecución entre y sale del método save()
	 * y compara la fecha de la Tarea con un error aproximado
	 * del lapso que tarda el método save(). 
	 * También se verifica que TareaRepository haya 
	 * llamado al PreparedStatement seteando la fecha.
	 */
	@Test
	public void unaTareaSeGuardaConLaFechaActual() throws SQLException {
		Tarea tarea = new Tarea("Aprender Mock.verify()");
		Connection connection = mock(Connection.class);
		PreparedStatement preparedStatement = mock(PreparedStatement.class);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

		TareaRepository repository = new TareaRepository(connection);
		long antes = new Date().getTime();
		repository.save(tarea);
		long despues = new Date().getTime();
		long lapso = despues - antes;

		// Miro si la fecha en el objeto Tarea es la fecha actual
		assertThat((double)tarea.getFechaCreacion().getTime(), closeTo((antes+despues)/2, lapso));
		
		// Miro si TareaRepository llamó al PreparedStatement pasando la fecha actual
		ArgumentCaptor<java.sql.Timestamp> sqlDateCapture = ArgumentCaptor.forClass(java.sql.Timestamp.class);
		verify(preparedStatement).setTimestamp(eq(2), sqlDateCapture.capture());
		assertThat((double)sqlDateCapture.getValue().getTime(), closeTo((antes+despues)/2, lapso));
	}

}
