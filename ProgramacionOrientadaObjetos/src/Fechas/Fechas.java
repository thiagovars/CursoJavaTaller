package Fechas;

public class Fechas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FechaOperador fecha = new FechaOperador();
		
		fecha.catchFechaNavidad();
		System.out.println("Edad: "+fecha.returnEdad());
	}
}
