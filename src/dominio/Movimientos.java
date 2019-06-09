package dominio;

import java.util.Random;

/**
 * <h1>Clase Movimientos</h1>
 * Esta clase se encarga de realizar las comprobaciones de la interfaz rompecabezas.
 * Generá una matriz aleatoria la cual será tomada para crear el rompecabezas en la interfaz y se encarga
 * de realizar las comparaciones con la Matriz principal (ordenada).
 * Los atributos de clase son:
 * <ul>
 * 	<li>valoresAleatorios</li>
 * 	<li>matrizPrincipal</li>
 * 	<li>matrizAleatoria</li>
 * </ul>
 * @author Jorge Durán
 */

public class Movimientos {

	int[] valoresAleatorios;
	int[][] matrizPrincipal;
	int[][] matrizAleatoria;

	/**
	 * Cuando se instancia la clase Movimientos se ha de especificar el número total de piezas del rompecabezas el cual es 
	 * la elevación por 2 de dificultad, esta instancia inicializa el vector de valoresAleatorios y llama a la función crearMatrices
	 * @param piezas
	 * @param dificultad
	 */
	public Movimientos(int piezas, int dificultad) {


		valoresAleatorios = new int[piezas];
		valoresAleatorios = crearVectorAleatorio(piezas, piezas, valoresAleatorios);
		crearMatrices(dificultad);

	}

	public int[][] getMatrizAleatoria() {
		return matrizAleatoria;
	}

	/*
	 * Devuelve un vector con sus valores ordenados aleatoriamente
	 */
	/**
	 * Esta función devuelve un vector con sus valores aleatorios no repetidos estos van de 0 hasta el numeroPiezas
	 * @param numeroPiezas
	 * @param auxiliar
	 * @param valoresAleatorios
	 * @return
	 */
	private static int[] crearVectorAleatorio(int numeroPiezas, int auxiliar, int[] valoresAleatorios) {

		Random rnd = new Random();

		int[] resultado = new int[numeroPiezas];
		int res;

		for(int i=0;i<numeroPiezas;i++){
			valoresAleatorios[i] = i;
		}

		for(int i=0;i<numeroPiezas;i++){
			res = rnd.nextInt(auxiliar);            
			resultado[i]=valoresAleatorios[res];
			valoresAleatorios[res]=valoresAleatorios[auxiliar-1];
			auxiliar--;
		}

		return resultado;
	}


	/*
	 * Crea las dos matrices, una ordenada y la otra la rellena con valores aleatorios
	 */
	/**
	 * Mediante el parámetro difultad (tamaño de la matriz) inicaliza las matrices principal con números ordenados y aleatoria con
	 * los valores del vectoc valoresAleatorios transpuestos
	 * @param dificultad
	 */
	public void crearMatrices(int dificultad) {

		int iterador = 0;

		matrizPrincipal = new int[dificultad][dificultad];
		matrizAleatoria = new int[dificultad][dificultad];

		for (int i = 0; i < dificultad; i++) {
			for (int j = 0; j < dificultad; j++) {

				matrizPrincipal[i][j] = iterador;
				matrizAleatoria[j][i] = this.valoresAleatorios[iterador];
				iterador++;
			}
		}

	}

	/*
	 * Devuelve TRUE si en los alrededores de la posición dada se encuentra ID
	 */
	/**
	 * Función que comprueba si desde la posición dada en una de sus cuatro direcciones adyacentes se encuentra ID.
	 * @param fila
	 * @param columna
	 * @param ID
	 * @return
	 */
	public boolean comprobarMovimientoClick(int fila, int columna, int ID) {

		/*
		 * Implementación de los setters
		 */

		boolean movimientoPosible = false;

		/*
		 * Comprobación con label superior
		 */
		try {
			if ( matrizAleatoria[fila-1][columna] == ID) {

				movimientoPosible = true;

			}


		} catch (ArrayIndexOutOfBoundsException e) {

		}

		/*
		 * Comprobación con label inferior
		 */
		try {
			if (matrizAleatoria[fila+1][columna] == ID ) {

				movimientoPosible = true;

			}


		} catch (ArrayIndexOutOfBoundsException e) {

		}

		/*
		 * Comprobación con label izquierdo
		 */
		try {
			if (matrizAleatoria[fila][columna-1] == ID ) {

				movimientoPosible = true;

			}


		} catch (ArrayIndexOutOfBoundsException e) {

		}

		/*
		 * Comprobación con label derecho
		 */
		try {
			if (matrizAleatoria[fila][columna+1] == ID ) {

				movimientoPosible = true;

			}


		} catch (ArrayIndexOutOfBoundsException e) {

		}

		return movimientoPosible;
	}

