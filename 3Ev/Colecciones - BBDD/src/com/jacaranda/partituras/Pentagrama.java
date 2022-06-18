package com.jacaranda.partituras;

import java.util.LinkedList;
import java.util.Objects;

public class Pentagrama implements Silenciable, Cloneable{
	
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
		//si el pentagrama esta vacio se añade la nota directamente
		if(notas.isEmpty()) {
			notas.add(nota);
		}else { //sino hay que comprobar que se puede añadir según la duración de la nota
			//calcular valor actual del pentagrama
			int valor = 0;
			for(Nota n: notas) {
				valor = valor + n.getTipo().getDuracion();
			}//añadir o no en función de la condición
			if(valor==this.compas || nota.getTipo().getDuracion()+ valor > this.compas) {
				throw new PentagramaException("No se puede añadir la nota porque sobrepasa el límite del compás");
			}else {
				notas.add(nota);
			}
		}
	}
	//para probar a borrar una nota, puede que borre este método luego
	public void delNota(int pos) throws PentagramaException{
		Nota n = this.notas.get(pos-1);
		if(this.notas.contains(n)) {
			this.notas.remove(n);
		}else {
			throw new PentagramaException("Esa posición no es válida");
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
		return "Pentagrama: Compás: " + compas + ", Notas: " + mostrarNotas();
	}

	@Override
	protected Object clone() {
		Pentagrama obj = null;
		try {
			obj = (Pentagrama) super.clone();
		}catch(CloneNotSupportedException e) {
			System.out.println("No se puede duplicar");
		}
		obj.notas = (LinkedList<Nota>) obj.notas.clone();
		return obj;
	}

	
	
}
