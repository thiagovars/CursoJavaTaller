package Arrays;

public class EstruturaArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[] = {1,55,48,13,28,24};
		String palabras[] = {"cadena", "array", "pelicula", "cuaderno"};
		int i;
		for (i=0; numeros.length > i; i++) {
			System.out.println("el elemento de la posici�n " + i + " es: "+numeros[i]);
		}
		System.out.println("");
		int j;
		for (j=0; palabras.length > j; j++) {
			System.out.println("el elemento de la posici�n " + j + " es: "+palabras[j]);
		}
		System.out.println("");
		System.out.println("crando arrays com pre elementos");
		System.out.println("array con int");
		
		int array[] = new int[10];
		array[3] = 8;
		array[9] = 125;
		
		int k;
		for (k=0; array.length > k; k++) {
			System.out.println("el elemento de la posici�n " + k + " es: "+array[k]);
		}
		
		String txt[] = new String[10];
		txt[3] = "teste";
		txt[9] = "otro teste";
		
		System.out.println("");
		System.out.println("array con textos");
		int z;
		for (z=0; txt.length > z; z++) {
			System.out.println("el elemento de la posici�n " + z + " es: "+txt[z]);
		}
		
		System.out.println("");
		int multiplos[] = new int[10];
		int r;
		for (r=0; multiplos.length > r; r++) {
			multiplos[r] = r*3;
			System.out.println("elemento "+r+": "+multiplos[r]);
		}
		
	}

}
