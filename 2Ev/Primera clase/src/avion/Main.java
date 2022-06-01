package avion;
import java.util.Scanner;

public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// Mostrar menu de creaci�n
		System.out.println("Selecciona una opci�n:\n1. Crear avi�n solo con el identificador\n2. "
				+ "Crear avi�n con el identificador y la compa��a\n");
		int opcion = Integer.parseInt(teclado.nextLine());
		switch (opcion) {
			case (1): {
				System.out.println("Introduce el identificador del avi�n: ");
				String id = teclado.nextLine();
				System.out.println("Introduce la capacidad: ");
				int capacidad = Integer.parseInt(teclado.nextLine());
				Avion av1 = new Avion(id, capacidad);
				menuSecundario(av1);
				break;
			}
			case (2): {
				System.out.println("Introduce el identificador del avi�n: ");
				String id = teclado.nextLine();
				System.out.println("Introduce la capacidad: ");
				int capacidad = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce la compa��a: ");
				String compannia = teclado.nextLine();
				Avion av2 = new Avion(id, capacidad, compannia);
				menuSecundario(av2);
				break;
			}
		}
	}

	public static void menuSecundario(Avion avion) {
		// Mostrar opciones
		System.out.println("Selecciona una opci�n:\n1. Asignar vuelo\n2. Obtener el n�mero de vuelos\n"
				+ "3. Obtener el n�mero de kil�metros\n4. Obtener la media de kil�metros por vuelo\n"
				+ "5. Cambio de compa��a\n6. Mostrar informaci�n del avi�n\n 7. Salir\n");
		int opcion = Integer.parseInt(teclado.nextLine());
		do {
			switch (opcion) {
			case (1): {
				System.out.println("Introduce el n�mero se asientos a ocupar: ");
				int ocupados = Integer.parseInt(teclado.nextLine());
				if (ocupados<=avion.getCapacidad()) {
					System.out.println("Introduce los kil�metros que se van a realizar: ");
					int km = Integer.parseInt(teclado.nextLine());
					avion.asignarVuelo(ocupados, km);
					System.out.println("Vuelo asignado.");
				}else {
					System.out.println("Vuelo no asignado, no quedan plazas.");
				}
				break;
			}
			case (2): {
				System.out.println(avion.getNumeroVuelos());
				break;
			}
			case (3): {
				System.out.println(avion.getTotalKm());
				break;
			}
			case (4): {
				System.out.println(avion.getMediaKm());
				break;
			}
			case (5): {
				System.out.println("Introduce la nueva compa��a: ");
				String compannia = teclado.nextLine();
				avion.setCompannia(compannia);
				System.out.println("La nueva compa��a del avi�n es " + avion.getCompannia());
				break;
			}
			case (6): {
				System.out.println("Avi�n con id: " + avion.getIdAvion() + " de la compa��a " + avion.getCompannia()
						+ " ha realizado " + avion.getNumeroVuelos() + " vuelos, con un total de " + avion.getTotalKm()
						+ " km y una media de " + avion.getMediaKm() + " km por vuelo.");
				break;
			}
			}
			// Mostrar men� de nuevo
			System.out.println("Selecciona una opci�n:\n1. Asignar vuelo\n2. Obtener el n�mero de vuelos\n"
					+ "3. Obtener el n�mero de kil�metros\n4. Obtener la media de kil�metros por vuelo\n"
					+ "5. Cambio de compa��a\n6. Mostrar informaci�n del avi�n\n 7. Salir\n");
			opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion != 7);
	}

}
