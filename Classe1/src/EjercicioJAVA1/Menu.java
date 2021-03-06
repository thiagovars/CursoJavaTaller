package EjercicioJAVA1;

public class Menu {
	public static void showMenu(String menu) {
		switch(menu) {
		case "desayuno":
			System.out.println("El menu para Desayuno:");
			System.out.println("- 3 media lunas con caf�");
			System.out.println("- Caf� con leche");
			System.out.println("- Jugo Natural");
			System.out.println("- Capuccino");
			System.out.println("- Brownies");
			System.out.println("- Refuerzo de jam�n");
			System.out.println("- Tostado con Jugo");
			break;
		case "almuerzo":
			System.out.println("El menu para almuerzo:");
			System.out.println("- Media pizza");
			System.out.println("- Pizza y fain�");
			System.out.println("- Chivito canadense");
			System.out.println("- Chivito al plato");
			System.out.println("- Pasta con tuco");
			break;
		case "merienda":
			System.out.println("El menu para merienda:");
			System.out.println("- Caf� con leche");
			System.out.println("- Biscochos salados");
			System.out.println("- Biscochos dulces");
			System.out.println("- Yoyo");
			System.out.println("- Refuerzo de muzarela con jam�n");
			break;
		case "cena":
			System.out.println("El menu para cena:");
			System.out.println("- Pizza hasta 3 gustos");
			System.out.println("- Milanesa de pollo con ensalada russa");
			System.out.println("- Parrilla para 2 personas completa (2 chorizo, costilla, morcilal, pollo y chinchulin");
			System.out.println("- Chivito al plato");
			System.out.println("- Spaghetti con salsa blanca y carne de cerdo");
			break;
		default:
			System.out.println("Estamos cerrados!");
			break;
		}
	}
}
