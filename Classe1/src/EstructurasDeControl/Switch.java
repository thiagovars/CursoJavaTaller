package EstructurasDeControl;

public class Switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int classificacion = 4;
		String juicio = "";
		
		switch (classificacion) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			juicio = "Suspendido";
			break;
		case 5:
		case 6:
			juicio = "Aprobado";
			break;
		case 7:
		case 8:
		case 9:
		case 10:
			juicio = "Notable";
			break;
		default:
			if	(classificacion < 0 || classificacion > 10) {
				juicio = "Nota no corresponde!";
			} 
			break;
		}
		
		System.out.println("Classificación: "+juicio);
	}

}
