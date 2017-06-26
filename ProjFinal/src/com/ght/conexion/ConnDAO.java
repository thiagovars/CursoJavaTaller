package com.ght.conexion;
import java.sql.*;

public class ConnDAO {
	private final String base   = "bra_ght";
	private final String usr    = "root";
	private final String passw  = "";
	private final String host   = "jdbc:mysql://localhost/"+base;
	private Connection connect  = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public ConnDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host, usr, passw);
			statement = connect.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Object[] iniciarSession(String nombre, String passw){
		Object[] retorno = new String[2];
		String query = "SELECT nombre, tipo FROM usuarios WHERE nombre LIKE '%"+nombre+"%' AND passw = '"+passw+"'";
		try {
			PreparedStatement psm = connect.prepareStatement(query);
			ResultSet result = psm.executeQuery();
			result.next();
			retorno[0] = result.getString("nombre");
			retorno[1] = result.getString("tipo");
			result.close();
			return retorno;
		} catch (Exception e) {
			System.out.println("No se ha podido validar usuario: " + e.getMessage());
		}
		return retorno;
	}
	
}
