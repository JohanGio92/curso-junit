package com.geekshubsacademy.junit.reto.tdd.solucion;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class RetoSudokuTest {

	/**
	 * 1
	 */
	@Test
	public void unSudokuDeOrden1TieneEnTotal1Casilla() {
		int orden = 1;
		Sudoku sudoku = new Sudoku(orden);
		int totalCasillas = sudoku.getTotalCasillas();
		assertEquals(1, totalCasillas);
	}

	/**
	 * 1 2 1 2
	 * 3 4 3 4
	 * 1 2 1 2
	 * 3 4 3 4
	 */
	@Test
	public void unSudokuDeOrden2TieneEnTotal16Casillas() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int totalCasillas = sudoku.getTotalCasillas();
		assertEquals(16, totalCasillas);
	}

	/**
	 * 1 2 3 1 2 3 1 2 3
	 * 4 5 6 4 5 6 4 5 6
	 * 7 8 9 7 8 9 7 8 9 
	 * 1 2 3 1 2 3 1 2 3
	 * 4 5 6 4 5 6 4 5 6
	 * 7 8 9 7 8 9 7 8 9 
	 * 1 2 3 1 2 3 1 2 3
	 * 4 5 6 4 5 6 4 5 6
	 * 7 8 9 7 8 9 7 8 9 
	 */
	@Test
	public void unSudokuDeOrden3TieneEnTotal81Casillas() {
		int orden = 3;
		Sudoku sudoku = new Sudoku(orden);
		int totalCasillas = sudoku.getTotalCasillas();
		assertEquals(81, totalCasillas);
	}

	// Para ejecutar los Test cuando estoy escribiendo:
	// ALT+MAYUS+X T
	@Test
	public void unSudokuDeOrden1TieneEnTotal1Cuadrado() {
		int orden = 1;
		Sudoku sudoku = new Sudoku(orden);
		int totalCuadrados = sudoku.getTotalCuadrados();
		assertEquals(1, totalCuadrados);
	}

	@Test
	public void unSudokuDeOrden2TieneEnTotal4Cuadrados() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int totalCuadrados = sudoku.getTotalCuadrados();
		assertEquals(4, totalCuadrados);
	}

	@Test
	public void devuelveLaPrimeraFilaDeUnSudokuDeOrden1() {
		int orden = 1;
		Sudoku sudoku = new Sudoku(orden);
		int[] datos = new int[] {1};
		sudoku.cargar(datos);
		int[] fila = sudoku.getFila(0);
		assertArrayEquals(new int[] {1}, fila);
	}

	/**
	 * 1  2  3  4
	 * 5  6  7  8
	 * 9  10 11 12
	 * 13 14 15 16
	 */
	@Test
	public void devuelveLaPrimeraFilaDeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int[] datos = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		sudoku.cargar(datos);
		int[] fila = sudoku.getFila(0);
		assertArrayEquals(new int[] {1,2,3,4}, fila);
	}
	
	@Test
	public void calcularIndiceInicialFila0DeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int indice = sudoku.getPosicionInicialFila(0);
		assertEquals(0, indice);
	}

	@Test
	public void calcularIndiceInicialFila1DeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int indice = sudoku.getPosicionInicialFila(1);
		assertEquals(4, indice);
	}

	@Test
	public void calcularIndiceInicialFila2DeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int indice = sudoku.getPosicionInicialFila(2);
		assertEquals(8, indice);
	}

	@Test
	public void calcularIndiceFinalFila0DeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int indice = sudoku.getPosicionFinalFila(0);
		assertEquals(4, indice);
	}

	@Test
	public void calcularIndiceFinalFila1DeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int indice = sudoku.getPosicionFinalFila(1);
		assertEquals(8, indice);
	}

	@Test
	public void calcularIndiceFinalFila2DeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int indice = sudoku.getPosicionFinalFila(2);
		assertEquals(12, indice);
	}

	@Test
	public void unSudokuDeOrden2Tiene4CasillasPorFila() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int totalCasillasPorFila = sudoku.getTotalCasillasPorFila();
		assertEquals(4, totalCasillasPorFila);
	}

	/**
	 * 1  2  3  4
	 * 5  6  7  8
	 * 9  10 11 12
	 * 13 14 15 16
	 */
	@Test
	public void devuelveLaPrimeraColumnaDeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int[] datos = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		sudoku.cargar(datos);
		int[] columna = sudoku.getColumna(0);
		assertArrayEquals(new int[] {1,5,9,13}, columna);
	}
	
	@Test
	public void devuelveLaSegundaColumnaDeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int[] datos = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		sudoku.cargar(datos);
		int[] columna = sudoku.getColumna(1);
		assertArrayEquals(new int[] {2,6,10,14}, columna);
	}
	
	/**
	 * 1  2  3  4
	 * 5  6  7  8
	 * 9  10 11 12
	 * 13 14 15 16
	 */
	@Test
	public void devuelveElPrimerCuadradoDeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int[] datos = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		sudoku.cargar(datos);
		int[] fila = sudoku.getCuadrado(0);
		assertArrayEquals(new int[] {1,2,5,6}, fila);
	}
	
	@Test
	public void devuelveElSegundoCuadradoDeUnSudokuDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int[] datos = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		sudoku.cargar(datos);
		int[] fila = sudoku.getCuadrado(1);
		assertArrayEquals(new int[] {3,4,7,8}, fila);
	}

	/**
	 * 1 2 3 4
	 * 3 4 1 2
	 * 2 1 4 3
	 * 4 3 2 1
	 */
	@Test
	public void compruebaUnSudokuCorrectoDeOrden2() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		int[] datos = new int[] {1,2,3,4,3,4,1,2,2,1,4,3,4,3,2,1};
		sudoku.cargar(datos);
		// TODO Implementar el metodo comprobar()
		// boolean correcto = sudoku.comprobar();
		// La implementacion de comprobar 
		// Verificaría que no hay repetidos en filas, columnas y cuadrados

		// Comprobamps filas
		assertArrayEquals(new int[] {1,2,3,4}, sudoku.getFila(0));
		assertArrayEquals(new int[] {3,4,1,2}, sudoku.getFila(1));
		assertArrayEquals(new int[] {2,1,4,3}, sudoku.getFila(2));
		assertArrayEquals(new int[] {4,3,2,1}, sudoku.getFila(3));

		// Comprobamps columnas
		assertArrayEquals(new int[] {1,3,2,4}, sudoku.getColumna(0));
		assertArrayEquals(new int[] {2,4,1,3}, sudoku.getColumna(1));
		assertArrayEquals(new int[] {3,1,4,2}, sudoku.getColumna(2));
		assertArrayEquals(new int[] {4,2,3,1}, sudoku.getColumna(3));

		// Comprobamps columnas
		assertArrayEquals(new int[] {1,2,3,4}, sudoku.getCuadrado(0));
		assertArrayEquals(new int[] {3,4,1,2}, sudoku.getCuadrado(1));
		/* FIXME
		assertArrayEquals(new int[] {2,1,4,3}, sudoku.getCuadrado(2));
		*/
		assertArrayEquals(new int[] {4,3,2,1}, sudoku.getCuadrado(3));
	}
	
	@Test
	public void compruebaNumerosRepetidos() {
		int orden = 2;
		Sudoku sudoku = new Sudoku(orden);
		assertFalse(sudoku.hayNumerosRepetidos(new int[] {1,2,3,4}));
		assertTrue(sudoku.hayNumerosRepetidos(new int[] {3,1,3,1}));
	}
	
	
}
