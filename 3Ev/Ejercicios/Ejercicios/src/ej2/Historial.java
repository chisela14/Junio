package ej2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	public String mostrarHistorialDia(LocalDate dia) {
		ArrayList<PaginaWeb> paginasDia = new ArrayList<>();
		Iterator<PaginaWeb> itr = listaPaginas.iterator();
		while(itr.hasNext()&& itr.next().getFechaHora().toLocalDate().isEqual(dia)) {
			paginasDia.add(itr.next());
		}
		//mostrar paginas
		StringBuilder salida = new StringBuilder();
		for(PaginaWeb p: paginasDia) {
			salida.append(p.toString()+System.lineSeparator());
		}
		return salida.toString();
	}
	
	public void borrarHistorial() {
		listaPaginas.clear();
	}
}
