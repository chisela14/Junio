package com.jacaranda.plataforma;

import java.util.Comparator;

public class CompararNombres implements Comparator<Contenido>{

	@Override
	public int compare(Contenido o1, Contenido o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
