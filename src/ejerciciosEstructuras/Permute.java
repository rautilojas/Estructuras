package ejerciciosEstructuras;

public class Permute {
    public static void main(String[] args) {
        String s = "esto es una prueba";
        String result = vesre(s);
        System.out.println(result);
    }

    public static String vesre(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return vesre(str.substring(1)) + str.charAt(0);
    }
}