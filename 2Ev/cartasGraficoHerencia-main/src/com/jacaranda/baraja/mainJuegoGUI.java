package com.jacaranda.baraja;

import java.util.Scanner;

public class mainJuegoGUI {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws BarajaException {

		System.out.println("1. Baraja Española");
		System.out.println("2. Baraja Inglesa");
		System.out.println("Introduce un número para seleccionar la bajara");
		int tipoBaraja = Integer.parseInt(teclado.nextLine());
		JuegoGUI juego = new JuegoGUI(tipoBaraja);

	}

}
