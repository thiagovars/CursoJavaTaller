package com.ght.classes;

import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;

import com.ght.conexion.ConnCategoria;

public class Categorias {
	
	private ConnCategoria conn = null;

	public Categorias() {
		this.conn = new ConnCategoria();
	}
	
	public DefaultComboBoxModel getCategorias() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		try {
			ResultSet result = this.conn.getCategorias();
			while(result.next()) {
				model.addElement(result.getString("nombre"));
			}
			return model;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public int getCodigoByName(String nombre) {
		return conn.getCodigoByName(nombre);
	}
}
