package EjercicioJAVA2;

public class Ejercicio5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sexo    = 0;
		int trabaja = 0;
		int sueldo  = 0;
		Persona personas[] = new Persona[10];
		for (int indice=0; indice < 10; indice++) {
			sexo = (int)(Math.random()*2+1);
			trabaja = (int)(Math.random()*2+1);
			if (trabaja == 1) {
				sueldo = (int)(Math.random()*1400+600); 
			} else {
				sueldo = 0;
			}
			Persona p = new Persona(sexo, trabaja, sueldo);
			personas[indice] = p;
		}
		
		Util util = new Util();
		System.out.println("Porcentaje de hombres : " + util.percentageSexo(personas, 1));
		System.out.println("Porcentaje de mujeres: " + util.percentageSexo(personas, 2));
		System.out.println("Porcentaje de hombres que trabajan: " + util.percTrabajo(personas, 1));
		System.out.println("Porcentaje de mujeres que trabajan: " + util.percTrabajo(personas, 2));
		System.out.println("El sueldo promedio de los hombres que trabajan: " + util.mediaSueldo(personas, 1));
		System.out.println("El sueldo promedio de las mujeres que trabajan: " + util.mediaSueldo(personas, 2));
	}
}