package EstructurasDeControl;

public class If {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num1 = -2;
		if	(num1 > 0) {
			System.out.print("Numero positivo ");
			if ((num1%2) == 0) {
				System.out.print("y par!");
			} else {
				System.out.print("y �mpar!");
			}
		} else {
			System.out.print("Numero negativo!");
			if ((num1%2) == 0) {
				System.out.print("y par!");
			} else {
				System.out.print("y �mpar!");
			}
		}
	}

}
