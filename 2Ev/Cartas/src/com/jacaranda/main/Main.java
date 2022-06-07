package com.jacaranda.main;

import com.jacaranda.baraja.BarajaEspannola;
import com.jacaranda.baraja.BarajaException;
import com.jacaranda.baraja.BarajaInglesa;

public class Main {

	public static void main(String[] args) throws BarajaException {
		// crear baraja espannola
		BarajaEspannola b1 = new BarajaEspannola();
		System.out.println(b1.toString());
		
		//crear baraja inglesa
		BarajaInglesa b2 = new BarajaInglesa();
		System.out.println(b2.toString());
	}

}
