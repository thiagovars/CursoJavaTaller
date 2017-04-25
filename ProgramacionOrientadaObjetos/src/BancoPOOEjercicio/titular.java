package BancoPOOEjercicio;

public class titular {
	private String nombre;
	private String apellido;
	private String cedula;
	private double capital;
	
	public titular(String n, String a, String c) {
		this.nombre   = n;
		this.apellido = a;
		this.cedula   = c;
	}

	public String getApellido() {
		return apellido;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getCapital() {
		return capital;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCapital(double capital) {
		this.capital = capital;
	}

}
