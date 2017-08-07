package com.ght.classes;

import com.ght.conexion.ConnUsuarios;

public class Usuarios {
	
	private String tipoUsuario;
	private ConnUsuarios conn;
	
	// campos de la base de datos
	private String codigo;
	private String nombre;
	private String login;
	private String clave;
	private double valorHora;
	private String codCategoria;
	
	public Usuarios() {
		conn = new ConnUsuarios();
	}
	
	public Usuarios(String login, String passw) {
		conn = new ConnUsuarios();
		iniciarSession(login, passw);
	}
	
	public Usuarios(String codigo) {
		conn = new ConnUsuarios();
		setObjectUsuario(codigo);
	}
	
	public boolean iniciarSession(String login, String passw) {
		Object[] retorno = new String[6];
		retorno = conn.iniciarSession(login, passw);
		String codigo       = retorno[0].toString();
		String nombre       = retorno[1].toString();
		String valorHora    = retorno[2].toString();
		String codCategoria = retorno[3].toString();
		setObjectUsuario(codigo);
		Categorias categoria = new Categorias();
		setTipoUsuario(categoria.getTipoByCodigo(codCategoria));
		return (!this.getCodigo().equals("") && !this.getTipoUsuario().equals(""));
	}
	
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setValorHora(double valor) {
		this.valorHora = valor;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}

	public boolean save(String nombre, String login, String passw, double valorHora, String categoria, String codigo) {
		Categorias categorias = new Categorias();
		if(codigo.equals("")) {
			return conn.guardaUsuario(nombre, login, passw, valorHora, categorias.getCodigoByName(categoria));
		} else {
			return conn.actualizaUsuario(nombre, login, passw, valorHora, categorias.getCodigoByName(categoria), codigo);
		}
	}
	
	public void setObjectUsuario(String codigo) {
		Object[] objectUsuarios = conn.getUsuario(codigo);
		this.codigo = objectUsuarios[0].toString();
		nombre = objectUsuarios[1].toString();
		login  = objectUsuarios[2].toString();
		clave  = objectUsuarios[3].toString();
		valorHora = Double.parseDouble(objectUsuarios[4].toString());
		codCategoria = objectUsuarios[5].toString();
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
	
	public boolean isUsr(String codigo) {
		return conn.find(codigo);
	}
	
	public double getValorHora() {
		if(valorHora == 0) {
			Categorias categoria = new Categorias();
			return categoria.getValorHora(getCodCategoria());
		} else {
			return valorHora;
		}
	}
}
