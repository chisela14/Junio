package com.jacaranda.casetas;

import java.util.Comparator;

public class CompararNumeros implements Comparator<Caseta>{

	@Override
	public int compare(Caseta o1, Caseta o2) {
		int resultado = o1.compareTo(o2);
		if(resultado==0) {
			if(o1.getNumero()>o2.getNumero()) {
				resultado = 1;
			}
			else if(o1.getNumero()<o2.getNumero()) {
				resultado = -1;
			}
		}
		return resultado;
	}

	

}
