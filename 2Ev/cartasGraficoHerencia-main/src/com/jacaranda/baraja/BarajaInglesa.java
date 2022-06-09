package com.jacaranda.baraja;

import java.util.Arrays;

public class BarajaInglesa extends Baraja {
	
	private static final int CARTAS_BARAJA_INGLESA = 52;

	public BarajaInglesa() throws BarajaException {
		super(CARTAS_BARAJA_INGLESA);
	}

	@Override
	protected String generaPalo() {
		int num = (int) (Math.random()*PALOS);
		PalosBarajaInglesa[] array = PalosBarajaInglesa.values();
		return array[num].toString();
	}

	@Override
	public String toString() {
		return "BarajaInglesa [numCartas=" + numCartas + ", cartas=" + Arrays.toString(cartas) + "]";
	}

	
	

}
