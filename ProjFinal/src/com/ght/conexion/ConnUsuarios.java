package com.ght.conexion;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConnUsuarios extends ConnDAO {

	private ConnDAO conn;
	
	public ConnUsuarios() {
		this.conn = new ConnDAO();
	}
	
	public Object[] iniciarSession(String nombre, String passw){
		Object[] retorno = new String[2];
		String query = "SELECT nombre, tipo FROM usuarios WHERE nombre LIKE '%"+nombre+"%' AND passw = '"+passw+"'";
		try {
			ResultSet result = ((ConnDAO) connect).buscar(query);
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
	
	/**
	 * Metodo que escribe sql para que la classe
	 * de conexi�n efectivamente lo grabe en la base.
	 * @return true or false
	 */
	public boolean saveUsuario(String nombre, String login, String passw, int categoria) {
		//TO DO: considerar heran�a para objetos de conex�o.
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MM-dd");
		String creacion = formatDate.format(calendar.getTime());
		String query = "INSERT INTO USUARIO (creacion, nombre, login, passw, codCategoria) VALUES " +
				"('"+creacion+"', '"+
				    nombre+"', '"+
				    login+"', '"+
				    passw+"', "+
				    categoria+")";
		try {
			return ((ConnDAO) connect).insere(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
