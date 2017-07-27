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
		//to do: gravar sess�o aqui
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
	
	public Object[][] getListadoUsuarios(Object[] busqueda) {
		String campos = "";
		String[] modelo = {"nombre", "login", "codCategoria"};
		Categorias categorias = new Categorias();
		for (int i = 0; i < busqueda.length; i++) {
			if((String)busqueda[i] != null) {
				if (!campos.equals("")) {
					campos += " AND ";
				}
				if (modelo[i] == "codCategoria") {
					campos += modelo[i] + " = " + categorias.getCodigoByName((String)busqueda[i]);
				} else {
					campos += modelo[i] + " like '%" + busqueda[i] + "%'";
				}
			}
		}
		Object[][] objectUsuarios = conn.getListadoUsuarios(campos);
		for (int i = 0; i < objectUsuarios.length; i++) {
			objectUsuarios[i][3] = categorias.getNameByCodigo(objectUsuarios[i][3].toString());
		}
		return objectUsuarios;
	}
	
	public boolean excluir(String codigo) {
		return conn.excluir(codigo);
	}
}
