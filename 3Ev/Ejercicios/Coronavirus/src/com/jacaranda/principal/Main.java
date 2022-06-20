package com.jacaranda.principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jacaranda.datos.Datos;

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
		
		ArrayList<Datos> contagios = gson.fromJson(fileContagios,new TypeToken<ArrayList<Datos>>(){}.getType());
		ArrayList<Datos> curados = gson.fromJson(fileCurados,new TypeToken<ArrayList<Datos>>(){}.getType());
		ArrayList<Datos> muertes = gson.fromJson(fileMuertes,new TypeToken<ArrayList<Datos>>(){}.getType());
		
		//menu
		boolean salir = false;
		do {
			System.out.println(MENU);
			int opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion) {
				case(1):{//recorrer los 3 arrays
					StringBuilder salida = new StringBuilder();
					String dia = null;
					for(Datos d: contagios) {
						
					}
					salida.append("Día con menos contagios: " + dia + System.lineSeparator());
					for(Datos d: muertes) {
						
					}
					salida.append("Día con menos muertes: " + dia + System.lineSeparator());
					for(Datos d: curados) {
						
					}
					salida.append("Día con más altas: " + dia + System.lineSeparator());
					break;
				}
				case(2):{
					break;
				}
				case(3):{
					break;
				}
				case(4):{
					break;
				}
				case(5):{
					break;
				}
				case(6):{
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

}
