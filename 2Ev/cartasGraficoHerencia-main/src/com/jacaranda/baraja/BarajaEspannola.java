package com.jacaranda.baraja;

import java.util.Arrays;

public class BarajaEspannola extends Baraja {
	
	private static final int CARTAS_BARAJA_ESPANNOLA = 40;

	public BarajaEspannola() throws BarajaException {
		super(CARTAS_BARAJA_ESPANNOLA);
	}

	@Override
	protected String generaPalo() {
		int num = (int) (Math.random()*PALOS);
		PalosBarajaEspannola[] array = 	PalosBarajaEspannola.values();
		return array[num].toString();
	}

	@Override
	public String toString() {
		return "BarajaEspannola [numCartas=" + numCartas + ", cartas=" + Arrays.toString(cartas) + "]";
	}

	
	
}
