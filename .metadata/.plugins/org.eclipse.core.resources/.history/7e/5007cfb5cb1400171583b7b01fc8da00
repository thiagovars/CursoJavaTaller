package Classes;
//Importa la librería completa
import java.util.Calendar;

public class ManejoFechas {
	
	//Creo una instancia de calendario para manejo de fechas
	static Calendar cal = Calendar.getInstance();
	
	//Obtengo el año del sistema
	static int getYear(){
		return cal.get(Calendar.YEAR);
	}
	
	//Obtengo el mes del sistema
	static int getMonth(){
		return cal.get(Calendar.MONTH)+1;
	}
	
	//Obtengo el día del sistema
	static int getDate(){
		return cal.get(Calendar.DATE);
	}
	
	static int getDayWeek() {
		DateFormat.getDateInstance().format(myDate);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	public static void main(String[] args) {
		System.out.println(getYear());
		System.out.println(getMonth());
		System.out.println(getDate());
		System.out.println(getYear()+"/"+getMonth()+"/"+getDate());
		System.out.println(getDayWeek());
	}
	
}
