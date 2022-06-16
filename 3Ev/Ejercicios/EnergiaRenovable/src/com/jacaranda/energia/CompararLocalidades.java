package com.jacaranda.energia;

import java.util.Comparator;

public class CompararLocalidades implements Comparator<Generador> {

	@Override
	public int compare(Generador o1, Generador o2) {
		return o1.getLocalidad().compareTo(o2.getLocalidad());
	}

}
