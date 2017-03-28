package Classes;

public class Triangulo {
	private int A;
	private int B;
	private int C;
	
	public Triangulo(int a, int b, int c) {
		this.A = a;
		this.B = b;
		this.C = c;
	}
	
	public int Mayor() {
		int mayor = A;
		if (B > A) {
			mayor = B;
		}
		if (C > A) {
			mayor = C;
		}
		if (C > B) {
			mayor = C;
		}
		return mayor;
	}
	
	public String getTipoTriangulo() {
		if (A == B && A == C) {
			return "Equilatero";
		} else if (A == C || A == B) {
			return "Isosceles";
		} else {
			return "Escaleno";
		}
	}
	
	public void show() {
		System.out.println("segùn lados ingresados, el lado mayor es: "+this.Mayor());
		System.out.println("Y ese triangulo es un triangulo "+this.getTipoTriangulo());
	}
}
