package ejerciciosEstructuras;
import java.util.Arrays;

public class Duplicados {
	
    public static int[] eliminaDuplicados(int[] A, int N) {
        Arrays.sort(A); // Ordenamos el arreglo utilizando el algoritmo quicksort
        int[] unicos = new int[N];
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || A[i] != A[i-1]) {
                unicos[j++] = A[i];  // Si es el primer elemento o el elemento actual es diferente al anterior, lo agregamos
            }
        }
        return Arrays.copyOfRange(unicos, 0, j); // Devolvemos una nueva matriz con los elementos únicos
    }
    
    public static int contarDuplicados(int[] A) {
        Arrays.sort(A); // Ordenamos el arreglo utilizando el algoritmo quicksort
        int contadorDuplicados = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                contadorDuplicados++;
            }
        }
        return contadorDuplicados;
    }
    
    public static void main(String[] args) {
        int[] arreglo1 = {7, 5, 1, 3, 4, 5, 7, 1, 2, 9, 8, 6, 7, 2};
        int[] resultado1 = eliminaDuplicados(arreglo1, arreglo1.length);
        System.out.println("Arreglo original: " + Arrays.toString(arreglo1));
        System.out.println("Resultado: " + Arrays.toString(resultado1));
        System.out.println("Contador de duplicados: " + contarDuplicados(arreglo1));
    }
    
}