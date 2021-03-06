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
		
		public Object[][] select_peliculas(String tupla) {
			int registros = 0;
			String peliculas = "SELECT codigo, nombre, calificacion FROM peliculas";
			String totalRegistros = "SELECT count(*) as total FROM peliculas";
			if(!tupla.equals("")){
				peliculas += " WHERE "+tupla;
				totalRegistros += " WHERE "+tupla;
			}
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
		
		public String insert(String nombre, int calificacion, String table) {
			String retorno = "";
			this.createDataBase();
			this.createTable(table);
			String sql = "INSERT INTO " + table + " (nombre, calificacion) VALUES ('"+nombre+"', '"+calificacion+"');";
			try {
				PreparedStatement pstm = this.connect.prepareStatement(sql);
				pstm.execute();
				pstm.close();
				retorno = "Pel�cula inserida con suceso";
			} catch (Exception e) {
				retorno = "Error; "+e.getMessage();
			}
			return retorno;
		}
		
		private void createTable(String table) {
			try {
				String especs = this.getEspecs(table);
				String sql = "CREATE TABLE IF NOT EXISTS "+ especs + ";";
				PreparedStatement pstm = this.connect.prepareStatement(sql);
				pstm.execute();
				pstm.close();
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
				case "peliculas":
					espec = table + " (codigo INT PRIMARY KEY NOT NULL AUTO_INCREMENT, nombre VARCHAR(30), calificacion VARCHAR(20)) ";
			}
			return espec;
		}
		
		public void createDataBase() {
			try {
				String sql = "CREATE DATABASE IF NOT EXISTS " + this.basedata;
				PreparedStatement pstm = this.connect.prepareStatement(sql);
				pstm.execute();
				pstm.close();
			} catch (Exception e) {
				System.out.println("impossible crear base de datos: " + e.getMessage());
			}
		}
		
		public boolean update_peliculas(String tupla, String codigo) {
			boolean result = false;
			String sql = "UPDATE PELICULAS SET "+tupla+" WHERE codigo = " + codigo;
			try {
				PreparedStatement pstm = this.connect.prepareStatement(sql);
				pstm.execute();
				pstm.close();
				result = true;
			} catch (Exception e) {
				System.out.println("imposible editar la tabla error: "+e.getMessage());
			}
			return result;
		}
		
		public String delete_peliculas(String nombre) {
			String result = "";
			String sql = "DELETE FROM PELICULAS WHERE nombre LIKE  '%" + nombre + "%'";
			try {
				PreparedStatement pstm = this.connect.prepareStatement(sql);
				pstm.execute();
				pstm.close();
				result = "Pel�cula removida con suceso";
			} catch (Exception e) {
				result = "Error: "+e.getMessage();
			}
			return result;
		}
		
		public boolean validateUser(String nombre, String passw) {
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
				System.out.println("No se ha podido recuperar registros: " + e.getMessage());
			}
			return false;
		}
}
