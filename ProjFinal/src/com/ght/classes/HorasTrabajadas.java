package com.ght.classes;

import com.ght.conexion.ConnHorarios;

public class HorasTrabajadas {
	
	/** objetos */
	private ConnHorarios conn;
	private Usuarios usuario;
	
	/** campos */
	private String codigo;
	private String fecha;
	private String entrada;
	private String salida;
	private String descanso;
	private String total;
	
	public HorasTrabajadas(Usuarios usuario) {
		conn = new ConnHorarios();
		this.usuario = usuario;
	}
	
	public Object[][] getHorariosDelUsuario() {
		String query = "SELECT codigo, fecha, entrada, salida, descanso, total FROM horarios where codUsuario = " + usuario.getCodigo();
		try {
			Object[][] horarios = conn.getHorarios(query);
			return horarios;
		} catch (Exception e) {
			System.out.println("Error al levantar las horas del usuario registradas: " + e);
		}
		return null;
	}
	
	public boolean registrar(String fecha, String entrada, String salida, String horasTrabajadas, String descanso) {
		return false;
	}
}
