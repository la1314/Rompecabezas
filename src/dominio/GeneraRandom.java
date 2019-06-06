package dominio;

import java.util.Random;

public class GeneraRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	         
	        int numeroPiezas =10;  //numeros aleatorios
	        int auxiliar=numeroPiezas;  //auxiliar;
	        int[] numeros = new int[numeroPiezas];
	        Random rnd=new Random();

	        
	        
	        //se rellena un vector ordenada del 1 al n
	        numeros = crearVectorAleatorio(numeroPiezas, auxiliar, numeros, rnd);
	        
	        
	         //se imprime el resultado;
	        System.out.println("El resultado de la matriz es:");
	        for(int i=0 ; i<numeroPiezas;i++){
	        	
	        System.out.println(numeros[i]);
	        
	        }
	   
	}

	private static int[] crearVectorAleatorio(int numeroPiezas, int auxiliar, int[] numeros, Random rnd) {
		
		int[] resultado = new int[numeroPiezas];
		int res;
		
		for(int i=0;i<numeroPiezas;i++){
		    numeros[i]=i;
		}
		
		for(int i=0;i<numeroPiezas;i++){
		    res = rnd.nextInt(auxiliar);            
		    resultado[i]=numeros[res];
		    numeros[res]=numeros[auxiliar-1];
		    auxiliar--;
		}
		
		return resultado;
	}
	
	
}
