package CedulaValida;

public class Cedula {
	static final int validador[] = {2, 9, 8, 7, 6, 3, 4};
	private int numeroValidador;
	private String cedIngresada;
	
	public Cedula(String cedula) {
		if (cedula.length() != 8) {
			System.out.println("Cedula no contiene cantidad de elementos");
		} else {
			this.cedIngresada = cedula;
		}
	}
	
	public void validaCedula() {
		                     //44038289		
		String cedula = cedIngresada.substring(0, 7);
		int soma = 0;
		for (int i = 0; i < cedula.length(); i++) {
			soma += Integer.parseInt(String.valueOf(cedula.charAt(i))) * validador[i];
		}
		this.numeroValidador = soma;
		int numeroValidador = proximoNumeroValida();
		if (numeroValidador - soma == getDigito(cedIngresada)) {
			System.out.println("Cedula es valida!");
		} else {
			System.out.println("Cedula no es valida!!");
		}
	}
	
	private int getDigito(String cadena) {
		return Integer.parseInt(cadena.substring(7));
	}
	
	private int proximoNumeroValida() {
		if (numeroValidador % 10 == 0) {
			return numeroValidador;
		} else {
			this.numeroValidador++;
			return proximoNumeroValida();
		}
	}
}
