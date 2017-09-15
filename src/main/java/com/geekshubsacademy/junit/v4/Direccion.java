package com.geekshubsacademy.junit.v4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Direccion {

	private String direccion;

	public Direccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		Pattern pattern = Pattern.compile("[0-9]{5}");
		Matcher matcher = pattern.matcher(this.direccion);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

}
