package com.ght.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnCategoria {

	private ConnDAO conn;
	
	public ConnCategoria() {
		this.conn = new ConnDAO();
	}
	
	public ResultSet getCategorias() {
		String query = "SELECT nombre FROM CATEGORIA";
		try {
			ResultSet result = conn.buscar(query);
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public int getCodigoByName(String nombre) {
		int codigo = 0;
		String query = "SELECT codigo FROM CATEGORIA WHERE nombre LIKE '%"+nombre+"%'";
		try {
			ResultSet result = conn.buscar(query);
			result.next();
			return result.getInt("codigo");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return codigo;
	}
	
	public String getNameByCodigo(String codigo) {
		String query = "SELECT tipo FROM CATEGORIA WHERE codigo = '"+codigo+"'";
		try {
			ResultSet result = conn.buscar(query);
			result.next();
			return result.getString("tipo");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
}
