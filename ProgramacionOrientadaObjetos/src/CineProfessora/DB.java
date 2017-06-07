package CineProfessora;

import java.sql.*;
public class DB {

	/* Datos para la conexion */
	private String bd = "eltaller";//Base de datos
	private String user = "root"; //Usuario
	private String password = ""; //Contraseña
	private String host = "jdbc:mysql://127.0.0.1/"+bd; //Servidor + Base de datos
	private Connection conn = null; //Inicializamos con valor null la conexion

	/* Constructor de la clase que se conecta a la Base de Datos */
	public DB(){
		try{
			//Driver para MySQL
			Class.forName("com.mysql.jdbc.Driver");
			
			//Obtenemos la conexión
			conn = DriverManager.getConnection(host,user,password);
			if (conn!=null){
				System.out.println("OK base de datos "+bd+"");
			}
		}catch(SQLException e){
			System.out.println(e);
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
	}

	public Connection getConnection(){
		return this.conn;
	}
	
	/* Realiza una consulta a la base de datos, 
	 *retorna un Object[][] (Array)
	 * con los datos de la tabla persona
	 */
    public Object[][] Select_Persona(){
		int registros = 0;
		String consulta = "SELECT perid, pernom, perape, pereda FROM persona";
		String consulta2 = "SELECT count(*) AS total FROM persona";
		
		//Obtenemos la cantidad de registros existentes en la tabla
		try{
			PreparedStatement pstm = conn.prepareStatement(consulta2);
			ResultSet res = pstm.executeQuery();
			res.next();
			registros = res.getInt("total");
			res.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		
		//Se crea una matriz (array) con tantas filas y columnas se necesite
		Object[][] data = new String[registros][4];
		
		//Realizamos la consulta SQL y llenamos los datos en la matriz "Object"
		try{
			PreparedStatement pstm = conn.prepareStatement(consulta);
			ResultSet res = pstm.executeQuery();
			int i = 0;
			while(res.next()){
				//Los parametros corresponden a las nombres de los campos de la tabla en la base de datos
				data[i][0] = res.getString( "perid" );
				data[i][1] = res.getString( "pernom" );
				data[i][2] = res.getString( "perape" );
				data[i][3] = res.getString( "pereda" );
				i++;
			}
			res.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return data;
	}

	/* Ejecuta la actualizacion de la tabla persona 
	* dado los valores de actualizacion
	* y el ID del registro a afectar
	*/
	public boolean update(String valores, String id){
		boolean res = false;
		String q = " UPDATE persona SET " + valores + " WHERE perid= " + id;
		try {
			PreparedStatement pstm = conn.prepareStatement(q);
			pstm.execute();
			pstm.close();
			res=true;
		}catch(SQLException e){
			System.out.println(e);
		}
		return res;
	}

}
