package com.jacaranda.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.jacaranda.partituras.ConAutor;
import com.jacaranda.partituras.Nota;
import com.jacaranda.partituras.NotaException;
import com.jacaranda.partituras.PartituraException;
import com.jacaranda.partituras.Pentagrama;
import com.jacaranda.partituras.PentagramaException;

public class Pruebas {
	
	public static Connection c; //BBDD TABLA: NOTA

	public static void main(String[] args) throws NotaException, PentagramaException, PartituraException, SQLException {
		
		try {
			c = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain", "PARTITURAS", "PARTITURAS");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
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
		
		Statement st = c.createStatement();
		Nota mi = new Nota("mi", "negra", false);
		String insert = "INSERT INTO NOTA VALUES('mi', 'NEGRA', 0)";
		st.executeQuery(insert);
		nuvole.modificarPentagrama(2,1, mi);
		System.out.println(nuvole.mostrarMusica());
		
		
		String consulta = "SELECT* FROM NOTA";
		st.executeQuery(consulta);

	}

}
