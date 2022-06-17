package com.jacaranda.energia;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Empresa {
	private String nombre;
	private LinkedList<Generador> generadores;
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		generadores = new LinkedList<>();
	}
	
	public void addGenerador(Generador g) throws EmpresaException {
		if(generadores.contains(g)) {
			throw new EmpresaException("El generador ya está registrado en la empresa");
		}else {
			generadores.add(g);
		}
	}
	
	public String mostrarGeneradores() {
		StringBuilder salida = new StringBuilder();
		Collections.sort(generadores);
		Iterator<Generador> itr = generadores.iterator();
		while(itr.hasNext()) {
			salida.append(itr.next().toString() + System.lineSeparator());
		}
		return salida.toString();
	}
	
	public String mostrarGenLocalidad() {
		CompararLocalidades comp = new CompararLocalidades();
		Collections.sort(generadores, comp);
		/*
		StringBuilder salida = new StringBuilder();
		Iterator<Generador> itr = generadores.iterator();
		while(itr.hasNext()) {
			salida.append(itr.next().toString()+ System.lineSeparator());
		}
		return salida.toString();*/
		return mostrarGeneradores();
	}
	
	public String mostrarGenEolicos() {
		StringBuilder salida = new StringBuilder();
		Collections.sort(generadores);
		for(Generador g: generadores) {
			if(g instanceof GeneradorEolico) {
				salida.append(g.toString()+ System.lineSeparator());
			}
		}
		return salida.toString();
	}
	
	public void delGenerador(int cod) throws EmpresaException {
		boolean encontrado = false;
		Iterator<Generador> itr = generadores.iterator();
		while(itr.hasNext() && !encontrado) {
			Generador g = itr.next();
				if(g.getCODIGO()==cod) {
					generadores.remove(g);
					encontrado = true;
				}
		}
		if(!encontrado) {
			throw new EmpresaException("No hay ningún generador en la empresa con ese código");
		}
	}
	
	//no me queda claro que es el total de energia
	//hago la suma del metodo dinero de todos los generadores
	public double totalEnergia(double precio) {
		double resultado = 0;
		Iterator<Generador> itr = generadores.iterator();
		while(itr.hasNext()) {
			resultado = resultado + itr.next().dinero(precio);
		}
		return resultado;
	}
	
	public boolean existeGenerador(String loc, int cod) {
		boolean existe = false;
		Iterator<Generador> itr = generadores.iterator();
		while(itr.hasNext() && !existe) {
			Generador g = itr.next();
			if(g.getLocalidad().equals(loc) && g.getCODIGO()==cod) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", generadores=" + generadores.size() + "]";
	}
	
}
