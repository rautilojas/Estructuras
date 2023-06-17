package ejerciciosEstructuras;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Anagramas {
    
    public static List<String> encuentraGrupoMasGrandeAnagramas(String[] palabras) {
       
        Arrays.sort(palabras, Comparator.comparing(Anagramas::ordenarPalabra));	// Ordena la matriz de palabras utilizando un Comparator que compara las representaciones ordenadas de las palabras
        
        // Variables para almacenar el grupo más grande actual y el grupo más grande encontrado hasta ahora
        List<String> grupoMasGrande = new ArrayList<>();
        List<String> grupoActual = new ArrayList<>();
              
        for (int i = 0; i < palabras.length; i++) {		// Itera sobre las palabras ordenadas           
            if (i > 0 && !sonAnagramas(palabras[i], palabras[i - 1])) { 	// Si la palabra actual y la anterior no son anagramas, se reinicia el grupo actual
                if (grupoActual.size() > grupoMasGrande.size()) { 	// Si el grupo actual es más grande que el grupo más grande encontrado hasta ahora, se actualiza
                    grupoMasGrande = new ArrayList<>(grupoActual);
                }
                grupoActual.clear();
            }            
            grupoActual.add(palabras[i]); 	// Se agrega la palabra actual al grupo actual
        }          
        if (grupoActual.size() > grupoMasGrande.size()) {		// Comprueba si el grupo actual es más grande que el grupo más grande encontrado hasta ahora
            grupoMasGrande = new ArrayList<>(grupoActual);
        }               
        return grupoMasGrande;		// Devuelve el grupo más grande de anagramas
    }
    
    private static String ordenarPalabra(String palabra) {       
        char[] chars = palabra.toCharArray();  // Convierte la palabra en un arreglo de caracteres y lo ordena
        Arrays.sort(chars);        
        return new String(chars); // Devuelve la representación ordenada de la palabra como un String
    }
    
    private static boolean sonAnagramas(String palabra1, String palabra2) {      
        if (palabra1.length() != palabra2.length()) { // Si las palabras tienen longitudes diferentes, no pueden ser anagramas
            return false;
        }      
        char[] chars1 = palabra1.toCharArray();  // Convierte las palabras en arreglos de caracteres y los ordena
        char[] chars2 = palabra2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);      
        return Arrays.equals(chars1, chars2);  // Compara si los arreglos ordenados de caracteres son iguales
    }
    
    public static void main(String[] args) throws IOException {       
        List<String> palabras = Files.readAllLines(Paths.get("archivo.txt"));  // Lee todas las líneas del archivo y las guarda en una lista de Strings             
        String[] palabrasArray = palabras.toArray(new String[0]);    // Convierte la lista de palabras en un arreglo de Strings               
        List<String> grupoMasGrande = encuentraGrupoMasGrandeAnagramas(palabrasArray); // Encuentra el grupo más grande de anagramas en el arreglo de palabras        
        System.out.println("Grupo más grande de anagramas:");         // Imprime el grupo más grande de anagramas
        grupoMasGrande.forEach(System.out::println);
    }
}