package EjercicioJAVA1;
import java.util.Scanner;

public class PersonaIMC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Persona p = new Persona();
		System.out.println("Entra con altura:");
		p.setAltura(scanner.nextDouble());
		System.out.println("Entra con peso:");
		p.setPeso(scanner.nextInt());
		scanner.close();
		
		Double imc = p.getPeso()/(p.getAltura()*p.getAltura());
		System.out.println("imc : "+imc);
		if (imc < 18.49) {
			System.out.println("Infrapeso");
		} else if (imc > 18.50 && imc < 24.99) {
			System.out.println("Peso normal");
		} else if (imc > 25.0 && imc < 29.99) {
			System.out.println("Sobrepeso");
		} else if (imc > 30.0) {
			System.out.println("Obeso");
		}
	}

}
