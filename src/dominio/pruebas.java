package dominio;

public class pruebas {

	
	public static void main(String[] args) {
		
		// TODO Al finalizar la GUI hay que comprobar si estas funciones van a Editos o a una nueva clase.

		String[][] tablero = {
				{"1", "1", "1", "1"},
				{"1", "1", "1", "1"},
				{"1", "1", "0", "1"},
				{"1", "1", "1", "1"}
		};
		
		Movimientos x = new Movimientos(25, 5);
		x.lectura();
		
		
	}

	/*
	 * TODO Antes de pasar a implementar la funcionabilidad comprobar si es posible añadir "Bordes"
	 * para evitar los Try/Catch
	 */
	
	public static boolean comprobarMovimiento(String[][] piezas, int fila, int columna) {

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
			if (!piezas[fila][columna].equals(piezas[fila-1][columna])) {
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
			if (!piezas[fila][columna].equals(piezas[fila+1][columna])) {
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
			if (!piezas[fila][columna].equals(piezas[fila][columna-1])) {
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
			if (!piezas[fila][columna].equals(piezas[fila][columna+1])) {
				movimientoPosible = true;
				x = fila;
				y = columna+1;
			}

			
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}

		return movimientoPosible;
	}


		
	/*
	 * TODO por implementar
	 * Intercambia las imagenes dentro de la Matriz una vez se ha visto que un movimiento es posible
	 */
	public void intercambiarPieza() {



	}

	/*
	 * TODO por implementar
	 * Compara las dos matrices comprobando si son iguales, al ser iguales en la llama se ha de modificar la última pieza
	 * para que muestre su imagen original y te finalizada la partida actual
	 */
	public boolean comparar() {


		return true;
	}

}
