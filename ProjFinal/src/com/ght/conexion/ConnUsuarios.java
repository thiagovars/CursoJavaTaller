package com.ght.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnUsuarios {

	private ConnDAO conn;
	
	public ConnUsuarios() {
		this.conn = new ConnDAO();
	}
	
	public Object[] iniciarSession(String nombre, String passw){
		Object[] retorno = new String[2];
		String query = "SELECT nombre, tipo FROM usuarios WHERE nombre LIKE '%"+nombre+"%' AND passw = '"+passw+"'";
		try {
			ResultSet result = conn.buscar(query);
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
	
	public boolean saveUsuario() {
		//TO DO: considerar heran�a para objetos de conex�o.
		String query = "INSERT INTO USUARIOS";
		try {
			conn.insere(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}