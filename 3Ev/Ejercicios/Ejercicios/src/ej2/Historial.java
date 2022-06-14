package ej2;

import java.util.ArrayList;

public class Historial {
	
	private ArrayList<PaginaWeb> listaPaginas;

	public Historial() {
		this.listaPaginas = new ArrayList<>();
	}
	
	public void addPagina(String url) {
		PaginaWeb p = new PaginaWeb(url);
		listaPaginas.add(p);
	}
	
	public String mostrarHistorial() {
		StringBuilder salida = new StringBuilder();
		for(PaginaWeb p: listaPaginas) {
			salida.append(p.toString());
		}
		return salida.toString();
	}
	
	public String mostrarHistorialDia(dia) {
		//mapa?
		//conseguir un sublist de la lista segun el dia
		int inicio = listaPaginas.indexOf(dia);
		int ultimo = listaPaginas.lastIndexOf(dia);
		ArrayList<PaginaWeb> paginasDia = listaPaginas.subList(inicio, ultimo);
		//mostrar paginas
		StringBuilder salida = new StringBuilder();
		for(PaginaWeb p: paginasDia) {
			salida.append(p.toString());
		}
		return salida.toString();
	}
	
	public void borrarHistorial() {
		listaPaginas.clear();
	}
}
