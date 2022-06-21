package com.jacaranda.principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jacaranda.datos.ClaseMetrica;
import com.jacaranda.datos.CompararValorAlto;
import com.jacaranda.datos.CompararValorBajo;
import com.jacaranda.datos.Datos;
import com.jacaranda.datos.LecturaJson;

public class Main {
	
	public static Scanner teclado = new Scanner(System.in);
	private static Gson gson = new Gson();
	
	private static final String MENU = "1. Mostrar el mejor día.\n2. Mostrar el mejor día a partir de un fecha."
			+ "3. Mostrar el peor día\n4. Mostrar el peor día a partir de una fecha.\n"
			+ "5. Mostrar el número de contagios, curados y muertos de un día."
			+ "6. Mostrar la media de contagios, curados y muertos.\n 7. Salir";
	
	public static void main(String[] args) {
		
		//Guardar información
		String fichero = "ficheros//casos_acumulados.json"; // cambiar direccion barras windows-linux
		String fileContagios = leerFichero(fichero);
		fichero = "ficheros//evolucion_casos_curados.json";
		String fileCurados = leerFichero(fichero);
		fichero = "ficheros//muertos_por_coronavirus.json";
		String fileMuertes = leerFichero(fichero);
		//conseguir array de datos
		ArrayList<Datos> contagios = conseguirDatos(fileContagios);
		ArrayList<Datos> curados = conseguirDatos(fileCurados);
		ArrayList<Datos> muertes = conseguirDatos(fileMuertes);
		
		//menu
		boolean salir = false;
		do {
			System.out.println(MENU);
			int opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion) {
				case(1):{
					System.out.println("Día con menos contagios: "+ diaValorBajo(contagios) + System.lineSeparator());
					System.out.println("Día con menos mueres: "+ diaValorBajo(muertes) + System.lineSeparator());
					System.out.println("Día con más altas: "+ diaValorAlto(curados) + System.lineSeparator());
					break;
				}
				case(2):{
					System.out.println("Introduce una fecha(yyyy-mm-dd): ");
					LocalDate fecha = LocalDate.parse(teclado.nextLine());
					System.out.println("Día con menos contagios: "+ diaValorBajo(contagios, fecha) + System.lineSeparator());
					System.out.println("Día con menos mueres: "+ diaValorBajo(muertes, fecha) + System.lineSeparator());
					System.out.println("Día con más altas: "+ diaValorAlto(curados, fecha) + System.lineSeparator());
					break;
				}
				case(3):{
					System.out.println("Día con más contagios: "+ diaValorAlto(contagios) + System.lineSeparator());
					System.out.println("Día con más mueres: "+ diaValorAlto(muertes) + System.lineSeparator());
					System.out.println("Día con menos altas: "+ diaValorBajo(curados) + System.lineSeparator());
					break;
				}
				case(4):{
					System.out.println("Introduce una fecha(yyyy-mm-dd): ");
					LocalDate fecha = LocalDate.parse(teclado.nextLine());
					System.out.println("Día con más contagios: "+ diaValorAlto(contagios, fecha) + System.lineSeparator());
					System.out.println("Día con más mueres: "+ diaValorAlto(muertes, fecha) + System.lineSeparator());
					System.out.println("Día con menos altas: "+ diaValorBajo(curados, fecha) + System.lineSeparator());
					break;
				}
				case(5):{
					System.out.println("Introduce una fecha(yyyy-mm-dd): ");
					LocalDate fecha = LocalDate.parse(teclado.nextLine());
					System.out.println("Contagios de ese día: " + getValoresDia(contagios, fecha)+ System.lineSeparator());
					System.out.println("Muertes de ese día: " + getValoresDia(muertes, fecha)+ System.lineSeparator());
					System.out.println("Altas de ese día: " + getValoresDia(curados, fecha)+ System.lineSeparator());
					break;
				}
				case(6):{//falta hacer método
					System.out.println("Media de contagios: " + media(contagios) + System.lineSeparator());
					System.out.println("Media de muertes: " + media(muertes) + System.lineSeparator());
					System.out.println("Media de altas: " + media(curados) + System.lineSeparator());
					break;
				}
				case(7):{
					salir = true;
					break;
				}
			}
		}while(!salir);
		
	}
	
	public static String leerFichero(String f) {
		StringBuilder fichero = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
		    String linea;
		    while ((linea = br.readLine()) != null) {
		        fichero.append(linea);
		    }
		} catch (FileNotFoundException e) {
		    System.out.println(e.getMessage());
		} catch (IOException e2) {
		    System.out.println(e2.getMessage());
		}
		return fichero.toString();
	}
	
	public static ArrayList<Datos> conseguirDatos(String file) {
		ArrayList<Datos> datos = new ArrayList<>();
		LecturaJson l = gson.fromJson(file, LecturaJson.class);
		for (ClaseMetrica aux : l.getDatos().getMetrica()) {
			for (Datos d : aux.getDatos()) {
				datos.add(d);	
			}	
		}
		return datos;
	}
	
	public static String diaValorAlto(ArrayList<Datos> array) {
		CompararValorAlto comp = new CompararValorAlto();
		Collections.sort(array, comp);
		return array.get(0).getPeriodo().toString();
	}
	public static String diaValorAlto(ArrayList<Datos> array, LocalDate fecha) {
		Collections.sort(array);
		Iterator<Datos> itr = array.iterator();
		boolean fechaEncontrada = false;
		int pos = 0;
		while(itr.hasNext() && !fechaEncontrada) {
			Datos d = itr.next();
			if(d.getPeriodo().isAfter(fecha)) {
				pos = array.indexOf(d);
				fechaEncontrada = true;
			}
		}
		ArrayList<Datos> array2 = (ArrayList<Datos>) array.subList(pos, array.size());
		CompararValorAlto comp = new CompararValorAlto();
		Collections.sort(array2, comp);
		return array2.get(0).getPeriodo().toString();
	}
	public static String diaValorBajo(ArrayList<Datos> array) {
		CompararValorBajo comp = new CompararValorBajo();
		Collections.sort(array, comp);
		return array.get(0).getPeriodo().toString();
	}
	public static String diaValorBajo(ArrayList<Datos> array, LocalDate fecha) {
		Collections.sort(array);
		Iterator<Datos> itr = array.iterator();
		boolean fechaEncontrada = false;
		int pos = 0;
		while(itr.hasNext() && !fechaEncontrada) {
			Datos d = itr.next();
			if(d.getPeriodo().isAfter(fecha)) {
				pos = array.indexOf(d);
				fechaEncontrada = true;
			}
		}
		ArrayList<Datos> array2 = (ArrayList<Datos>) array.subList(pos, array.size());
		CompararValorBajo comp = new CompararValorBajo();
		Collections.sort(array2, comp);
		return array2.get(0).getPeriodo().toString();
	}
	public static String getValoresDia(ArrayList<Datos> array, LocalDate fecha) {
		Collections.sort(array);
		Iterator<Datos> itr = array.iterator();
		boolean fechaEncontrada = false;
		String salida = null;
		while(itr.hasNext() && !fechaEncontrada) {
			Datos d = itr.next();
			if(d.getPeriodo().isEqual(fecha)) {
				salida = String.valueOf(d.getValor());
				fechaEncontrada = true;
			}
		}
		
		return salida.toString();
	}
	//hacer
	public static String media(ArrayList<Datos> array) {
	
	}

}
