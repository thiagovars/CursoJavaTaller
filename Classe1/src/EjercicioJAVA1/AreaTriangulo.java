package EjercicioJAVA1;
import java.util.Scanner;

public class AreaTriangulo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); 
		Triangulo triangulo = new Triangulo();
		
		System.out.println("Entra con la ALTURA del triangulo: ");
		triangulo.setAltura(scanner.nextInt());
		System.out.println("Entra con la BASE del triangulo: ");
		triangulo.setBase(scanner.nextInt());
		System.out.println("Area del triangulo es "+triangulo.calcArea());
		scanner.close();
	}

}
