package com.jacaranda.plataforma;

import java.util.LinkedList;

public class Serie extends Contenido {
	
	private int maxCapitulos;
	private LinkedList<String> capitulos;//se van a poder añadir, eliminar y modificar en medio con regularidad
	
	public Serie(String nombre, Temas tema, int annoEstreno, int visualizaciones, int maxCapitulos) {
		super(nombre, tema, annoEstreno, visualizaciones);
		this.maxCapitulos = maxCapitulos;
		this.capitulos = new LinkedList<>();
	}
	
	public void addCapitulo(String cap, int posicion) throws SerieException {
		if(capitulos.size() == maxCapitulos) {
			throw new SerieException("La serie ha llegado al máximo de capítulos");
		}else if(capitulos.contains(cap)){
			throw new SerieException("Ya se ha añadido ese capítulo a la serie");
		}else {
			if(posicion>capitulos.size()+1) {
				throw new SerieException("Debes añadir los episodios restantes antes del "+posicion);
			}else if(posicion==capitulos.size()+1) {
				capitulos.add(cap);
			}else {
				capitulos.add(posicion-1, cap);//los capitulos se mostraran empezando en 1
			}
		}
	}
	public void delCapitulo(String cap) throws SerieException {
		if(!capitulos.contains(cap)) {
			throw new SerieException("No se puede borrar porque no existe");
		}else {
			capitulos.remove(capitulos.indexOf(cap));
		}
	}
	public String mostrarCapitulos() {
		StringBuilder salida = new StringBuilder();
		int contador = 0;
		for(String s: capitulos) {
			salida.append(contador + ". "+ s + "\n");
			contador++;
		}
		return salida.toString();
	}

	public int getMaxCapitulos() {
		return maxCapitulos;
	}

	public void setMaxCapitulos(int maxCapitulos) {
		this.maxCapitulos = maxCapitulos;
	}

	public LinkedList<String> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(LinkedList<String> capitulos) {
		this.capitulos = capitulos;
	}

	@Override
	public String toString() {
		return "Serie '" + getNombre()+ "': Máximo de capítulos: " + maxCapitulos + ", Capítulos registrados: " + capitulos.size() 
				+ ", Año estreno: " + getAnnoEstreno() + ", Número de visualizaciones: " + getVisualizaciones()
				+ ", Tema: " + getTema();
	}

	

}
