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
	
	public void loginUser(String login, int clave) {
		String usr = this.getLogin();
		
		if (login.equals(usr) && clave == this.getClave()) {
			System.out.println("Bien venido " + this.getLogin());
		} else {
			System.out.println("usuario no encontrado.");
		}
	}
}
