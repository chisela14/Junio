package com.jacaranda.partituras;

public enum TipoNota {
	
	BLANCA(2),
	NEGRA(1);
	
	private int duracion;

	TipoNota(int duracion) {
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}
	
}
