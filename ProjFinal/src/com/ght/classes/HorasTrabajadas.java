package com.ght.classes;

import com.ght.conexion.ConnHorarios;

public class HorasTrabajadas {
	
	private int userLogado;
	private ConnHorarios conn;
	
	public HorasTrabajadas() {
		conn = new ConnHorarios();
	}
}
