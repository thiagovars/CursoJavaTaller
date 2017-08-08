package com.ght.classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendario {
	private String meses[];
	static Calendar calendar;
	
	public Calendario() {
		calendar = Calendar.getInstance();
		meses = new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
	}
	
	public String getMes(){
		return meses[calendar.get(calendar.MONTH)];
	}
	
	public int getYear() {
		return calendar.YEAR;
	}
	
	public int getCantidadDias() {
		int ano = calendar.YEAR;
		int mes = calendar.get(calendar.MONTH);
		Calendar gCalendar = new GregorianCalendar(ano, mes, 1);
		return gCalendar.getActualMaximum(calendar.DAY_OF_MONTH);
	}
	
	public String getFechaActual() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(calendar.getTime());
	}
	
}