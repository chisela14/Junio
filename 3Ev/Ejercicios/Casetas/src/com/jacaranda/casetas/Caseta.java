package com.jacaranda.casetas;

import java.util.Objects;

public class Caseta implements Comparable<Caseta>{

	private String titulo;
	private String calle;
	private int numero;
	private int modulos;
	private String clase;
	private String entidad;
	private int id;
	private int idCalle;

	public Caseta(String titulo, String calle, int numero, int modulos, String clase, String entidad, int id, int idCalle) {
		this.titulo = titulo;
		this.calle = calle;
		this.numero = numero;
		this.modulos = modulos;
		this.clase = clase;
		this.entidad = entidad;
		this.id = id;
		this.idCalle = idCalle;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setModulos(int modulos) {
		this.modulos = modulos;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdCalle(int idCalle) {
		this.idCalle = idCalle;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCalle() {
		return calle;
	}

	public int getNumero() {
		return numero;
	}

	public int getModulos() {
		return modulos;
	}

	public String getClase() {
		return clase;
	}

	public String getEntidad() {
		return entidad;
	}

	public int getId() {
		return id;
	}

	public int getIdCalle() {
		return idCalle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caseta other = (Caseta) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Caseta [titulo=" + titulo + ", calle=" + calle + ", numero=" + numero + ", modulos=" + modulos
				+ ", clase=" + clase + ", entidad=" + entidad + ", id=" + id + ", idCalle=" + idCalle + "]";
	}

	@Override
	public int compareTo(Caseta o) {
		int resultado = this.getCalle().compareTo(o.getCalle());
		if(resultado==0) {
			if(this.getNumero()>o.getNumero()) {
				resultado = 1;
			}
			else if(this.getNumero()<o.getNumero()) {
				resultado = -1;
			}
		}
		return resultado;
	}

}
