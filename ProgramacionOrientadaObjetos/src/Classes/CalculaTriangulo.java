package Classes;
import java.util.Scanner;

public class CalculaTriangulo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Primero lado: ");
		int A = scn.nextInt();
		System.out.println("Segundo lado: ");
		int B = scn.nextInt();
		System.out.println("Tercero lado: ");
		int C = scn.nextInt();
		scn.close();
		Triangulo triangulo = new Triangulo(A, B, C);
		triangulo.show();
	}

}
