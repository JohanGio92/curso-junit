package com.geekshubsacademy.junit.v5;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import org.junit.Test;

public class LoginControllerConMockitoTest {

	@Test
	public void testLoginConCertificado() throws CertificateException, SQLException {
		// Preparar
		X509Certificate certificado = mock(X509Certificate.class);
		Connection connection = mock(Connection.class);
		
		// Programar respuestas
		Principal principal = mock(Principal.class);
		when(certificado.getSubjectDN()).thenReturn(principal);
		when(principal.getName()).thenReturn("usuario");
		
		PreparedStatement preparedStatement = mock(PreparedStatement.class);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
		ResultSet resultSet = mock(ResultSet.class);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(true);
		when(resultSet.getInt(1)).thenReturn(1);
		
		// Probar
		LoginController controller = new LoginController(connection);
		boolean login = controller.login(certificado);
		
		// Verificar
		assertTrue(login);
	}

	@Test
	public void testSinSentido() throws CertificateException {
		// Probar
		LoginController controller = mock(LoginController.class);
		when(controller.login(null)).thenReturn(true);
		boolean login = controller.login(null);
		
		// Verificar
		assertTrue(login);
	}
}
