package com.jacaranda.principal;

import com.jacaranda.partituras.ConAutor;
import com.jacaranda.partituras.Nota;
import com.jacaranda.partituras.NotaException;
import com.jacaranda.partituras.PartituraException;
import com.jacaranda.partituras.Pentagrama;
import com.jacaranda.partituras.PentagramaException;

public class Main {

	public static void main(String[] args) throws PartituraException, NotaException, PentagramaException, CloneNotSupportedException {
		ConAutor nuvole = new ConAutor("Nuvole Bianche", "Ludovico Einaudi");
//		nuvole.addPentagrama(5); exception
		nuvole.addPentagrama(4);
		Pentagrama p1 = nuvole.getPentagrama(1);
//		p1.addNota("gi", "blanca", false); exception
//		p1.addNota("do", "gris", false); exception
		p1.addNota("do", "blanca", false);
		p1.addNota("re", "blanca", false);
//		p1.addNota("do", "blanca", false); exception
		nuvole.addPentagrama(4);
		Pentagrama p2 = nuvole.getPentagrama(2);
		p2.addNota("do", "blanca", true);
		p2.addNota("si", "blanca", true);
		System.out.println(nuvole.mostrarMusica());
		nuvole.modificarPentagrama(1, p2);
		System.out.println(nuvole.mostrarMusica());
		Nota mi = new Nota("mi", "negra", false);
		nuvole.modificarPentagrama(2,1, mi);
		System.out.println(nuvole.mostrarMusica());
		
		//BBDD TABLA: NOTA
		                                                                                                       
	}

}
