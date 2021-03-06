package com.jacaranda.notas;
import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota>{
	//TILDES: PROJECT, RESOURCE, INHERIT FROM CONTAINER MARCADO
	private static int codigoSiguiente = 1;
	private final int CODIGO;
	private String texto;
	private LocalDateTime fechaCreacion; 
	private LocalDateTime fechaUltimaModificacion;
	
	public Nota(String texto) {
		this.texto = texto;
		this.CODIGO = this.codigoSiguiente;
		this.codigoSiguiente ++;
		this.fechaCreacion = LocalDateTime.now();
		this.fechaUltimaModificacion = LocalDateTime.now();
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCodigo() {
		return CODIGO;
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
		return "Nota [codigo=" + CODIGO + ", texto=" + texto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
	}
	
	/**
	 * comparar seg??n su fecha de ultima modificaci??n 
	 * @return 1 si la fecha de la ??ltima modificaci??n es posterior a la de la introducida por par??metro
	 * @return -1 si la fecha de la ??ltima modificaci??n es anterior a la de la introducida por par??metro
	 * @return 0 si se han modificado por ??ltima vez a la misma fecha y hora
	 */
	@Override
	public int compareTo(Nota o) {
		int resultado = 0;
		if (this.fechaUltimaModificacion.isAfter(o.getFechaModificacion())) {
			resultado = 1;
		}else if(this.fechaUltimaModificacion.isBefore(o.getFechaModificacion())) {
			resultado = -1;
		}
		return resultado;
		
	}


}
