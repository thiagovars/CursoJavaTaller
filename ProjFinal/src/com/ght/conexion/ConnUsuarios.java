package com.ght.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConnUsuarios extends ConnDAO {

	private ConnDAO conn;
	
	public ConnUsuarios() {
		this.conn = new ConnDAO();
	}
	
	public Object[] iniciarSession(String login, String passw){
		Object[] retorno = new String[4];
		String query = "SELECT login, passw, nombre, codCategoria FROM usuario WHERE login = '"+login+"' AND passw = '"+passw+"'";
		try {
			ResultSet result = this.conn.buscar(query);
			result.next();
			retorno[0] = result.getString("login");
			retorno[1] = result.getString("passw");
			retorno[2] = result.getString("nombre");
			retorno[3] = result.getString("codCategoria");
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
			return this.conn.insere(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Object[][] getListadoUsuarios(String busqueda){
		int registros = 0;
		String queryUsrs = "SELECT codigo, nombre, login, codCategoria FROM usuario";
		if(!busqueda.equals("")) {
			queryUsrs += " WHERE " + busqueda;
		}
		String totalRegistros = "SELECT count(*) as cantidad FROM usuario";
		if(!busqueda.equals("")) {
			totalRegistros += " WHERE " + busqueda;
		}
		try {
			ResultSet result = conn.buscar(totalRegistros);
			result.next();
			registros = result.getInt("cantidad");
			result.close();
		} catch (Exception e) {
			System.out.println("No se ha podido recuperar registros: " + e.getMessage());
		}
		
		Object[][] usuarios = new String[registros][4];
		try {
			ResultSet result = conn.buscar(queryUsrs);
			int indice = 0;
			while (result.next()) {
				usuarios[indice][0] = result.getString("codigo");
				usuarios[indice][1] = result.getString("nombre");
				usuarios[indice][2] = result.getString("login");
				usuarios[indice][3] = result.getString("codCategoria");
				indice++;
			}
			result.close();
		} catch (Exception e) {
			System.out.println("Imposible recuperar registros: "+e.getMessage());
		}
		return usuarios;
	}
	
	public boolean excluir(String codigo){
		String query = "DELETE FROM usuario WHERE codigo = " + codigo;
		try {
			return conn.excluir(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
