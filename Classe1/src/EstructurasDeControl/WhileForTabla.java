package EstructurasDeControl;
import java.util.Scanner;

public class WhileForTabla {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner variable = new Scanner(System.in);
		System.out.println("escribir el numero de tabla");
		int tabla = variable.nextInt();
		int x = 1;
		while (x <= 10) {
			System.out.println(x+" x " +tabla+ " = "+(x*tabla));
			x++;
		}
		variable.close();
	}

}
