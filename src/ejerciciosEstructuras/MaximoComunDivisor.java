package ejerciciosEstructuras;

public class MaximoComunDivisor {
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
	    else
	    	return gcd(b, a % b);
	  }

	  public static void main(String[] args) {
		  int a = 1995;
		  int b = 1494;
		  int mcd = gcd(a, b);
		  System.out.println("El MCD de 1995 y 1494 es: " + mcd);
	  }
}