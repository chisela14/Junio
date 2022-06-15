package com.jacaranda.energia;

import java.time.LocalDate;

public abstract class Generador implements Monetizable{
	
	protected final int CODIGO;
	protected static int codSiguiente =1;
	protected LocalDate fechaInicio;
	protected String localidad;
	protected double potencia;
	
	protected Generador(LocalDate fechaInicio, String localidad, double potencia) {
		CODIGO = codSiguiente;
		codSiguiente ++;
		this.fechaInicio = fechaInicio;
		this.localidad = localidad;
		this.potencia = potencia;
	}

	protected double getPotencia() {
		return potencia;
	}

	protected void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	protected int getCODIGO() {
		return CODIGO;
	}

	protected LocalDate getFechaInicio() {
		return fechaInicio;
	}

	protected String getLocalidad() {
		return localidad;
	}
	
}
