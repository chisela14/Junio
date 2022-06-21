package com.jacaranda.plataforma;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Contenido implements Comparable<Contenido>, visualizacionPoranno{

	private String nombre;
	private Temas tema;
	private int annoEstreno;
	private int visualizaciones;
	protected static int menosAnno = 2200;
	
	public Contenido(String nombre, Temas tema, int annoEstreno, int visualizaciones) {
		super();
		this.nombre = nombre;
		this.tema = tema;
		this.annoEstreno = annoEstreno;
		this.visualizaciones = visualizaciones;
		if(annoEstreno<menosAnno) {
			menosAnno = annoEstreno;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAnnoEstreno() {
		return annoEstreno;
	}
	public void setAnnoEstreno(int annoEstreno) {
		this.annoEstreno = annoEstreno;
	}
	public int getVisualizaciones() {
		return visualizaciones;
	}
	public void setVisualizaciones(int visualizaciones) {
		this.visualizaciones = visualizaciones;
	}
	public Temas getTema() {
		return tema;
	}
	public void setTema(Temas tema) {
		this.tema = tema;
	}

	public static int getMenosAnno() {
		return menosAnno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contenido other = (Contenido) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Contenido o) {
		int salida = 0;
		if(this.annoEstreno>o.getAnnoEstreno()) {
			salida = 1;
		}else if(this.annoEstreno<o.getAnnoEstreno()) {
			salida = -1;
		}else {
			salida = this.nombre.compareTo(o.getNombre());
		}
		return salida;
	}

	@Override
	public double getMediaVisualizacion() {
		int actual = LocalDate.now().getYear();
		int anyos = actual - this.annoEstreno;
		double resultado = this.visualizaciones/anyos;
		if(actual==this.annoEstreno) {
			resultado = this.visualizaciones;
		}
		return resultado;
	}
	

}
