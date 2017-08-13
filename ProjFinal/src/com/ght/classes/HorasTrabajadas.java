package com.ght.classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import com.ght.conexion.ConnHorarios;
import com.mysql.jdbc.TimeUtil;

public class HorasTrabajadas {
	
	/** objetos */
	private ConnHorarios conn;
	private Usuarios usuario;
	private Calendario calendario;
	
	public HorasTrabajadas(Usuarios usuario) {
		conn = new ConnHorarios();
		this.usuario = usuario;
		calendario = new Calendario();
	}
	
	public Object[][] getHorariosDelUsuario() {
		
		try {
			Object[][] horarios = conn.getHorarios(usuario.getCodigo(), calendario.getMesActual());
			return horarios;
		} catch (Exception e) {
			System.out.println("Error al levantar las horas del usuario registradas: " + e);
		}
		return null;
	}
	
	public boolean registrar(String fecha, String entrada, String salida, String horasTrabajadas, String descanso) {
		return conn.registrar(fecha, entrada, salida, horasTrabajadas, descanso, usuario.getCodigo());
	}
	
	public String getTotalHoras() {
		Object[] horasTotales = conn.getTotal(usuario.getCodigo(), calendario.getMesActual());
		final DateFormat formatarFecha = new SimpleDateFormat("HH:mm:ss");
		final Calendar calendario = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		long milisegundos = 0;
		calendario.clear();
		long empiezoMS = calendario.getTimeInMillis();
		for (final Object tiempo : horasTotales) {
			try {
				long sustrato = formatarFecha.parse(tiempo.toString()).getTime() - empiezoMS;
				milisegundos += sustrato;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long horas   = TimeUnit.MILLISECONDS.toHours(milisegundos);
		long minutos = TimeUnit.MILLISECONDS.toMinutes(milisegundos)%60;
		StringBuilder total = new StringBuilder(64);
		total.append(horas);
		total.append(":");
		total.append(minutos);
		return total.toString();
	}
	
	public long getCampoTotalHorasTrabajadas(String campo) {
		Object[] horasTotales = conn.getTotal(usuario.getCodigo(), calendario.getMesActual());
		final DateFormat formatarFecha = new SimpleDateFormat("HH:mm:ss");
		final Calendar calendario = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		long milisegundos = 0;
		calendario.clear();
		long empiezoMS = calendario.getTimeInMillis();
		for (final Object tiempo : horasTotales) {
			try {
				long sustrato = formatarFecha.parse(tiempo.toString()).getTime() - empiezoMS;
				milisegundos += sustrato;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		switch (campo) {
		case "horas":
			return TimeUnit.MILLISECONDS.toHours(milisegundos);
		case "minutos":
			return TimeUnit.MILLISECONDS.toMinutes(milisegundos)%60;
		}
		return 0;
	}
	
	public double calcularHonorarios(double valorHora) {
		long horas = getCampoTotalHorasTrabajadas("horas");
		long minutos = getCampoTotalHorasTrabajadas("minutos");
		double total = ((minutos/60) + horas) * valorHora;
		return total;
	}
}
