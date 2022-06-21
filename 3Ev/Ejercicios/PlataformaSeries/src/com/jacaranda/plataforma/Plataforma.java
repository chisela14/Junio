package com.jacaranda.plataforma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Plataforma {
	private String nombre;
	private ArrayList<Serie> series; //no se van a eliminar, solo añadir y cambiar atributos de los objetos
	private ArrayList<Pelicula> peliculas;
	private ArrayList<Contenido> contenido;//array de los dos anteriores para los tres ultimos metodos
	
	public Plataforma(String nombre) {
		this.nombre = nombre;
		this.series =  new ArrayList<>();
		this.peliculas = new ArrayList<>();
		this.contenido = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void addPeliSerie(int opc, String nombre, String tema, int annoEstreno, int visualizaciones, int aux) throws PlataformaException {
		Temas t;
		try {
			t = Temas.valueOf(tema.toUpperCase());
		}catch(Exception e) {
			throw new PlataformaException("El tema debe ser uno de los siguientes: "+ Arrays.toString(Temas.values()));
		}
		if(opc==1) {
			Pelicula p = new Pelicula(nombre,t, annoEstreno, visualizaciones, aux);
			if(!peliculas.contains(p)) {
				peliculas.add(p);
			}else {
				throw new PlataformaException("La película ya está registrada");
			}
		}else if(opc==2) {
			Serie s = new Serie(nombre,t, annoEstreno, visualizaciones, aux);
			if(!series.contains(s)) {
				series.add(s);
			}else {
				throw new PlataformaException("La serie ya está registrada");
			}
		}else {
			throw new PlataformaException("Opción incorrecta");
		}
	}
	
	public boolean setDuracion(String nombre, int duracion) {
		Iterator<Pelicula> itr = peliculas.iterator();
		boolean encontrada = false;
		while(itr.hasNext()&&!encontrada) {
			Pelicula p = itr.next();
			if(p.getNombre().equals(nombre)) {
				p.setDuracion(duracion);
				encontrada = true;
			}
		}
		return encontrada;
	}
	
	public boolean addEpisodio(String nombreSerie, String nombreEpisodio, int pos) throws SerieException {
		Iterator<Serie> itr = series.iterator();
		boolean encontrada = false;
		while(itr.hasNext()&&!encontrada) {
			Serie s = itr.next();
			if(s.getNombre().equals(nombreSerie)) {
				s.addCapitulo(nombreEpisodio, pos);
				encontrada = true;
			}
		}
		return encontrada;
	}
	
	public void delEpisodio(String nombreSerie, String nombreEpisodio) throws SerieException {
		Iterator<Serie> itr = series.iterator();
		boolean encontrada = false;
		while(itr.hasNext()&&!encontrada) {
			Serie s = itr.next();
			if(s.getNombre().equals(nombreSerie)) {
				s.delCapitulo(nombreEpisodio);
				encontrada = true;
			}
		}
	}
	private void juntarListas() {
		contenido.clear();
		for(Serie s: series) {
		contenido.add(s);
		}
		for(Pelicula p: peliculas) {
			contenido.add(p);
		}
	}

	public String listarPelisSeries() {
		juntarListas();
		Collections.sort(contenido);
		StringBuilder salida = new StringBuilder();
		salida.append("Contenido disponible: \n");
		for(Contenido c: contenido) {
			salida.append(c.toString()+"\n");
		}
		return salida.toString();
	}
	
	public String listarPorNombre() {
		CompararNombres comp = new CompararNombres(); 
		juntarListas();
		Collections.sort(contenido,comp);
		StringBuilder salida = new StringBuilder();
		salida.append("Contenido disponible: \n");
		for(Contenido c: contenido) {
			salida.append(c.toString()+"\n");
		}
		return salida.toString();
	}
	public boolean setTema(String nombre, String tema) throws PlataformaException {
		juntarListas();
		Temas t;
		boolean encontrada = false;
		try {
			t = Temas.valueOf(tema.toUpperCase());
			Iterator<Contenido> itr = contenido.iterator();
			while(itr.hasNext()&&!encontrada) {
				Contenido c = itr.next();
				if(c.getNombre().equals(nombre)) {
					c.setTema(t);
					encontrada = true;
				}
			}
		}catch(Exception e) {
			throw new PlataformaException("El tema debe ser uno de los siguientes: "+ Arrays.toString(Temas.values()));
		}
		return encontrada;
	}

}
