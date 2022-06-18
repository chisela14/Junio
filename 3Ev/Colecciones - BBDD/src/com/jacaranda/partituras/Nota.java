package com.jacaranda.partituras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Nota implements Cloneable{
	
	private String nombre;
	private TipoNota tipo;
	private boolean alta;
	private static final ArrayList<String> NOMBRES = new ArrayList<>(Arrays.asList("do","re","mi","fa","sol","la","si"));
	
	public Nota(String nombre, String tipo, boolean alta) throws NotaException {
		if(!NOMBRES.contains(nombre)) {
			throw new NotaException("La nota no se ha podido crear puesto que el nombre no es correcto");
		}else if(!comprobarTipo(tipo)){
			throw new NotaException("El tipo de nota introducido no está registrado");
		}else {
			this.nombre = nombre;
			this.tipo = TipoNota.valueOf(tipo.toUpperCase());
			this.alta = alta;
		}
	}
	public boolean comprobarTipo(String tipo) {
		boolean resultado = true;
		try {
			TipoNota.valueOf(tipo.toUpperCase());
		}catch(Exception e) {
			resultado = false;
		}
		return resultado;
	}
	
	public TipoNota getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alta, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return alta == other.alta && Objects.equals(nombre, other.nombre) && tipo == other.tipo;
	}

	@Override
	public String toString() {
		String salida;
		if(alta) {
			salida = nombre + "' " + tipo;
		}else {
			salida = nombre + " " + tipo;
		}
		return salida;
	}
	
	@Override
	protected Object clone() {
		Nota obj = null;
		try {
			obj = (Nota) super.clone();
		}catch(CloneNotSupportedException e) {
			System.out.println("No se puede duplicar");
		}
		return obj;
	}
	
	
}
