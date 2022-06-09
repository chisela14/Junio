package cuenta;

import java.util.Scanner;

public class CuentaMain {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Crear cuenta 
		System.out.println("Introduce tu saldo: ");
		double saldo = Double.parseDouble(teclado.nextLine());
		Cuenta c1 = new Cuenta (saldo);
		
		//bandera que marca la salida del bucle
		boolean salir = false;
		//contadores para la opcion de consulta
		int totalReintegros = 0, totalIngresos = 0;
		
		//Bucle para que muestre el menu al usuario siempre que no elija la opcion para finalizar
		do {
			//mostrar menu al usuario y guardar su eleccion
			System.out.println("¿Qué opción quieres realizar con tu cuenta?:\n1. Hacer un reintegro\n2. Hacer un ingreso"
					+ "\n3. Consultar el saldo y el número de ingresos y reintegros realizados\n4. Salir\n");
			int opcion = Integer.parseInt(teclado.nextLine());
		
			//crear switch con diferentes case segun las opciones
			switch (opcion) {
				case (1):{
					System.out.println("Introduce la cantidad a retirar: ");
					double reintegro = Double.parseDouble(teclado.nextLine());
					c1.hacerReintegro (reintegro);
					System.out.println("Tu nuevo saldo es: " + c1.getSaldo());
					totalReintegros++;
					break;
				}
				case (2): {
					System.out.println("Introduce la cantidad a ingresar: ");
					double ingreso = Double.parseDouble(teclado.nextLine());
					c1.hacerIngreso (ingreso);
					System.out.println("Tu nuevo saldo es: " + c1.getSaldo());
					totalIngresos++;
					break;
				}
				case (3):{
					System.out.println("Tu saldo es: " + c1.getSaldo() + ". Has realizado " + totalIngresos + " ingresos y " + totalReintegros + " reintegros.");
					break;
				}
				case (4): {
					System.out.println("¿Realmente desea salir?(S/N): ");
					char confirmacion = teclado.nextLine().charAt(0);
					if (confirmacion == 'S') {
						System.out.println("Tu saldo es: " + c1.getSaldo());
						salir = true;
					}
					break;
				}
			}
		}while (salir == false);
	}
}
