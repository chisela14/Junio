package ej5;

import java.util.Scanner;

import ej4.Palabra;
import ej4.Significado;
import ej4.DiccionarioException;

public class Main {
	
	private static Scanner teclado = new Scanner(System.in);
	
	private static Diccionario d = new Diccionario("esp");

	public static void main(String[] args) throws DiccionarioException {
		
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
