package com.jacaranda.baraja;

public class BarajaInglesa extends Baraja {
	
	private static final int CARTAS_BARAJA_INGLESA = 52;

	public BarajaInglesa(int numCartas) throws BarajaException {
		super(CARTAS_BARAJA_INGLESA);
	}

	@Override
	protected String generaPalo() {
		// crear metodo
		
	}

	@Override
	public String toString() {
		return "BarajaInglesa []";
	}
	

}
