package com.ght.classes;

import com.ght.conexion.*;

public class Usuarios {
	public boolean iniciarSession(String nombre, String passw) {
		ConnDAO conn = new ConnDAO();
		return conn.iniciarSession(nombre, passw);
	}
}
