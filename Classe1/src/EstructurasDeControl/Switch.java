package EstructurasDeControl;

public class Switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nota = 4;
		String classificacion = "";
		
		switch (nota) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			classificacion = "Suspendido";
			break;
		case 5:
		case 6:
			classificacion = "Aprobado";
			break;
		case 7:
		case 8:
		case 9:
		case 10:
			classificacion = "Notable";
			break;
		default:
			if	(nota < 0 || nota > 10) {
				classificacion = "Nota no corresponde!";
			} 
			break;
		}
		
		System.out.println("Classificación: "+classificacion);
	}

}
