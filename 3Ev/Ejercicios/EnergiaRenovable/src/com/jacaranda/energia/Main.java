package com.jacaranda.energia;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static Empresa e = new Empresa("endesa");
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		String menu = "1. Añadir generador solar\n2. Añadir generador eólico\n3. Mostrar generadores\n4. Mostrar generadores ordenados por localidad\n"
				+ "5. Mostrar generadores eólicos\n6. Borrar generador\n7. ";
		
		boolean salir = false;
		do {
			System.out.println(menu);
			int opcion = Integer.parseInt(teclado.nextLine());
			String localidad;
			LocalDate fecha;
			Double potencia;
			
			switch(opcion) {
				case(1):{
					fecha = pedirFechaInicio();
					localidad = pedirCadena("la localidad");
					potencia = pedirDouble("la potencia");
					Double metros = pedirDouble("el número de metros");
					int numPaneles = pedirInt("el número de paneles");
					TipoGeneradorSolar tipo = pedirTipo();
					GeneradorSolar g = new GeneradorSolar(fecha,localidad, potencia, numPaneles, metros, tipo);
					try {
						e.addGenerador(g);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(2):{
					fecha = pedirFechaInicio();
					localidad = pedirCadena("la localidad");
					potencia = pedirDouble("la potencia");
					int numAspas = pedirInt("el número de aspas");
					GeneradorEolico g = new GeneradorEolico(fecha, localidad, potencia, numAspas);
					try {
						e.addGenerador(g);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(3):{
					System.out.println(e.mostrarGeneradores());
					break;
				}
				case(4):{
					System.out.println(e.mostrarGenLocalidad());
					break;
				}
				case(5):{
					System.out.println(e.mostrarGenEolicos());
					break;
				}
				case(6):{
					System.out.println("Estos son los generadores: " + e.mostrarGeneradores());
					int cod = pedirInt("el código del generador a borrar");
					try {
						e.delGenerador(cod);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(7):{
					double precio = pedirDouble("el precio de la energía");
					System.out.println("El total de energia suministrada es: " + e.totalEnergia(precio));
					break;
				}
				case(8):{
					localidad = pedirCadena("la localidad");
					int cod = pedirInt("el código del generador a buscar");
					boolean b =e.existeGenerador(localidad, cod);
					if(b) {
						System.out.println("El generador existe en esa localidad");
					}else {
						System.out.println("El generador no existe en esa localidad");
					}
					break;
				}
				case(9):{
					salir = true;
					break;
				}
			}
		}while (salir ==false);
	}
	
	private static String pedirCadena(String cadena) {
		System.out.println("Introduce " + cadena + ": ");
		String salida = teclado.nextLine();
		return salida;
	}
	private static LocalDate pedirFechaInicio() {
		System.out.println("Introduce la fecha de inicio  del generador(yyyy-mm-dd): ");
		LocalDate salida = LocalDate.parse(teclado.nextLine());
		return salida;
	}
	private static Double pedirDouble(String cadena) {
		System.out.println("Introduce " + cadena + ": ");
		Double salida = Double.parseDouble(teclado.nextLine());
		return salida;
	}
	private static int pedirInt(String cadena) {
		System.out.println("Introduce " + cadena + ": ");
		int salida = Integer.parseInt(teclado.nextLine());
		return salida;
	}
	private static TipoGeneradorSolar pedirTipo() {
		System.out.println("Introduce el tipo de generador solar(" + Arrays.toString(TipoGeneradorSolar.values()) + "): ");
		String cadena = teclado.nextLine().toUpperCase();
		TipoGeneradorSolar salida = TipoGeneradorSolar.valueOf(cadena);
		return salida;
	}
	/*
	public static void pruebas() throws EmpresaException{
	
		//mostrar
		GeneradorEolico ge1 = new GeneradorEolico(LocalDate.parse("2020-10-25"),"Sevilla", 2, 4);
		e.addGenerador(ge1);
		System.out.println(e.mostrarGeneradores());
		GeneradorEolico ge2 = new GeneradorEolico(LocalDate.parse("2020-10-25"),"Sevilla", 2, 4);
		//e.addGenerador(ge1); salta exception
		e.addGenerador(ge2);
		System.out.println(e.mostrarGeneradores());
		
		//mostrar Localidad
		GeneradorSolar gs1 = new GeneradorSolar(LocalDate.parse("2020-10-26"),"Sevilla", 2, 8, 20, TipoGeneradorSolar.FOTOVOLTAICO);
		GeneradorSolar gs2 = new GeneradorSolar(LocalDate.parse("2020-10-27"),"Sevilla", 2, 8, 20, TipoGeneradorSolar.FOTOVOLTAICO);
		e.addGenerador(gs1);
		e.addGenerador(gs2);
		GeneradorEolico ge3 = new GeneradorEolico(LocalDate.parse("2020-10-24"),"Zaragoza", 2, 4);
		e.addGenerador(ge3);
		System.out.println(e.mostrarGenLocalidad());
		System.out.println(e.mostrarGenEolicos());
		System.out.println(e.mostrarGeneradores());
		
		//borrar
		System.out.println(e.mostrarGeneradores());
		e.delGenerador(2);
		System.out.println(e.mostrarGeneradores());
		// e.delGenerador(6); salta exception
		
		//mostrar energia, existe generador
		System.out.println("El total de energia suministrada es: " + e.totalEnergia(2));
		System.out.println(e.existeGenerador("Zaragoza", 4));//false
		System.out.println(e.existeGenerador("Zaragoza", 5));//true
	}*/
}
