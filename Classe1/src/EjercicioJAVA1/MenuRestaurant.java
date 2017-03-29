package EjercicioJAVA1;
import java.util.Scanner;

public class MenuRestaurant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("ingresa hora de entrada:");
		int hora = scanner.nextInt();
		System.out.println("ingresa minuto de entrada:");
		int minuto = scanner.nextInt();
		scanner.close();
		
		if ((hora >= 7 && minuto >= 0) && (hora < 10 && minuto < 60)) {
			//Desayuno
			Menu.showMenu("desayuno");
		} else if ((hora >= 10 && minuto >= 0) && (hora <= 15 && minuto < 60)) {
			//almuerzo
			Menu.showMenu("almuerzo");
		} else if ((hora >= 15 && minuto >= 0) && (hora <= 19 && minuto < 60)) {
			//merienda
			Menu.showMenu("merienda");
		} else if ((hora >= 19 && minuto >= 0) && (hora <= 23 && minuto == 0)) {
			//cena
			Menu.showMenu("cena");
		} else if (hora < 7 && (hora > 23 && minuto > 0)) {
			//cerrado
			Menu.showMenu("cerrado");
		} else {
			System.out.println("fora de periodo");
		}
	}

}