package POO;

public class programador extends empleado {
	private int lineasDeCodigoPorHora;
	private String lenguajeDominante;
	
	public programador(String nombre, String apellido, String cedula, int edad, boolean casado, double salario, int lineasDeCodigoPorHora, String lenguajeDominante) {
		super(nombre, apellido, cedula, edad, casado, salario);
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}
}
