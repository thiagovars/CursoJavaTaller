package com.ght.classes;

import com.ght.conexion.ConnUsuarios;

public class Usuarios {
	
	private String usrLogado;
	private String tipoUsuario;
	private ConnUsuarios conn;
	
	public Usuarios() {
		this.conn = new ConnUsuarios();
	}
	
	public boolean iniciarSession(String login, String passw) {
		Object[] retorno = new String[4];
		retorno = conn.iniciarSession(login, passw);
		Categorias categoria = new Categorias();
		setTipoUsuario(categoria.getNameByCodigo(retorno[3].toString()));
		setUsrLogado(retorno[2].toString());
		return (!this.getUsrLogado().equals("") && !this.getTipoUsuario().equals(""));
	}
	
	public void setUsrLogado(String usrLogado) {
		//to do: gravar sessão aqui
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
	
	public Object[][] getListadoUsuarios() {
		return conn.getListadoUsuarios("");
	}
	
	public boolean excluir(String codigo) {
		return conn.excluir(codigo);
	}
}
