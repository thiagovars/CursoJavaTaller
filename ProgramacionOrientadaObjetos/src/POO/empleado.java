package POO;

public class empleado {

	private String nombre;
	private String apellido;
	private String cedula;
	private int edad;
	private boolean casado;
	private double salario;
	
	public empleado(String nombre, String apellido, String cedula, int edad, boolean casado, double salario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.casado = casado;
		this.salario = salario;
	}
	
	public String clasificacion() {
		if	(this.edad >= 21) {
			return "Principiante";
		} else if (this.edad >=22 && this.edad <= 35) {
			return "Intermedio";
		} else {
			return "Senior";
		}
	}
	
	public void showEmpleado() {
		System.out.println("Nombre: " + this.nombre+"\n"+
	                       "Apellido: " + this.apellido+"\n"+
						   "Cedula: " + this.cedula+"\n"+
	                       "Edad: " + this.edad+"\n"+
						   "Casado: "+ this.casado()+"\n"+
	                       "Salario: " + this.salario);
	}
	
	public String casado() {
		if (this.casado) {
			return "Casado";
		} else {
			return "solteiro";
		}
	}
	
	public void aumentaSalario(int porcentaje) {
		if (porcentaje > 0) {
			this.salario = (this.salario * porcentaje) /100;
			System.out.println("Aumento realizado con suceso.");
		} else {
			System.out.println("No es possíble aumentar con porcentaje CERO!");
		}
	}
}
