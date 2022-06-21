package com.jacaranda.plataforma;

public class Pelicula extends Contenido {
	
	private int duracion;

	public Pelicula(String nombre, Temas tema, int annoEstreno, int visualizaciones, int duracion) {
		super(nombre, tema, annoEstreno, visualizaciones);
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		return "Película '" + getNombre()+ "': Duración(min): " + duracion + ", Tema: " + getTema()
				+ ", Año estreno: " + getAnnoEstreno() + ", Número de visualizaciones: " + getVisualizaciones();
	}
}
