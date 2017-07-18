package com.ght.classes;

import java.lang.reflect.Array;

import com.ght.conexion.ConnUsuarios;

public class Usuarios {
	
	private String usrLogado;
	private String tipoUsuario;
	private ConnUsuarios conn;
	
	public Usuarios() {
		this.conn = new ConnUsuarios();
	}
	
	public boolean iniciarSession(String nombre, String passw) {
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
	
	public boolean save(String nombre, String login, String passw, String categoria) {
		Categorias categorias = new Categorias();
		return conn.saveUsuario(nombre, login, passw, categorias.getCodigoByName(categoria));
	}
}
