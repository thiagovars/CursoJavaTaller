package Classes;
import java.util.Scanner;

public class Produtos {
	private double suma;
	
	public void ingresarProductos() {
		double sum = 0;
		double valor = 0;
		Scanner scn = new Scanner(System.in);
		System.out.println("¿ingrese el valor de la primera compra? [y]Yes [x]No ");
		String option = scn.next();
		while (!option.equals("x")) {
			valor = scn.nextDouble();
			sum += valor;
			System.out.println("¿inserir otro iten? [y]Yes [x]No: ");
			option = scn.next();
		}
		scn.close();
		this.suma = sum;
	}
	
	public void imprimirCompras() {
		System.out.println("Total de compras: "+this.suma);
	}
}
