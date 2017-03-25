package EjercicioJAVA2;
import java.util.Scanner;

public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("ingresar cantidad de personas a leer: ");
		int numeroPersonas = scn.nextInt();
		while (numeroPersonas <= 0) {
			System.out.println("Hay que poner numeros positivos , intenta de nuevo: ");
			numeroPersonas = scn.nextInt();
		}
		scn.close();
		int alturas[] = new int[numeroPersonas];
		int somAlturas = 0;
		int i;
		for (i=0; i < numeroPersonas; i++) {
			alturas[i] = (int)(Math.random()*210+135);
			somAlturas = somAlturas + alturas[i];
		}
		
		int mediaAlturas = somAlturas/numeroPersonas;
		int arriba = 0;
		int abajo = 0;
		for (i=0; i < numeroPersonas; i++) {
			if (alturas[i] > mediaAlturas) {
				arriba++;
			} else {
				abajo++;
			}
		}
		System.out.println("de " + numeroPersonas + " personas ingresadas la media de sus alturas fue: " + mediaAlturas + "(cm)");
		System.out.println(arriba + " son más altas que la média");
		System.out.println(abajo + " son más bajas que la média");
		
	}

}
