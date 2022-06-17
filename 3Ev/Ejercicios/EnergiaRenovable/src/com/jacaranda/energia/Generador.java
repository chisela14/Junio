package com.jacaranda.energia;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Generador implements Monetizable, Comparable<Generador>{
	
	private final int CODIGO;
	protected static int codSiguiente =1;
	private LocalDate fechaInicio;
	private String localidad;
	private double potencia;
	
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
	
	
	@Override
	public int hashCode() {
		return Objects.hash(CODIGO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Generador other = (Generador) obj;
		return CODIGO == other.CODIGO;
	}

	@Override
	public int compareTo(Generador o) {
		int salida = 0;
		if(this.fechaInicio.isAfter(o.getFechaInicio())) {
			salida = 1;
		}else if (this.fechaInicio.isBefore(o.getFechaInicio())) {
			salida = -1;
		}
		return salida;
	}
	
}
