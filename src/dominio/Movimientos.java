package dominio;

import java.util.Random;

public class Movimientos {


	int[] valoresAleatorios;
	int[][] matrizPrincipal;
	int[][] matrizAleatoria;

	public Movimientos(int piezas, int dificultad) {
		
		
		valoresAleatorios = new int[piezas];
		valoresAleatorios = crearVectorAleatorio(piezas, piezas, valoresAleatorios);
		crearMatrices(dificultad);
		
	}

	/*
	 * Devuelve un vector con sus valores ordenados aleatoriamente
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
	
	
	public void lectura() {
		for (int i = 0; i < matrizAleatoria.length; i++) {
			for (int j = 0; j < matrizAleatoria.length; j++) {
				System.out.print(matrizAleatoria[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < matrizAleatoria.length; i++) {
			for (int j = 0; j < matrizAleatoria.length; j++) {
				System.out.print(matrizPrincipal[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	/*
	 * Crea las dos matrices, una ordenada y la otra la rellena con valores aleatorios
	 */
	public void crearMatrices(int dificultad) {
		
		int iterador = 0;
		
		matrizPrincipal = new int[dificultad][dificultad];
		matrizAleatoria = new int[dificultad][dificultad];
		
		for (int i = 0; i < dificultad; i++) {
			for (int j = 0; j < dificultad; j++) {
				
				matrizPrincipal[i][j] = iterador;
				matrizAleatoria[i][j] = this.valoresAleatorios[iterador];
				iterador++;
			}
		}
		
	}
	
	/*
	 * Devuelve TRUE si en los alrededores de la posición dada se encuentra ID
	 */
	public static boolean comprobarMovimiento(int[][] matrizAleatoria, int fila, int columna, int ID) {

		/*
		 * Implementación de los setters
		 */
		
		boolean movimientoPosible = false;
		
		/*
		 * TODO X e Y guardan la posición donde es posible mover, faltan modificaciones en la función
		 * para ver viabilidad con la interfaz gráfica
		 */
		
		int x = 0;
		int y = 0;
		
		/*
		 * Comprobación con label superior
		 */
		try {
			if ( matrizAleatoria[fila-1][columna] == ID) {
				movimientoPosible = true;
				x = fila-1;
				y = columna;
			}

			
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
		/*
		 * Comprobación con label inferior
		 */
		try {
			if (matrizAleatoria[fila+1][columna] == ID ) {
				movimientoPosible = true;
				x = fila+1;
				y = columna;
			}

			
		} catch (ArrayIndexOutOfBoundsException e) {
		
		}
		
		/*
		 * Comprobación con label izquierdo
		 */
		try {
			if (matrizAleatoria[fila][columna-1] == ID ) {
				movimientoPosible = true;
				x = fila;
				y = columna-1;
			}

			
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
		/*
		 * Comprobación con label derecho
		 */
		try {
			if (matrizAleatoria[fila][columna+1] == ID ) {
				movimientoPosible = true;
				x = fila;
				y = columna+1;
			}

			
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}

		return movimientoPosible;
	}
	
	/*
	 * Compara ambas matrices, si en una iteración los valores no son iguales para el recorrido y devuelve FALSE
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