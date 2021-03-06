package Fechas;
import java.util.Calendar;
import java.util.Scanner;

public class FechaOperador {	
	static Calendar calendar;
	private int year;
	private int month;
	private int day;
	
	
	public FechaOperador() {
		calendar = Calendar.getInstance();
		
	}
	
	//Obtengo el a�o del sistema
	static int getYear(){
		return calendar.get(Calendar.YEAR);
	}
	
	//Obtengo el mes del sistema
	static int getMonth(){
		return calendar.get(Calendar.MONTH)+1;
	}
	
	//Obtengo el d�a del sistema
	static int getDay(){
		return calendar.get(Calendar.DATE);
	}
	
	public int returnEdad() {
		int edad = getYear()-year;		
		if (getDay() < day) {
			edad--;
		} else if (getDay() >= day && getMonth() <= month) {
			edad--;
		}
		return edad;
	}
	
	public void catchFechaNavidad() {
		Scanner scn = new Scanner(System.in);
		this.year  = 0;
		this.day   = 0;
		this.month = 0;
		System.out.println("ingrese la fecha de nascimiento (dd/mm/yyyy):");
		String fecha = scn.next();
		scn.close();
		this.day = Integer.valueOf(fecha.substring(0, 2));
		this.month = Integer.valueOf(fecha.substring(3, 5));
		this.year = Integer.valueOf(fecha.substring(6));
		
	}
}
