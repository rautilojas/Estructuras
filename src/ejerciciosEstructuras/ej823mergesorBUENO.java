package ejerciciosEstructuras;
import java.util.Arrays;
public class ej823mergesorBUENO {
    
    public static void main(String[] args) {
        double A[] = {2.1,1,1,1,1,1,1,7,8,9,3,2}; //Declaración de vector "A"
        int contador=0;
        System.out.println("Antes de QS: " + Arrays.toString(A));       //Se muestra el vector inicial antes de utilizar el quickshort
        quicksort(A, 0, A.length - 1);          //Se llama al método quickshort: Entonces se ordena nuestro vector en orden: en caso de haber numeros repetidos se pondrán continuos unos de otros.
        System.out.println("Después de QS: " + Arrays.toString(A));     //Se muestra el vector final luego de utilizar el quickshort (vector ordenado)
        for (int i = 0; i <A.length; i++) {     //Este for se repetira según la longitud de nuestro vector e incrementará de a uno
            if (i<A.length-1){                  //Comprobación para que el i no incremente más que la longitud del vector
                if (A[i]==A[i+1]){              //Se compara el elemento anterior con el siguiente, ya que estan acomodados en orden:
                    contador+=1;                //En caso de ser iguales el elemento anterior del siguiente, el contador aumentaria de a uno
                }
            }
        }
        System.out.println("Números de elementos que permanecen en la matriz: "+(A.length-contador));//Entonces, se muestra la longitud de la fila menos los numeros repetidos
    }

    //METODO PARTICION
    private static int particion(double arreglo[], int izquierda, int derecha) {
        double pivote = arreglo[izquierda];//el pivote es el elemento 0 de nuestro vector
        while (true) {
            while (arreglo[izquierda] < pivote) {//Mientras el elemento 0, sea menor al pivote, la "flecha" izquierda aumentara una posición
                izquierda++;//La flecha izquierda aumenta una posición
            }
            while (arreglo[derecha] > pivote) {//Si la "flecha" derecha es mayor al pivote: se posiciona hacia atras la flecha (resta)
                derecha--;//La fecha derecha resta una posición
            }
            if (izquierda >= derecha) {//Compara el valor de nuestra "flecha" izquierda con la "flecha" derecha.
                return derecha;//Devuelve derecha
            } else { //Se cambia numero de la flecha izquierda por la flecha derecha
                double temporal = arreglo[izquierda];//Toma como temporal elemento de la flecha izquierda
                arreglo[izquierda] = arreglo[derecha];//El elemento de la "flecha" izquierda pasa a ser el elemento de la "flecha" derecha
                arreglo[derecha] = temporal; //Derecha pasa a ser temporal (el valor de lo que era la flecha izquierda)
                izquierda++;
                derecha--; 
            }
        }
    }
    
    //METODO QUICKSORT
    private static void quicksort(double arreglo[], int izquierda, int derecha) {//METODO QUICKSORT UTILIZANDO EL METODO DE PARTICION
        if (izquierda < derecha) {//Validación para ver si se divide la lista
            int indiceParticion = particion(arreglo, izquierda, derecha);//Utiliza el metodo de partición con nuestro vector
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }
}