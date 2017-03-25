package EjercicioJAVA2;

public class Persona {
	private int sexo;
	private int trabajo;
	private int sueldo;
	
	public Persona(int sexo, int trabajo, int sueldo) {
		this.sexo    = sexo;
		this.trabajo = trabajo;
		this.sueldo  = sueldo;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(int trabajo) {
		this.trabajo = trabajo;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
}
