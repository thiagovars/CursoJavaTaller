package EjercicioJAVA1;

public class Triangulo {
	private int altura;
	private int base;
	
	public int getAltura() {
		return altura;
	}
	
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public int getBase() {
		return base;
	}
	
	public void setBase(int base) {
		this.base = base;
	}
	
	public int calcArea() {
		return (this.getBase()*this.getAltura())/2;
	}
}
