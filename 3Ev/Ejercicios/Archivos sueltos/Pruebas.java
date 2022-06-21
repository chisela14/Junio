package com.jacaranda.principal;

import java.util.ArrayList;

import com.jacaranda.datos.Datos;

public class Pruebas {

	 String Url;
	 String Titulo;
	 ArrayList<Datos> Datos;

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		this.Url = url;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public ArrayList<Datos> getDatos() {
		return Datos;
	}

	public void setDatos(ArrayList<Datos> datos) {
		this.Datos = datos;
	}
	 

}
