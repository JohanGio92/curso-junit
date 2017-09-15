package com.geekshubsacademy.junit.v3;

public class ValidadorEmail {
	
	private static ValidadorEmail instance;
	private boolean clean = true;

	// Singleton! Call ValidadorEmail.getInstance().
	private ValidadorEmail() {
		
	}
	
	public static synchronized ValidadorEmail getInstance() {
		if (ValidadorEmail.instance == null) {
			instance = new ValidadorEmail();
		}
		return ValidadorEmail.instance;
	}
	
	public boolean validarEmail(String email) {
		if (!clean) {
			throw new IllegalStateException("El validador está en un estado inconsistente. Llama al método reset()");
		}
		this.clean = false;
		if (!email.contains("@")) {
			return false;
		}
		
		return true;
	}
	
	public void reset() {
		if (this.clean) {
			throw new IllegalStateException("Aún no se puede llamar a este método. Primero llamar al método validarEmail()");
		}
		this.clean = true;
	}
}
