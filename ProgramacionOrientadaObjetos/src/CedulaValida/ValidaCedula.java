package CedulaValida;
import java.util.Scanner;

public class ValidaCedula {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingresar la cedula de identidad: ");
		Cedula c = new Cedula(scn.next());
		scn.close();
		c.validaCedula();
	}

}
