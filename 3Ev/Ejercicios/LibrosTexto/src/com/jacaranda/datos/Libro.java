package com.jacaranda.datos;

import java.util.Objects;

public class Libro {
	
	private String titulo;
	private String editorial;
	private String ean;
	private String digital;
	
	public Libro(String titulo, String editorial, String ean, String digital) {
		this.titulo = titulo;
		this.editorial = editorial;
		this.ean = ean;
		this.digital = digital;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getDigital() {
		return digital;
	}

	public void setDigital(String digital) {
		this.digital = digital;
	}

	@Override
	public int hashCode() {
		return Objects.hash(digital, ean, editorial, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(digital, other.digital) && Objects.equals(ean, other.ean)
				&& Objects.equals(editorial, other.editorial) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", editorial=" + editorial + ", ean=" + ean + ", digital=" + digital + "]";
	}

	
}
