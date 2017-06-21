package CineJPanel;

public class user {

	public boolean validateLogin(String nombre, String passw) {
		ConexionDAO conn = new ConexionDAO();
		return conn.validateUser(nombre, passw);
	}
}
