package EjercicioJAVA2;
import java.util.Scanner;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";		
		
//		String alfa = "";
//		String alfa2 = "";
//		
//		char abecedario[] = new char[('Z'-'A')+1];
//		for(int i='A', indice=0;i<='Z';i++, indice++){
//            abecedario[indice]=(char)i;
//        }
//		
//		for	(int i=0; i < abecedario.length; i++) {
//			alfa += abecedario[i];
//			alfa2 += alfabeto.charAt(i);
//		}
//		System.out.println(alfa);
//		System.out.println(alfa2);
		
		String insertados = "";
		Scanner scn = new Scanner(System.in);
		System.out.println("ingrese la posición del char: ");
		int posicion = scn.nextInt();
		while (posicion != (-1)) {
			if (posicion >= 0 && posicion < alfabeto.length()) {
				insertados += alfabeto.charAt(posicion);
			} else {
				System.out.println("Error, inserte otro numero");
			}
			posicion = scn.nextInt();
		}
		scn.close();
		System.out.println("Los caracteres insertados al final fueron: "+insertados);
	}
}
