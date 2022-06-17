package ej5;

import java.util.Scanner;

public class Main {
	
	private static Scanner teclado = new Scanner(System.in);
	
	private static Diccionario d = new Diccionario("esp");
	
	public static void main(String[] args) {
		
		String menu = "1. Añadir palabra\n2. Buscar palabra en el diccionario\n3. Borrar una palabra\n4. Listado de"
				+ "palabras que empiecen por...\n5. Salir";
		
		boolean salir = false;
		do {
			System.out.println(menu);
			int opcion = Integer.parseInt(teclado.nextLine());
			String palabra, significado, inicio;
			
			switch(opcion) {
				case(1):{
					palabra = pedirCadena("la palabra");
					significado = pedirCadena("el significado");
					try {
						d.addPalabra(palabra,significado);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(2):{
					palabra = pedirCadena("la palabra");
					try {
						d.buscarPalabra(palabra);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(3):{
					palabra = pedirCadena("la palabra");
					try {
						d.borrarPalabra(palabra);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(4):{
					inicio = pedirCadena("el inicio de las palabras a listar");
					try {
						d.palabrasEmpiezanPor(inicio);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(5):{
					salir = true;
					break;
				}
			}
		}while(!salir);
		
		/* pruebas rápidas
		d.addPalabra("teclado","instrumento musical");
		System.out.println(d.mostrarPalabras());
		
		
		d.addPalabra("teclado","instrumento de escritura");
		System.out.println(d.mostrarPalabras());
		
		d.addPalabra("tequila","bebida alcoholica");
		d.addPalabra("toldo", "trozo de tela que cubre una zona");
		d.addPalabra("pino", "tipo de árbol");
		System.out.println(d.mostrarPalabras());
		
		try {
			System.out.println(d.palabrasEmpiezanPor("te"));
		} catch (DiccionarioException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(d.palabrasEmpiezanPor("tu"));
		} catch (DiccionarioException e) {
			System.out.println(e.getMessage());
		}
		try {
			d.buscarPalabra("poncho");
		} catch (DiccionarioException e) {
			System.out.println(e.getMessage());
		}
		try {
			d.borrarPalabra("poncho");
		} catch (DiccionarioException e) {
			System.out.println(e.getMessage());
		}
		*/
	}
	
	private static String pedirCadena(String cadena) {
		System.out.println("Introduce "+cadena+": " );
		String salida = teclado.nextLine();
		return salida;
	}

}
