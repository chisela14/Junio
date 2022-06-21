package com.jacaranda.principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.jacaranda.datos.Provincia;

//hacer build path en casa

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	
	private static ArrayList<Provincia> provincias = new ArrayList<>();
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	private static final String MENU = "1. Mostrar  la editorial más usada en cada una de las provincias.\n"
			+ "2. Mostrar la editorial más usada en una provincia.\n"//por teclado
			+ "3. Mostrar la editorial más usada en una localidad.\n"//pedir localidad y pronvcia
			+ "4. Mostrar la editorial más usada en una materia.\n"
			+ "5. Listado de todos los libros usados en todas las materias en un centro(cod).\n"
			+ "6. Listado de todos los libros usados en todas las materias en un centro(nombre).\\n"
			+ "7. Listado de todos los libros usados en una materia en una localidad.\n"
			//mostrando el nombre del centro y el libro correspondiente en cada curso que tenga dicha materia"
			+ "8. Salir";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void leerFichero() {
		// leer fichero
		// File file = new File("ficheros\\gratuidadlibrosdetextoandalucia-2122.csv");
		File file = new File("ficheros//gratuidadlibrosdetextoandalucia-2122.csv");
		try {
			// parsear y normalizar
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			
				
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void escribirJson() throws IOException {
		// crear fichero json
		//ficheros\\librostexto.json
		FileWriter jsonFile = new FileWriter("ficheros//librostexto.json");

		try {
			gson.toJson(provincias, jsonFile);
		} catch (JsonIOException e) {
			System.out.println(e.getMessage());
		}
	}

}
