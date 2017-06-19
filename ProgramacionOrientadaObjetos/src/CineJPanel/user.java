package CineJPanel;

public class user {

	public boolean validateLogin(String nombre, String passw) {
		ConexionDAO conn = new ConexionDAO();
		System.out.println(conn.validateUser(nombre, passw));
		return false;
	}
}
