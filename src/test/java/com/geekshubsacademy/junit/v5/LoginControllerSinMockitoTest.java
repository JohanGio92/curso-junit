package com.geekshubsacademy.junit.v5;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import org.junit.Test;

public class LoginControllerSinMockitoTest {

	@Test
	public void testLoginConCertificado() throws CertificateException {
		// Preparar
		byte[] certData = new byte[0];
		X509Certificate certificado = X509Certificate.getInstance(certData);
		Connection connection = null; 
		
		// Probar
		LoginController controller = new LoginController(connection);
		boolean login = controller.login(certificado);
		
		// Verificar
		assertTrue(login);
	}

}
