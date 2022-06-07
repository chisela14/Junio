package com.jacaranda.baraja;

public class BarajaEspannola extends Baraja {
	
	private static final int CARTAS_BARAJA_ESPANNOLA = 40;

	public BarajaEspannola() throws BarajaException {
		super(CARTAS_BARAJA_ESPANNOLA);
	}

	@Override
	protected String generaPalo() {
		//crear metodo
		
	}

	@Override
	public String toString() {
		return "BarajaEspannola []";
	}
	
}
