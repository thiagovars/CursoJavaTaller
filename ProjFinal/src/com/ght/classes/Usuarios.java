package com.ght.classes;

import com.ght.conexion.ConnUsuarios;

public class Usuarios {
	
	private String usrLogado;
	private String tipoUsuario;
	private ConnUsuarios conn;
	
	// campos de la base de datos
	private String codigo;
	private String nombre;
	private String login;
	private String clave;
	private int codCategoria;
	
	public Usuarios() {
		this.conn = new ConnUsuarios();
	}
	
	public Usuarios(String codigo) {
		this.conn = new ConnUsuarios();
		setObjectUsuario(codigo);
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public boolean save(String nombre, String login, String passw, String categoria) {
		Categorias categorias = new Categorias();
		return conn.saveUsuario(nombre, login, passw, categorias.getCodigoByName(categoria));
	}
	
	public void setObjectUsuario(String codigo) {
		System.out.println("codigo no setObject " + codigo);
		Object[] objectUsuarios = conn.getUsuario(codigo);
		this.codigo = objectUsuarios[0].toString();
		this.nombre = objectUsuarios[1].toString();
		this.login  = objectUsuarios[2].toString();
		this.clave  = objectUsuarios[3].toString();
		this.codCategoria = (int)objectUsuarios[4];
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
}
