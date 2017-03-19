package Classes;

public class Usuario {
	private String nombre;
	private String apellido;
	private int edad;
	private String direccion;
	
	public String getApellido() {
		return apellido;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void quienSos() {
		System.out.println("Hola! Me llamo "+
							this.getNombre()+
							", tengo "+
							this.getEdad()+
							" a�os y vivo en "+
							this.getDireccion()+
							" vos ten�s apellido? "+this.dizApellido());
	}
	
	public Boolean tieneApellido() {
		String apellido = this.getApellido();
		if (apellido == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public String dizApellido() {
		String apellidoReturn;
		if (this.tieneApellido()) {
			apellidoReturn = "Mi apellido es " + this.getApellido();
		} else {
			apellidoReturn= "No, no tengo apellido";
		}
		return apellidoReturn;
	}
}
