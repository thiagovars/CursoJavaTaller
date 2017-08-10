package com.ght.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calendario {
	private String meses[];
	static Calendar calendar;
	public static final int HOUR_OF_DAY = calendar.HOUR_OF_DAY;
	
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
		calendar = Calendar.getInstance();
		return format.format(calendar.getTime());
	}

	public void setTime(Date hora) {
		calendar.setTime(hora);
	}

	public void add(int hourOfDay, int i) {
		calendar.add(hourOfDay, i);
	}

	public Object getTime() {
		return calendar.getTime();
	}

	public Date getHoursBetweenTimes(String value, String value2) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:MM");
			Date hora  = format.parse(value);
			Date hora2 = format.parse(value);
			long diference = hora.getTime() + hora2.getTime();
			return format.parse(String.valueOf(diference));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}