package CineJPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ConexionDAO {
	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	private String basedata;
		
		public ConexionDAO(){
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
		
		public String getFields(String table) {
			String fields = "";
			switch(table) {
			case "cine":
				fields = "codigo, nombre, calificacion";
				break;
			case "salas":
				fields = "codigo, nombre, codPelicula";
				break;
			}	
			return fields;
		}
		
		public void select(String sql) throws Exception {
			//try {
				
				this.statement.execute("USE " + this.getBasedata());
				ResultSet result = statement.executeQuery(sql);
				
				while (result.next()) {
					System.out.println(result.getString("nombre"));
					System.out.println(result.getString("nombre"));
				}
			//} catch (Exception e) {
				//System.out.println("No se ha podido recuperar registros: " + e.getMessage());
			//}
		}
		
		public void insert(String nombre, String calificacion, String codPelicula, String table) {
			if	(this.connect == null || this.statement == null || this.resultSet == null) {
				this.getStarted();
			}
			this.createDataBase();
			this.createTable(table);
			String sql = "INSERT INTO " + table + " ("+this.getFields(table)+") VALUES ('"+nombre+"', '"+calificacion+"', '"+codPelicula+"');";
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
				case "cine":
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
