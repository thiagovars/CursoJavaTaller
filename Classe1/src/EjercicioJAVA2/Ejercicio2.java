package EjercicioJAVA2;
import java.util.Scanner;

public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int positivos[] = new int[10];
		int negativos[] = new int[10];
		int sumaPositiva = 0;
		int sumaNegativa = 0;
		
		System.out.println("ingresar valores positivos y negativos: ");
		for (int i = 0; i < 10; i++) {
			int numero = scanner.nextInt();
			if (numero > 0) {
				positivos[i] = numero;
				sumaPositiva = sumaPositiva + numero;
			} else if (numero < 0) {
				negativos[i] = numero;
				sumaNegativa = sumaNegativa + numero;
			}
		}
		scanner.close();
		int mediaPositiva = sumaPositiva/positivos.length;
		System.out.println("la media de los numeros positivos es: "+mediaPositiva);
		
		int mediaNegativa = sumaPositiva/positivos.length;
		System.out.println("la media de los numeros positivos es: "+mediaNegativa);
		
	}

}
