package ejerciciosEstructuras;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Original
{
        //Función para ordenar lista para anagrama
        public static String ordenar(String cadena) {//METODO PARA ORDENAR ALFABETICAMENTE EL ARRAY: EJEMPLO= MAGO: AGMO
        char[] caracteres = cadena.toCharArray();//CONVIERTE LOS ELEMENTOS DEL ARRAY EN CARACTERES
        Arrays.sort(caracteres);//ACOMODA LOS CARACTERES DEL ARRAY EN ORDEN ALFABETICO EJEMPLO= MAGO: AGMO
        return new String(caracteres);//DEVUELVE EL ELEMENTO ORDENADO ALFABETICAMENTE
        }
        
	public void leerArchivo()
	{//INICIO TXT
		List<String> lista = new ArrayList<>();
		
		try(FileReader fr = new FileReader("cadenas.txt");
				BufferedReader br = new BufferedReader(fr))
		{
			String linea;
                        int mayor = 0;
			String anagramalargo = null;
			while((linea = br.readLine()) != null)
			{   
                            lista.add(linea);
			}
        //FIN TXT
        
			String [] arreglo = new String[lista.size()];//Pasaje de lista a arreglo
			for(int i = 0; i < lista.size(); i++){
                            arreglo[i] = ordenar(lista.get(i)); //Ordena toda la longitud de la lista alfabeticamente
			}
                         HashMap<String, Integer> mapaDeFrecuencias = new HashMap<>();
                         for (String palabra : arreglo) {
                            if (mapaDeFrecuencias.containsKey(palabra)) {
                                mapaDeFrecuencias.put(palabra, mapaDeFrecuencias.get(palabra) + 1);
                                if (mapaDeFrecuencias.put(palabra, mapaDeFrecuencias.get(palabra))>=mayor){
                                    mayor=mapaDeFrecuencias.put(palabra, mapaDeFrecuencias.get(palabra));
                                }
                            } else {
                                mapaDeFrecuencias.put(palabra, 1);
                            }
                        for (HashMap.Entry<String, Integer> entry : mapaDeFrecuencias.entrySet()) {
                            if (entry.getValue()==mayor) {
                                anagramalargo = entry.getKey();
                            }
                            }
                        }
                        System.out.println("el anagrama con mayor palabra: "+anagramalargo);
                        
                        	
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
        
        
        
        
	
	public static void main(String[] args) 
	{
            new Original().leerArchivo();
	}
        
            

        

}