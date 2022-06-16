package com.jacaranda.energia;

import java.time.LocalDate;

public class GeneradorSolar extends Generador{
	
	private int numPaneles;
	private double metros;
	private TipoGeneradorSolar tipo;

	public GeneradorSolar(LocalDate fechaInicio, String localidad, double potencia, int numPaneles, double metros,
			TipoGeneradorSolar tipo) {
		super(fechaInicio, localidad, potencia);
		this.numPaneles = numPaneles;
		this.metros = metros;
		this.tipo = tipo;
	}
	
	public int getNumPaneles() {
		return numPaneles;
	}

	public void setNumPaneles(int numPaneles) {
		this.numPaneles = numPaneles;
	}

	public double getMetros() {
		return metros;
	}

	public void setMetros(double metros) {
		this.metros = metros;
	}

	public TipoGeneradorSolar getTipo() {
		return tipo;
	}

	public void setTipo(TipoGeneradorSolar tipo) {
		this.tipo = tipo;
	}

	@Override
	public Double dinero(double precioEnergia) {
		return precioEnergia*potencia*numPaneles;
	}

	@Override
	public String toString() {
		return "GeneradorSolar [coeficienteSolar=" + numPaneles/metros + ", tipo=" + tipo + ", CODIGO=" + CODIGO + ", fechaInicio="
				+ fechaInicio + ", localidad=" + localidad + ", potencia=" + potencia + "]";
	}



	
	
}
