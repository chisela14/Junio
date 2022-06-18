package com.jacaranda.partituras;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

abstract class Partitura {
	
	private String nombre;
	private LinkedList<Pentagrama> pentagramas;
	private static final int MAX_PENTAGRAMAS = 20;
	private static final int MIN_PENTAGRAMAS = 5;
	
	protected Partitura(String nombre) {
		this.nombre = nombre;
		pentagramas = new LinkedList<>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public Pentagrama getPentagrama(int posicion) {
		return pentagramas.get(posicion-1);
	}

	public void addPentagrama(int compas) throws PartituraException {
		if(compas<2 || compas>4) {
			throw new PartituraException("Compás no válido, valores de compás válidos: 2, 3, 4");
		}else if(pentagramas.size()== MAX_PENTAGRAMAS) {
			throw new PartituraException("No se pueden añadir más pentagramas a la partitura");
		}
		Pentagrama p = new Pentagrama(compas);
		pentagramas.add(p);
	}
	
	public void delPentagrama(int pos) throws PartituraException {
		Pentagrama p = pentagramas.get(pos-1);
		if(pentagramas.contains(p)) {
			pentagramas.remove(p);
		}else {
			throw new PartituraException("Esa posición no es válida");
		}
	}
	
	//se me olvidó poner en el uml el parámetro Pentagrama
	//no especifique que podria modificarse entero o solo una nota
	public void modificarPentagrama(int posicion, Pentagrama nuevo) {
		pentagramas.set(posicion-1, nuevo);
	}
	
	public void modificarPentagrama(int posicionP, int posicionN, Nota nueva) {
		Pentagrama p = pentagramas.get(posicionP-1);
		LinkedList<Nota> notas = p.getNotas();
		notas.set(posicionN-1, nueva);
	}
	
	public String mostrarMusica() {
		StringBuilder salida = new StringBuilder();
		salida.append(this.nombre + ": " + System.lineSeparator());
		int contador = 1;
		for(Pentagrama p: pentagramas) {
			if(!p.isSilenciado()) {
				salida.append("Pentagrama " + contador + ": ");
				
			}else {
				salida.append("Pentagrama SILENCIADO" + contador + ": ");
			}
			salida.append(p.mostrarNotas() + System.lineSeparator());
			contador ++;
		}
		if(pentagramas.size()<= MIN_PENTAGRAMAS) {
			salida.append("La partitura se encuentra por debajo del número de pentagramas aconsejable");
		}
		return salida.toString();
	}

	@Override
	public String toString() {
		return "La partitura de " + nombre + " tiene " + pentagramas.size() + " pentagramas.";
	}
	
	//será el mismo para los hijos
	@Override
	public int hashCode() {
		return Objects.hash(nombre, pentagramas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partitura other = (Partitura) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(pentagramas, other.pentagramas);
	}
	
}
