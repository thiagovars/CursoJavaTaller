package Classes;
import java.util.Scanner;

public class Persona {
	private String nombre;
	private double altura; // altura en centìmetros
	private int peso;
	
	public void inicializarPersona() {
		Scanner scn = new Scanner(System.in);
		System.out.println("ingresar nombre:");
		String nombre = scn.next();
		this.setNombre(nombre);
		
		System.out.println("ingresar altura:");
		double altura = scn.nextDouble();
		this.setAltura(altura);
		
		System.out.println("ingresar peso:");
		int peso = scn.nextInt();
		this.setPeso(peso);
		
		scn.close();
	}
	
	public void getImc() {
		double imc = peso/(altura*altura);
		System.out.println("imc : "+imc);
		if (imc < 18.49) {
			System.out.println("Status: Infrapeso");
		} else if (imc > 18.50 && imc < 24.99) {
			System.out.println("Status: Peso normal");
		} else if (imc > 25.0 && imc < 29.99) {
			System.out.println("Status: Sobrepeso");
		} else if (imc > 30.0) {
			System.out.println("Status: Obeso");
		}
	}
	
	public void show() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Altura: "+altura);
		System.out.println("Peso: "+peso);		
		this.getImc();
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setAltura(double altura){
		this.altura = altura;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
}
