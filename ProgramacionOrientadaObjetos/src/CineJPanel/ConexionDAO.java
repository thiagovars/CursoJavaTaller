package CineJPanel;
import java.sql.*;

public class ConexionDAO {
	private final String basedata = "bra_cine";
	private final String usr = "root";
	private final String passw = "";
	private final String host = "jdbc:mysql://localhost/"+basedata;
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
		
		public ConexionDAO(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection(host, usr, passw);
				statement = connect.createStatement();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
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
		
		public Object[][] select_peliculas() {
			int registros = 0;
			String peliculas = "SELECT codigo, nombre, calificacion FROM peliculas";
			String totalRegistros = "SELECT count(*) as total FROM peliculas";
			try {
				PreparedStatement psm = connect.prepareStatement(totalRegistros);
				ResultSet result = psm.executeQuery();
				result.next();
				registros = result.getInt("total");
				result.close();
			} catch (Exception e) {
				System.out.println("No se ha podido recuperar registros: " + e.getMessage());
			}
			
			Object[][] data = new String[registros][3];
			try {
				PreparedStatement psm = connect.prepareStatement(peliculas);
				ResultSet result = psm.executeQuery();
				int indice = 0;
				while (result.next()) {
					data[indice][0] = result.getString("codigo");
					data[indice][1] = result.getString("nombre");
					data[indice][2] = result.getString("calificacion");
					indice++;
				}
				result.close();
				
			} catch (Exception e) {
				System.out.println("Imposible recuperar registros: "+e.getMessage());
			}
			return data;
		}
		
		public void insert(String nombre, String calificacion, String codPelicula, String table) {
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
				String sql = "CREATE TABLE IF NOT EXISTS "+ especs + ";";
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
