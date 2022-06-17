package com.jacaranda.partituras;

import java.util.LinkedList;
import java.util.Objects;

public class Pentagrama implements Silenciable{
	
	private int compas;
	private LinkedList<Nota> notas;
	private boolean silenciado;

	public Pentagrama(int compas) {
		this.compas = compas;
		notas = new LinkedList<>();
		this.silenciado = false;
	}
	
	public int getCompas() {
		return compas;
	}

	public void setCompas(int compas) {
		this.compas = compas;
	}
	
	public LinkedList<Nota> getNotas() {
		return notas;
	}

	public void addNota(String nombre, String tipo, boolean alta) throws NotaException, PentagramaException{
		Nota nota = new Nota(nombre,tipo,alta);
		//si el pentagrama esta vacio se a�ade la nota directamente
		if(notas.isEmpty()) {
			notas.add(nota);
		}else { //sino hay que comprobar que se puede a�adir seg�n la duraci�n de la nota
			//calcular valor actual del pentagrama
			int valor = 0;
			for(Nota n: notas) {
				valor = valor + n.getTipo().getDuracion();
			}//a�adir o no en funci�n de la condici�n
			if(valor==this.compas || nota.getTipo().getDuracion()+ valor > this.compas) {
				throw new PentagramaException("No se puede a�adir la nota porque sobrepasa el l�mite del comp�s");
			}else {
				notas.add(nota);
			}
		}
	}

	public String mostrarNotas() {
		StringBuilder salida = new StringBuilder();
		for(Nota n: notas) {
			salida.append(n.toString()+ " ");
		}
		return salida.toString();
	}
	
	public boolean isSilenciado() {
		return silenciado;
	}
	

	//modificar una nota en el pentagrama
	public void modificarNota(int posicion, Nota nueva) {
		notas.set(posicion, nueva);
	}
	
	@Override
	public void silenciar() {
		this.silenciado = true;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(compas, notas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pentagrama other = (Pentagrama) obj;
		return compas == other.compas && Objects.equals(notas, other.notas);
	}

	@Override
	public String toString() {
		return "Pentagrama: Comp�s: " + compas + ", Notas: " + mostrarNotas();
	}
	
}
