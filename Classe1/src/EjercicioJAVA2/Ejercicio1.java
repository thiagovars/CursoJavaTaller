package EjercicioJAVA2;
import java.util.Scanner;

public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[10];
		int positivos = 0;
		int negativos = 0;
		int ceros = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserir numeros positivos, negativos o ceros;\n");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
			if (arr[i] > 0) {
				positivos++;
			} else if (arr[i] < 0) {
				negativos++;
			} else {
				ceros++;
			}
		}
		scanner.close();
		System.out.println("de los numeros inseridos, \n" +
						   positivos+" son positivos\n"+
						   negativos+" son negativos\n"+
						   ceros+" son ceros\n");
	}

}