package ejerciciosEstructuras;


import java.util.Arrays;
import java.util.Comparator;

public class AnagramaComparator implements Comparator<String> {

    public int compare(String primero, String segundo) {
       return ordenar(primero).compareTo(ordenar(segundo));
    }

    public static String ordenar(String cadena) {
        char[] caracteres = cadena.toCharArray();
        Arrays.sort(caracteres);
        return new String(caracteres);
    }

        
    
    
    
}
