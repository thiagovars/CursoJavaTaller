package EjercicioJAVA1;
import java.util.Scanner;

public class Promedio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Calificación de Matemática");
		int matematica = scanner.nextInt();
		System.out.println("Calificación de Física");
		int fisica = scanner.nextInt();
		System.out.println("Calificación de Biología");
		int biologia = scanner.nextInt();
		System.out.println("Calificación de Química");
		int quimica = scanner.nextInt();
		System.out.println("Calificación de Derecho");
		int derecho = scanner.nextInt();
		
		int promedio = (matematica+fisica+biologia+quimica+derecho)/5;
		scanner.close();
		
		if (promedio == 1 || promedio == 2) {
			System.out.println("Examen a febrero");
		} else if (promedio >= 3 && promedio <= 6) {
			System.out.println("Examen a deciembre");
		} else if (promedio >= 7 && promedio <= 11) {
			System.out.println("Aprueba");
		} else if (promedio == 12) {
			System.out.println("Aprueba con honores");
		}
	}

}
