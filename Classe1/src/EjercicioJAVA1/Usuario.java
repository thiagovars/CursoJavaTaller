package EjercicioJAVA1;

public class Usuario {
	private String login;
	private int clave;
	
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		if (login.length() >= 5 && login.length() <= 9) {
			this.login = login;
		} else {
			System.out.println("el login solo es permitido con minimo de 5 y maximo de 9 caracteres");
		}
		
	}
	public int getClave() {
		return this.clave;
	}
	public void setClave(int clave) {
		this.clave = clave;		
	}
	
	
}
