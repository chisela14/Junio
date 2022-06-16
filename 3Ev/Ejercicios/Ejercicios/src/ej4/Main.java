package ej4;

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
					Significado s = new Significado(significado);
					Palabra p = new Palabra(palabra,s);
					d.addPalabra(p);
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
						d.buscarPalabra(palabra);
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
		
	}
	private static String pedirCadena(String cadena) {
		System.out.println("Introduce "+cadena+": " );
		String salida = teclado.nextLine();
		return salida;
	}
	
	public void pruebas() throws DiccionarioException {
		Significado s1 = new Significado("instrumento musical");
		Palabra teclado = new Palabra("teclado",s1);
		d.addPalabra(teclado);
		System.out.println(d.mostrarPalabras());
		
		Significado s2 = new Significado("instrumento de escritura");
		teclado = new Palabra("teclado",s2);
		d.addPalabra(teclado);
		System.out.println(d.mostrarPalabras());
		
		Significado s3 = new Significado("bebida alcoholica");
		Palabra tequila = new Palabra("tequila", s3);
		Significado s4 = new Significado("trozo de tela que cubre una zona");
		Palabra toldo = new Palabra("toldo", s4);
		Significado s5 = new Significado("tipo de árbol");
		Palabra pino = new Palabra("pino", s5);
		d.addPalabra(tequila);
		d.addPalabra(toldo);
		d.addPalabra(pino);
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
	}

}