	/**
	 * Funcion que mediante una posicón dada y el lado a comprobar verifica que la posicón consultada existe
	 * para devolver su valor, si está posición no existe devuelve -1
	 * @param fila
	 * @param columna
	 * @param lado
	 * @return
	 */
	public int comprobarMovimientoKey(int fila, int columna, int lado) {

		/*
		 * Implementación de los setters
		 */

		int movimientoPosible = -1;

		switch (lado) {
		case 1:
			movimientoPosible = keyArriba(fila, columna, movimientoPosible);
			
			break;
		case 2:
			movimientoPosible = keyAbajo(fila, columna, movimientoPosible);
			
			break;
		case 3:
			movimientoPosible = keyIzquierda(fila, columna, movimientoPosible);
			
			break;
		case 4:
			movimientoPosible = keyDerecha(fila, columna, movimientoPosible);
			
			break;

		}

		return movimientoPosible;
	}

	
	/**
	 * Comprueba en la casilla derecha si existe una posicón con un valor para sobreescribir movimientoPosible
	 * @param fila
	 * @param columna
	 * @param movimientoPosible
	 * @return
	 */
	private int keyDerecha(int fila, int columna, int movimientoPosible) {
		/*
		 * Comprobación con label derecho
		 */
		try {
			if (matrizAleatoria[fila][columna+1] >= 0 ) {

				movimientoPosible = matrizAleatoria[fila][columna+1];

			}


		} catch (ArrayIndexOutOfBoundsException e) {

		}
		return movimientoPosible;
	}

	/**
	 * Comprueba en la casilla izquierda si existe una posicón con un valor para sobreescribir movimientoPosible
	 * @param fila
	 * @param columna
	 * @param movimientoPosible
	 * @return
	 */
	private int keyIzquierda(int fila, int columna, int movimientoPosible) {
		/*
		 * Comprobación con label izquierdo
		 */
		try {
			if (matrizAleatoria[fila][columna-1] >= 0 ) {

				movimientoPosible = matrizAleatoria[fila][columna-1];

			}


		} catch (ArrayIndexOutOfBoundsException e) {

		}
		return movimientoPosible;
	}

	/**
	 * Comprueba en la casilla inferior si existe una posicón con un valor para sobreescribir movimientoPosible
	 * @param fila
	 * @param columna
	 * @param movimientoPosible
	 * @return
	 */
	private int keyAbajo(int fila, int columna, int movimientoPosible) {
		/*
		 * Comprobación con label inferior
		 */
		try {
			if (matrizAleatoria[fila+1][columna] >= 0 ) {

				movimientoPosible = matrizAleatoria[fila+1][columna];

			}


		} catch (ArrayIndexOutOfBoundsException e) {

		}
		return movimientoPosible;
	}

	/**
	 * Comprueba en la casilla superior si existe una posicón con un valor para sobreescribir movimientoPosible
	 * @param fila
	 * @param columna
	 * @param movimientoPosible
	 * @return
	 */
	private int keyArriba(int fila, int columna, int movimientoPosible) {
		/*
		 * Comprobación con label superior
		 */
		try {
			if ( matrizAleatoria[fila-1][columna] >= 0 ) {

				movimientoPosible = matrizAleatoria[fila-1][columna];

			}


		} catch (ArrayIndexOutOfBoundsException e) {

		}
		return movimientoPosible;
	}

	/*
	 * Cambiar posiciones
	 */
	/**
	 * Cambia de posicón los valores de las posiciones pasadas por parámetro, dichas posiciones se han comprobado anteriormente
	 * que son existentes
	 * @param filaInicio
	 * @param columnaInicio
	 * @param filaCambio
	 * @param columnaCambio
	 */
	public void cambiarPosicion(int filaInicio, int columnaInicio, int filaCambio, int columnaCambio ) {

		int valorInicio = matrizAleatoria[filaInicio][columnaInicio];

		matrizAleatoria[filaInicio][columnaInicio] = matrizAleatoria[filaCambio][columnaCambio];
		matrizAleatoria[filaCambio][columnaCambio] = valorInicio;

	}


	/*
	 * Compara ambas matrices, si en una iteración los valores no son iguales para el recorrido y devuelve FALSE
	 */
	/**
	 * Compara las matrices principal y aleatoria casilla por casilla comproban que sus valores son iguales, en caso contrario para
	 * la iteración del for interior y devuelve FALSE
	 * @return
	 */
	public boolean comparar() {

		boolean iguales = true;

		for (int i = 0; i < this.matrizPrincipal.length; i++) {
			for (int j = 0; j < this.matrizPrincipal[0].length; j++) {

				if ( this.matrizPrincipal[i][j] != this.matrizAleatoria[i][j] ) {

					iguales = false;
					break;
				}
			}
			if (!iguales) {
				break;
			}
		}

		return iguales;
	}

}
