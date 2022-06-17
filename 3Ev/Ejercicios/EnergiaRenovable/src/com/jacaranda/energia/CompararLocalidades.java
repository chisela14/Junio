package com.jacaranda.energia;

import java.util.Comparator;

public class CompararLocalidades implements Comparator<Generador> {

	@Override
	public int compare(Generador o1, Generador o2) {
		int resultado = o1.getLocalidad().compareTo(o2.getLocalidad());
		if (resultado == 0) {
			resultado = o1.compareTo(o2); // Es por fecha
		}
		return resultado;
	}

}
