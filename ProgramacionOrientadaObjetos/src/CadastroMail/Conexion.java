package CadastroMail;
import java.sql.*;

public class Conexion {
	
	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	private String basedata;
	
	public Conexion(){
		connect = null;
		statement = null;
		resultSet = null;
	}
	
	public void setBasedata(String basedata) {
		this.basedata = basedata;
	}
	
	public String getBasedata() {
		return basedata;
	}
	
	public void insert(String nombre, String cedula, String mail, String table) {
		if	(this.connect == null || this.statement == null || this.resultSet == null) {
			this.getStarted();
		}
		this.createDataBase();
		this.createTable(table);
		String sql = "INSERT INTO " + table + " (nombre, cedula, mail) VALUES ('"+nombre+"', '"+cedula+"', '"+mail+"');";
		this.execute(sql);
	}
	
	public void execute(String sql) {
		try {
			this.statement.execute("USE " + this.basedata);
			this.statement.execute(sql);
		} catch (Exception e) {
			System.out.println("impossible inserir en la tabla " + e.getMessage());
		}
	}
	
	private void createTable(String table) {
		try {
			String especs = this.getEspecs(table);
			String sql = "USE " + this.getBasedata() + ";";
			this.statement.execute(sql);
			sql = "CREATE TABLE IF NOT EXISTS "+ especs + ";";
			this.statement.execute(sql);
		} catch (Exception e) {
			System.out.println("impossible crear la tabla " + e.getMessage());
		}
	}
	
	private String getEspecs(String table) {
		String espec = "";
		switch(table) {
			case "persona":
				espec = table + " (id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, nombre VARCHAR(80), cedula VARCHAR(9), mail VARCHAR(199))";
				break;
		}
		return espec;
	}
	
	public void getStarted() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/", "root", "");
			statement = connect.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createDataBase() {
		try {
			String sql = "CREATE DATABASE IF NOT EXISTS " + this.basedata;
			this.statement.execute(sql);
		} catch (Exception e) {
			System.out.println("impossible crear base de datos: " + e.getMessage());
		}
	}
	
	public void close() {
		try {
			this.statement.close();
			this.connect.close();
		} catch (Exception e) {
			System.out.println("imposible cerrar la conexion " + e.getMessage());
		}
		
	}
}
