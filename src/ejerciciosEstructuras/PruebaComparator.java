package ejerciciosEstructuras;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
//IMPORTACIONES
public class PruebaComparator {
    
//METODO ORDENAR
    public static String ordenar(String cadena) {//METODO PARA ORDENAR ALFABETICAMENTE EL ARRAY: EJEMPLO= MAGO: AGMO
        char[] caracteres = cadena.toCharArray(); //CONVIERTE LOS ELEMENTOS DEL ARRAY EN CARACTERES
        Arrays.sort(caracteres);//ACOMODA LOS CARACTERES DEL ARRAY EN ORDEN ALFABETICO EJEMPLO= MAGO: AGMO
        return new String(caracteres);//DEVUELVE EL ELEMENTO ORDENADO ALFABETICAMENTE
    }
    
    
    //COMIENZO MAIN
    public static void main(String []args) throws IOException{
	List<String> listatxt = new ArrayList<>();
	try(FileReader fr = new FileReader("C:\\Users\\gianf\\Desktop\\cadenas.txt");
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            while((linea = br.readLine()) != null){//Lee la linea y si no esta vacía: 
                listatxt.add(linea);}       

            String [] lista = new String[listatxt.size()];//Pasaje de lista (Donde se carga el txt a arreglo)
            for(int i = 0; i < listatxt.size(); i++){
                lista[i] = (listatxt.get(i)); //lista[] contiene todas las palabras de nuestro txt
            }        
        //FIN ARCHIVO TXT: TENEMOS LOS DATOS DEL TXT EN lista[]
        String[] listaAlfabetica = new String[lista.length];//LISTA ORDENADA EN ORDEN ALFABETICO
        int contador = 0;
        int indice = 0;
        int maxcontador = 0;
        AnagramaComparator comparator = new AnagramaComparator(); //Se vincula el AnagramaComparator a este archivo
        List<String> listPalabras = Arrays.asList(lista); // Se le da a listPalabras los valores de lista 
        Collections.sort(listPalabras, comparator);//Se acomodan las palabras anagramas una al lado de otra en la lista.
        System.out.println("Lista ordenada normal : "+Arrays.toString(lista));//Lista ordenada normal
        for (int i = 0; i < lista.length; i++) { // Copiamos la lista en listaAlfabetica de  manera ordenada alfabeticamente gracias al método "ordenar"
            listaAlfabetica[i] = ordenar(lista[i]);
        }
        System.out.println("Lista ordenada alfabeticamente: "+Arrays.toString(listaAlfabetica));//Imprime lista ordenada alfabeticamente
        for (int i = 0; i < listaAlfabetica.length; i++) { //Se recorre el arreglo toda su longitud
            if (i<listaAlfabetica.length-1){ //Comprobación para que el i+1 no se pase de la longitud del arreglo
                if (listaAlfabetica[i].equals(listaAlfabetica[i+1])){//Comprueba un elemento con el siguiente
                    contador+=1;
                }
                if (contador>maxcontador){//se almacena valor del maxcontador (Cantidad de anagramas que hay)
                    maxcontador = contador; 
                    indice = i+1; //La posición del elemento final del anagrama mas largo
                }
                if (!listaAlfabetica[i].equals(listaAlfabetica[i+1])){//Validación para que el contador vuelva a 0 solo cuando se terminen los anagramas de la misma palabra
                        contador=0;
                    }
                }
        }
        //System.out.println(maxcontador);
        //System.out.println("INDICE ES "+indice);
        //Se imprime la lista con el elemento indice(Posicion del elemento final del anagrama mas largo -i(cantidad de anagramas maximos)
        for (int i = 0; i <maxcontador+1; i++) {
            System.out.println("La lista de anagramas es: "+lista[indice-i]);//Pero en la lista ordenada para mostrar las palabras correctamente 
        }
    }
    }
}
