package com.jacaranda.energia;

import java.time.LocalDate;

public class GeneradorEolico extends Generador {
	
	private int numAspas;

	public GeneradorEolico(LocalDate fechaInicio, String localidad, double potencia, int numAspas) {
		super(fechaInicio, localidad, potencia);
		this.numAspas = numAspas;
	}

	public int getNumAspas() {
		return numAspas;
	}

	public void setNumAspas(int numAspas) {
		this.numAspas = numAspas;
	}

	@Override
	public Double dinero(double precioEnergia) {
		return precioEnergia*super.getPotencia()*numAspas;
	}

	@Override
	public String toString() {
		return "GeneradorEolico [numAspas=" + numAspas + ", CODIGO=" + super.getCODIGO() + ", fechaInicio=" + super.getFechaInicio()
				+ ", localidad=" + super.getLocalidad() + ", potencia=" + super.getPotencia() + "]";
	}

}
