package com.ght.classes;

import com.ght.conexion.*;

public class Usuarios {
	
	private String usrLogado;
	private String tipoUsuario;
	
	public boolean iniciarSession(String nombre, String passw) {
		ConnDAO conn = new ConnDAO();
		Object[] retorno = new String[2];
		retorno = conn.iniciarSession(nombre, passw);
		setTipoUsuario(retorno[1].toString());
		setUsrLogado(retorno[0].toString());
		return (!this.getUsrLogado().equals("") && !this.getTipoUsuario().equals(""));
	}
	
	public void setUsrLogado(String usrLogado) {
		this.usrLogado = usrLogado;
	}
	
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
	public String getUsrLogado() {
		return usrLogado;
	}
}
