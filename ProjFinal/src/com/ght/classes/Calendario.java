package com.ght.classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Calendario {
	private String meses[];
	static Calendar calendar;
	public static final int HOUR_OF_DAY = calendar.HOUR_OF_DAY;
	
	private SimpleDateFormat formatter;
	
	public Calendario() {
		calendar = Calendar.getInstance();
		meses = new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
	}
	
	public String getNombreMes(){
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
		formatter = new SimpleDateFormat("YYYY-MM-dd");
		calendar = Calendar.getInstance();
		return formatter.format(calendar.getTime());
	}
	
	public String getMesActual() {
		formatter = new SimpleDateFormat("YYYY-MM");
		calendar = Calendar.getInstance();
		return formatter.format(calendar.getTime());
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

	public String getSuprimeHoras(String value, String value2) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			format.setTimeZone(TimeZone.getTimeZone("GMT"));
			
			long minutos  = getMinutos(value, format);
			long minutos2 = getMinutos(value2, format);
			long diference = (minutos2 - minutos)*60*1000;
			Date fecha = new Date(diference);
			return format.format(fecha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public long getMinutos(String hora, SimpleDateFormat format) {
		Date data;
		try {
			data = format.parse(hora);
		} catch (Exception e) {
			return 0;
		}
		long minutos = data.getTime()/1000/60;
		return minutos;
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		calendar.clear();
	}

	public long getTiempoEnMilisegundos() {
		// TODO Auto-generated method stub
		return calendar.getTimeInMillis();
	}
}