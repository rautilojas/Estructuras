package ejerciciosEstructuras;

import java.util.Arrays;

public class Ocho {
	
	/*public static void main(String[] args) {
	    int[] prueba = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5};
	    int[] numUnicos = eliminaDuplicados(prueba, prueba.length);
	    System.out.println("Número de elementos únicos: " + numUnicos); // debería imprimir 9
	}*/
	
	public static void main(String[] args) {
        int[] arreglo1 = {7, 3, 5, 1, 2, 3, 5, 7, 4, 9, 8, 7};
        int[] resultado1 = eliminaDuplicados(arreglo1, arreglo1.length);
        System.out.println("Arreglo original: " + Arrays.toString(arreglo1));
        System.out.println("Resultado: " + Arrays.toString(resultado1));
	}
	  
	/*  public static int eliminaDuplicados(int[] A, int N) {
		    int count = N;
		    Arrays.sort(A); // Ordenamos la matriz utilizando el algoritmo quicksort
		    System.out.println();
		    for (int i = 1; i < N; i++) {
		        if (A[i] == A[i-1]) {
		            // Si el elemento actual es igual al anterior, lo eliminamos
		            count--;
		        }
		    }
		    return count;
		}*/
	public static int[] eliminaDuplicados(int[] A, int N) {
	    Arrays.sort(A); // Ordenamos la matriz utilizando el algoritmo quicksort
	    int[] unicos = new int[N];
	    int j = 0;
	    for (int i = 0; i < N; i++) {
	        if (i == 0 || A[i] != A[i-1]) {
	            // Si es el primer elemento o el elemento actual es diferente al anterior, lo agregamos
	            unicos[j++] = A[i];
	        }
	    }
	    return Arrays.copyOfRange(unicos, 0, j); // Devolvemos una nueva matriz con los elementos únicos
	}

}