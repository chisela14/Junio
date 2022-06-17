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
		StringBuilder salida = new StringBuilder();
		Iterator<PaginaWeb> itr = listaPaginas.iterator();
		Boolean salir = false;
		
		while(itr.hasNext() && !salir ) {
			PaginaWeb elemento = itr.next();
			if (elemento.getFechaHora().toLocalDate().isEqual(dia)) {
				salida.append(elemento.toString());	
			}else if (elemento.getFechaHora().toLocalDate().isAfter(dia)) {
				salir = true;
			}
		}
		
		return salida.toString();
	}
	
	public void borrarHistorial() {
		listaPaginas.clear();
	}
}
