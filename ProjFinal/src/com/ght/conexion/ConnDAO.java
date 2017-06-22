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
	
	public boolean iniciarSession(String nombre, String passw){
		int registros = 0;
		String totalRegistros = "SELECT count(*) as total FROM usuarios WHERE nombre LIKE '%"+nombre+"%' AND passw = '"+passw+"'";
		try {
			PreparedStatement psm = connect.prepareStatement(totalRegistros);
			ResultSet result = psm.executeQuery();
			result.next();
			registros = result.getInt("total");
			result.close();
			if (registros == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("No se ha podido validar usuario: " + e.getMessage());
		}
		return false;
	}
	
}
