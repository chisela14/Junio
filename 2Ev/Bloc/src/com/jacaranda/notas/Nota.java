package com.jacaranda.notas;
import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota>{
	
	private static int codigoSiguiente;
	private int codigo;
	private String texto;
	private LocalDateTime fechaCreacion; 
	private LocalDateTime fechaUltimaModificacion;
	
	public Nota(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaUltimaModificacion;
	}
	
	public boolean isModificado() {
		boolean resultado = true;
		if (fechaCreacion == fechaUltimaModificacion) {
			resultado = false;
		}
		return resultado;
	}
	
	public boolean isEmpty() {
		boolean resultado = false;
		if (texto.equals("")) {
			resultado = true;
		}
		return resultado;
	}
	
	public boolean isCreadoAnterior (Nota nota) {
		boolean resultado = false;
		if (fechaCreacion.isAfter(nota.getFechaCreacion())) {
			resultado = true;
		}
		return resultado;
	}
	
	public boolean isModificadoAnterior (Nota nota) {
		boolean resultado = false;
		if (fechaUltimaModificacion.isAfter(nota.getFechaModificacion())) {
			resultado = true;
		}
		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto);
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
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", texto=" + texto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
	}

	@Override
	public int compareTo(Nota o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
