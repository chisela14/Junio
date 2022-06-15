package ej2;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {

public static Scanner teclado = new Scanner(System.in);
	
	public static String menu = "1. Nueva página consultada\n2. Consultar historial completo\n"
			+ "3. Consultar historial de un día\n4. Borrar historial completo\n5. Salir";
	
	public static void main(String[] args) {
		
		boolean salir = false;
		Historial h = new Historial();
		do {
			System.out.println(menu);
			int opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion) {
				case(1):{
					System.out.println("Introduce la página consultada: ");
					String url = teclado.nextLine();
					h.addPagina(url);
					break;
				}
				case(2):{
					System.out.println(h.mostrarHistorial());
					break;
				}
				case(3):{
					System.out.println("Introduce el día a mostrar en el historial (yyyy-mm-dd): ");
					LocalDate dia = LocalDate.parse(teclado.nextLine());
					System.out.println(h.mostrarHistorialDia(dia));
					break;
				}
				case(4):{
					h.borrarHistorial();
					break;
				}
				case(5):{
					salir = true;
					break;
				}
			}
		}while(salir==false);

	}

}
