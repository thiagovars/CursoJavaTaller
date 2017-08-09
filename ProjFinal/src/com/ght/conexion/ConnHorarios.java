package com.ght.conexion;

import java.sql.ResultSet;

public class ConnHorarios {

	private ConnDAO conn;
	
	public ConnHorarios() {
		conn = new ConnDAO();
	}
	
	public Object[][] getHorarios(String busqueda) {
		int registros = 0;
		String totalRegistros = "SELECT count(*) as cantidad FROM horarios";
		try {
			ResultSet result = conn.buscar(totalRegistros);
			result.next();
			registros = result.getInt("cantidad");
			result.close();
		} catch (Exception e) {
			System.out.println("No se ha podido recuperar registros: " + e);
		}
		
		Object[][] horarios = new String[registros][5];
		
		try {
			ResultSet result = conn.buscar(busqueda);
			int indice = 0;
			while(result.next()) {
				horarios[indice][0] = result.getString("fecha");
				horarios[indice][1] = result.getString("entrada");
				horarios[indice][2] = result.getString("salida");
				horarios[indice][3] = result.getString("descanso");
				horarios[indice][4] = result.getString("total");
			}
			return horarios;
		} catch (Exception e) {
			System.out.println("Erro al levantar Horarios del usuário: " + e);
		}
		return null;
	}
	
	public void registrar(){}
}
