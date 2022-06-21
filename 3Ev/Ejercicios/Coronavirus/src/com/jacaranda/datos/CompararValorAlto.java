package com.jacaranda.datos;

import java.util.Comparator;

public class CompararValorAlto implements Comparator<Informacion> {

	@Override
	public int compare(Informacion o1, Informacion o2) {
		int salida = 0;
		if(o1.getValor()>o2.getValor()) {
			salida = 1;
		}else if(o1.getValor()<o2.getValor()){
			salida = -1;
		}
		return salida;
	}

}
