package com.jacaranda.datos;

import java.util.HashSet;
import java.util.Objects;

public class Centro {
	
	private String tipo;
	private String codigo;
	private String nombre;
	private HashSet<Curso> cursos;
	
	public Centro(String tipo, String codigo, String nombre) {
		this.tipo = tipo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.cursos = new HashSet<>();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(HashSet<Curso> cursos) {
		this.cursos = cursos;
	}
	public void addCurso(Curso c) {
		this.cursos.add(c);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(tipo, other.tipo);
	}
	
	
}
