package avion;
import java.util.Scanner;

public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// Mostrar menu de creación
		System.out.println("Selecciona una opción:\n1. Crear avión solo con el identificador\n2. "
				+ "Crear avión con el identificador y la compañía\n");
		int opcion = Integer.parseInt(teclado.nextLine());
		switch (opcion) {
			case (1): {
				System.out.println("Introduce el identificador del avión: ");
				String id = teclado.nextLine();
				System.out.println("Introduce la capacidad: ");
				int capacidad = Integer.parseInt(teclado.nextLine());
				Avion av1 = new Avion(id, capacidad);
				menuSecundario(av1);
				break;
			}
			case (2): {
				System.out.println("Introduce el identificador del avión: ");
				String id = teclado.nextLine();
				System.out.println("Introduce la capacidad: ");
				int capacidad = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce la compañía: ");
				String compannia = teclado.nextLine();
				Avion av2 = new Avion(id, capacidad, compannia);
				menuSecundario(av2);
				break;
			}
		}
	}

	public static void menuSecundario(Avion avion) {
		// Mostrar opciones
		System.out.println("Selecciona una opción:\n1. Asignar vuelo\n2. Obtener el número de vuelos\n"
				+ "3. Obtener el número de kilómetros\n4. Obtener la media de kilómetros por vuelo\n"
				+ "5. Cambio de compañía\n6. Mostrar información del avión\n 7. Salir\n");
		int opcion = Integer.parseInt(teclado.nextLine());
		do {
			switch (opcion) {
			case (1): {
				System.out.println("Introduce el número se asientos a ocupar: ");
				int ocupados = Integer.parseInt(teclado.nextLine());
				if (ocupados<=avion.getCapacidad()) {
					System.out.println("Introduce los kilómetros que se van a realizar: ");
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
				System.out.println("Introduce la nueva compañía: ");
				String compannia = teclado.nextLine();
				avion.setCompannia(compannia);
				System.out.println("La nueva compañía del avión es " + avion.getCompannia());
				break;
			}
			case (6): {
				System.out.println("Avión con id: " + avion.getIdAvion() + " de la compañía " + avion.getCompannia()
						+ " ha realizado " + avion.getNumeroVuelos() + " vuelos, con un total de " + avion.getTotalKm()
						+ " km y una media de " + avion.getMediaKm() + " km por vuelo.");
				break;
			}
			}
			// Mostrar menú de nuevo
			System.out.println("Selecciona una opción:\n1. Asignar vuelo\n2. Obtener el número de vuelos\n"
					+ "3. Obtener el número de kilómetros\n4. Obtener la media de kilómetros por vuelo\n"
					+ "5. Cambio de compañía\n6. Mostrar información del avión\n 7. Salir\n");
			opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion != 7);
	}

}
