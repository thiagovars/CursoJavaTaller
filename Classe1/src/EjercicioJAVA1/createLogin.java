package EjercicioJAVA1;
import java.util.Scanner;


public class createLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("ingrese con el login: ");
		String login = scanner.next();
		System.out.println("ingrese con la clave: ");
		int clave = scanner.nextInt();
		Usuario u = new Usuario();
		u.setLogin("admin");
		u.setClave(1234);
		if (clave == u.getClave() && login == u.getLogin()) {
			System.out.println("Bien venido " + login);
		} else {
			System.out.println("usuario no encontrado.");
			if (clave == u.getClave()) {
				System.out.println(clave);
			}
			if (login == u.getLogin()) {
				System.out.println(login);
			}
			
			System.out.println(login);
		}
		scanner.close();
	}

}
