package POO;

public class programador extends empleado {
	private empleado empleado;
	private int lineasDeCodigoPorHora;
	private String lenguajeDominante;
	
	public programador(empleado empleado, int lineasDeCodigoPorHora, String lenguajeDominante) {
		this.empleado = empleado;
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}

	private empleado getEmpleado() {
		return empleado;
	}

	private void setEmpleado(empleado empleado) {
		this.empleado = empleado;
	}

	private int getLineasDeCodigoPorHora() {
		return lineasDeCodigoPorHora;
	}

	private void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
	}

	private String getLenguajeDominante() {
		return lenguajeDominante;
	}

	private void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}
	
	
}
