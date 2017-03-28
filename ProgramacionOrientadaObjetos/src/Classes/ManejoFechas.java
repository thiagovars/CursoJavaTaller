package Classes;
//Importa la librer�a completa
import java.util.*;

public class ManejoFechas {
	
	//Creo una instancia de calendario para manejo de fechas
	static Calendar cal = Calendar.getInstance();
	
	//Obtengo el a�o del sistema
	static int getYear(){
		return cal.get(Calendar.YEAR);
	}
	
	//Obtengo el mes del sistema
	static int getMonth(){
		return cal.get(Calendar.MONTH)+1;
	}
	
	//Obtengo el d�a del sistema
	static int getDate(){
		return cal.get(Calendar.DATE);
	}
	
	public static void main(String[] args) {
		System.out.println(getYear());
		System.out.println(getMonth());
		System.out.println(getDate());
		System.out.println(getYear()+"/"+getMonth()+"/"+getDate());
	}
	
}
