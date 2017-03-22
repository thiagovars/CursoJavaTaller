package EjercicioJAVA1;
import java.util.Scanner;


public class createLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		u.setLogin("admin");
		u.setClave(1234);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ingrese con el login: ");
		String login = scanner.next();
		
		System.out.println("ingrese con la clave: ");
		int clave = scanner.nextInt();
		
		u.loginUser(login, clave);
		scanner.close();
	}

}
