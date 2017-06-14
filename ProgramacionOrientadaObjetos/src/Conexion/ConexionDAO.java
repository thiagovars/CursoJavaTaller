package Conexion;
import java.sql.*;

public class ConexionDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/", "root", "");
			
			statement = connect.createStatement();
			
			statement.execute("CREATE DATABASE IF NOT EXISTS bra_Connection");
			statement.execute("USE bra_Connection;");
			statement.execute("CREATE TABLE IF NOT EXISTS persona (id INT NOT NULL AUTO_INCREMENT, nombre VARCHAR (10), PRIMARY KEY (id));");
			statement.execute("INSERT INTO persona (nombre) VALUES ('Bill');");
			statement.execute("INSERT INTO persona (nombre) VALUES ('Beatrix');");
			statement.execute("INSERT INTO persona (nombre) VALUES ('Michell');");
			
			resultSet = statement.executeQuery("SELECT * FROM persona");
			
			System.out.println("content of persona");
			
			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				int id = resultSet.getInt("id");
				System.out.println("Nombre: " + nombre + " ID: " + id);
			}
			
			statement.close();
			connect.close();
			
		} catch (Exception e) {
			System.out.println("erro de conexi�n com Base de Datos: " + e.getMessage());
		}
	}

}