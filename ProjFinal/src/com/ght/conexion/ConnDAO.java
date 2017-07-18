package com.ght.conexion;
import java.sql.*;

public class ConnDAO {
	protected final String base   = "bra_ght";
	protected final String usr    = "root";
	protected final String passw  = "";
	protected final String host   = "jdbc:mysql://localhost/"+base;
	protected Connection connect  = null;
	protected Statement statement = null;
	protected ResultSet result    = null;
	
	public ConnDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host, usr, passw);
			statement = connect.createStatement();
		} catch (Exception e) {
			System.out.println("Não foi possível pegar o drive! "+e.getMessage());
		}
	}
	
	public ResultSet buscar(String query) {
		try {
			PreparedStatement psm = connect.prepareStatement(query);
			ResultSet result = psm.executeQuery();
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean insere(String query) {
		try {
			System.out.println("Teste aceitacao");
			PreparedStatement psm = connect.prepareStatement(query);
			psm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
