package com.geekshubsacademy.junit.reto.tdd.solucion;

import java.util.Arrays;

public class Sudoku {

	private final int orden;
	private int[] datos;

	public Sudoku(int orden) {
		this.orden = orden;
	}

	public int getTotalCasillas() {
		return cuadrado(cuadrado(this.orden));
	}
	
	private int cuadrado(int n) {
		return n * n;
	}

	public int getTotalCuadrados() {
		return cuadrado(this.orden);
	}

	public void cargar(int[] datos) {
		this.datos = datos;
	}

	public int[] getFila(int i) {
		int inicio = getPosicionInicialFila(i);
		int fin = getPosicionFinalFila(i);
		return Arrays.copyOfRange(this.datos, inicio, fin);
	}

	int getPosicionInicialFila(int i) {
		return i*this.getTotalCasillasPorFila();
	}

	int getPosicionFinalFila(int i) {
		return this.getPosicionInicialFila(i)+this.getTotalCasillasPorFila();
	}

	public int getTotalCasillasPorFila() {
		return cuadrado(this.orden);
	}

	public int getTotalCasillasPorColumna() {
		return cuadrado(this.orden);
	}

	public int getTotalCasillasPorCuadrado() {
		return cuadrado(this.orden);
	}

	/**
	 * 0  1  2  3
	 * 4  5  6  7
	 * 8  9  10 11
	 * 12 13 14 15
	 */
	public int[] getColumna(int i) {
		int k = this.getTotalCasillasPorColumna();
		int[] columna = new int[k];
		for (int j=0; j<k; j++) {
			columna[j] = this.datos[i];
			i=i+k;
		}
		return columna;
	}

	/**
	 * 0  1  2  3
	 * 4  5  6  7
	 * 8  9  10 11
	 * 12 13 14 15 
	 */
	public int[] getCuadrado(int i) {
		int k = this.getTotalCasillasPorCuadrado();
		int[] cuadrado = new int[k];
		int offset = i%2 == 0 ? cuadrado(cuadrado(i)): cuadrado(i) + 1;
		for (int j=0; j<k; j++) {
			if (j%2 == 0) {
				i = offset+j*2;
			} else {
				i = offset+j*2-1;
			}
			cuadrado[j] = this.datos[i];
		}
		return cuadrado;
	}

	public boolean comprobar() {
		
		return false;
	}

	public boolean hayNumerosRepetidos(int[] numeros) {
		Arrays.sort(numeros);
		for (int i = 0; i < numeros.length-1; i++) {
			if (numeros[i] >= numeros[i+1]) {
				return true;
			}
		}
		return false;
	}

}
