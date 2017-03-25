package EjercicioJAVA2;

public class Util {
	
	
	public int percentageSexo(Persona[]  personas, int condicion) {
		// separacion SON LOS DATOS QUE CUMPLEN CON LA CONDICION
		int separacion = 0;
		int percentage = 0;
		int i;
		for	(i=0; i < personas.length; i++) {
			if (personas[i].getSexo() == condicion) {
				separacion++;
			}
		}
		percentage = (separacion*100)/personas.length;
		return percentage;
	}
	
	public int percTrabajo(Persona[] personas, int condicion) {
		// separacion SON LOS DATOS QUE CUMPLEN CON LA CONDICION
		int separacion = 0;
		int percentage = 0;
		int i;
		for	(i=0; i < personas.length; i++) {
			if (personas[i].getSexo() == condicion && personas[i].getTrabajo() == 1) {
				separacion++;
			}
		}
		percentage = (separacion*100)/personas.length;
		return percentage;
	}
	
	public int mediaSueldo(Persona[] personas, int condicion) {
		// separacion SON LOS DATOS QUE CUMPLEN CON LA CONDICION
		int mediaSueldo = 0;
		int sueldo      = 0;
		int i;
		for	(i=0; i < personas.length; i++) {
			if (personas[i].getSexo() == condicion && personas[i].getTrabajo() == 1) {
				sueldo += personas[i].getSueldo();
			}
		}
		mediaSueldo = (sueldo*100)/(this.percentageSexo(personas, condicion));
		return mediaSueldo;
	}
	
}
