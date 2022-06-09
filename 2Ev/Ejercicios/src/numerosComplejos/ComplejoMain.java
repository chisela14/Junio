package numerosComplejos;

import java.util.Scanner;

public class ComplejoMain {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean salir = false;
		do {
			System.out.println("¿Qué quieres hacer?:\n1. Sumar números complejos\n2. Restar números complejos\n3. Salir\n");
			int opcion = Integer.parseInt(teclado.nextLine());
			
			switch(opcion) {
				case(1):{
					// Crear dos numeros complejos y mostrar resultado
					System.out.println("Introduce el primer número: ");
					Complejo c1 = pedirComplejo();
					System.out.println("Introduce el segundo número: ");
					Complejo c2 = pedirComplejo();
					System.out.println("El resultado es el "+c1.suma(c2).toString());
					break;
				}
				case(2):{
					// Crear dos numeros complejos y mostrar resultado
					System.out.println("Introduce el primer número: ");
					Complejo c1 = pedirComplejo();
					System.out.println("Introduce el segundo número: ");
					Complejo c2 = pedirComplejo();
					System.out.println("El resultado es el "+c1.resta(c2).toString());
					break;
				}
				case(3):{
					salir = true;
					break;
				}
			}
		} while (salir = false);
	}
	
	//entiendo que usar System.out.println en un metodo no es lo mas optimo pero ahorra mucha repeticion de codigo
	//para este ejercicio de caracter mas sencillo
	public static Complejo pedirComplejo() {
		System.out.println("Introduce la parte real: ");
		double pReal = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce la parte imaginaria: ");
		double pImaginaria = Double.parseDouble(teclado.nextLine());
		Complejo resultado = new Complejo (pReal, pImaginaria);
		return resultado;
	}
}
