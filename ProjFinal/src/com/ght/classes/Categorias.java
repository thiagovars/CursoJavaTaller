package com.ght.classes;

import java.sql.ResultSet;

import javax.swing.ComboBoxModel;
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
			model.addElement("Select Categoria");
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
	
	public String getNameByCodigo(String codigo) {
		return conn.getNameByCodigo(codigo);
	}
	
	public String getTipoByCodigo(String codigo) {
		return conn.getTipoByCodigo(codigo);
	}
	
	public double getValorHora(String codigo) {
		return conn.getValorHoraByCodigo(codigo);
	}

	public DefaultComboBoxModel getTiposCategoria() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		try {
			ResultSet result = this.conn.getTipoCategorias();
			model.addElement("Selecione Tipo de Categoria");
			while(result.next()) {
				model.addElement(result.getString("tipo"));
			}
			return model;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Object[][] getListadoCategorias(Object[] busqueda) {
		String campos = "";
		System.out.println("categorias " + busqueda);
		String[] modelo = {"nombre", "tipo", "valorHora"};
		Categorias categorias = new Categorias();
		for (int i = 0; i < busqueda.length; i++) {
			if((String)busqueda[i] != null) {
				if (!campos.equals("")) {
					campos += " AND ";
				}
				campos += modelo[i] + " like '%" + busqueda[i] + "%'";
			}
		}
		System.out.println(campos);
		return conn.getListadoCategorias(campos);
	}
}
