package EjercicioJAVA1;
import java.util.Scanner;

public class ContaPersonas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ingrese el numero de personas: ");
		int nuPersonas = scanner.nextInt();
		
		System.out.println("de estas personas, ¿cuantas son mujeres? ");
		int nuMujeres = scanner.nextInt();
		scanner.close();
		
		//calculando hombres e mujeres
		int nuHombres = nuPersonas - nuMujeres;
		int pMujeres = (nuMujeres*100)/nuPersonas;
		int pHombres = (nuHombres*100)/nuPersonas;
		
		System.out.println("de las personas ingresadas;");
		System.out.println(pMujeres+"% son Mujeres;");
		System.out.println(pHombres+"% son Hombres.");
	}

}
