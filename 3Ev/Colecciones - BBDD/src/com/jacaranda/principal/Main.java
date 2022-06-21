package com.jacaranda.principal;

import java.util.Scanner;

import com.jacaranda.partituras.Partitura;
import com.jacaranda.partituras.Anonima;
import com.jacaranda.partituras.ConAutor;
import com.jacaranda.partituras.Nota;
import com.jacaranda.partituras.NotaException;
import com.jacaranda.partituras.Pentagrama;

public class Main {
	
	public static Scanner teclado = new Scanner(System.in);

	private static final String MENU = "1. Crear una partitura.\n2. Añadir pentagrama (se pedirán las notas para completarlo).\n"
			+ "3. Modificar una nota de un pentagrama.\n4. Cambiar pentagrama entero.\n5. Eliminar pentagrama.\n"
			+ "6. Mostrar partitura\n7. Salir";
			
	public static void main(String[] args) {
		boolean salir = false;
		Partitura partitura = null;
		Pentagrama p;
		Nota n = null;
		String nombre, tipo;
		char c;
		boolean alta = false;
		int pos;
		do {
			System.out.println(MENU);
			int opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion) {
			case(1):{
				nombre = pedirCadena("el título");
				System.out.println("¿Tiene autor?(s/n): ");
				c = teclado.nextLine().charAt(0);
				if(c=='s') {
					String autor = pedirCadena("el autor");
					partitura = new ConAutor(nombre, autor);
				}else {
					String genero = pedirCadena("el género musical");
					partitura = new Anonima(nombre, genero);
				}
				break;
			}
			case(2):{
				if(partitura==null) {
					System.out.println("Debes crear una partitura primero");
				}else {
					int compas = pedirInt("el compas");
					try {
						partitura.addPentagrama(compas);
						p = partitura.getPentagrama(1);
						boolean lleno = false;
						while(!lleno) {
							nombre = pedirCadena("el nombre de la nota");
							tipo = pedirCadena("el tipo de nota(blanca o negra)");
							c = pedirCadena("si es una nota alta(1) o no(0)").charAt(0);
							if(c=='s') {
								alta = true;
							}
							try {
								p.addNota(nombre, tipo, alta);
							}catch(Exception e) {
								System.out.println(e.getMessage());
								lleno = true;
							}
						}
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			}
			case(3):{
				if(partitura==null) {
					System.out.println("Debes crear una partitura primero");
				}else {
					System.out.println(partitura.mostrarMusica());
					pos = pedirInt("el número del pentagrama");
					int posN = pedirInt("la posición de la nota a cambiar");
					boolean ok = false;
					while(!ok) {
						try {
							n = pedirNota();
							ok = true;	
						}catch(Exception e){
							System.out.println(e.getMessage());
							ok = false;
						}
					}
					partitura.modificarPentagrama(pos, posN, n);
				}
				break;
			}
			case(4):{
				if(partitura==null) {
					System.out.println("Debes crear una partitura primero");
				}else {
					System.out.println(partitura.mostrarMusica());
					pos = pedirInt("el número del pentagrama a modificar");
					p = new Pentagrama(partitura.getPentagrama(pos).getCompas());
					System.out.println("Introduce las nuevas notas: ");
					boolean lleno = false;
					while(!lleno) {
						nombre = pedirCadena("el nombre de la nota");
						tipo = pedirCadena("el tipo de nota(blanca o negra)");
						c = pedirCadena("si es una nota alta(1) o no(0)").charAt(0);
						if(c=='s') {
							alta = true;
						}
						try {
							p.addNota(nombre, tipo, alta);
						}catch(Exception e) {
							System.out.println(e.getMessage());
							partitura.modificarPentagrama(pos, p);
							lleno = true;
						}
					}
				}
				break;
			}
			case(5):{
				if(partitura==null) {
					System.out.println("Debes crear una partitura primero");
				}else {
					System.out.println(partitura.mostrarMusica());
					pos = pedirInt("el número del pentagrama a eliminar");
					try {
						partitura.delPentagrama(pos);
						System.out.println("Pentagrama eliminado");
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			}
			case(6):{
				System.out.println(partitura.toString());
				System.out.println("¿Quieres ver los detalles?(s/n): ");
				c = teclado.nextLine().charAt(0);
				if(c=='s') {
					System.out.println(partitura.mostrarMusica());
				}
				break;
			}
			case(7):{
				salir = true;
				break;
			}
			}
		}while(!salir);                                                                                                    
	}
	private static String pedirCadena(String cadena) {
		System.out.println("Introduce " + cadena + ": ");
		String salida = teclado.nextLine();
		return salida;
	}
	private static int pedirInt(String cadena) {
		System.out.println("Introduce " + cadena + ": ");
		int salida = Integer.parseInt(teclado.nextLine());
		return salida;
	}
	private static Nota pedirNota() throws NotaException {
		String nombre = pedirCadena("el nombre de la nota");
		String tipo = pedirCadena("el tipo de nota(blanca o negra)");
		char c = pedirCadena("si es una nota alta(1) o no(0)").charAt(0);
		boolean alta= false;
		if(c=='s') {
			alta = true;
		}
		Nota n = new Nota(nombre, tipo, alta);
		return n;
	}
	

}
