package Classes;

public class CadastroUsuarios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Pedro");
		usuario1.setApellido("Vargas");
		usuario1.setDireccion("Antonio diaz, 4633, Prado - Montevideo");
		usuario1.setEdad(33);
		
		usuario1.quienSos();
	}

}
