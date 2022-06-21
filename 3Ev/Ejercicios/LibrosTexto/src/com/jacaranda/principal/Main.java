package com.jacaranda.principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.jacaranda.datos.*;


public class Main {
	public static Scanner teclado = new Scanner(System.in);
	
	private static ArrayList<Provincia> provincias = new ArrayList<>();
	private static ArrayList<Localidad> localidades = new ArrayList<>();
	private static ArrayList<Centro> centros = new ArrayList<>();
	private static ArrayList<Curso> cursos = new ArrayList<>();
	private static ArrayList<Materia> materias = new ArrayList<>();
	private static ArrayList<Libro> libros = new ArrayList<>();

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
		leerFichero();
		try {
			escribirJson();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		boolean salir = false;
		do {
			System.out.println(MENU);
			int opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion) {
				case(1):{
					for(Provincia p: provincias) {
						HashMap<String, Integer> mapa = mapaEditoriales();
						for(Localidad l: p.getLocalidades()) {//si lo pongo en una linea me dice que no existe getCentros por alguna razon
							for(Centro c: l.getCentros()) {
								for(Curso cur: c.getCursos()) {
									for(Materia m: cur.getMaterias()) {
										Libro lib = m.getLibro();
										if (mapa.containsKey(lib.getEditorial())){
											int valor = mapa.get(lib.getEditorial()) + 1;
											mapa.put(lib.getEditorial(), valor);
										}
									}
								}
							}
						}
						Iterator<String> itr = mapa.keySet().iterator();
						int maxEditoriales = 0;
						String editorial = "";
						while(itr.hasNext()) {
							String aux = itr.next();
							if(mapa.get(aux)>maxEditoriales) {
								maxEditoriales = mapa.get(aux);
								editorial = aux;
							}
						}
						System.out.println("La editorial más usada de la provincia de " + p.getNombre() + " es " + editorial);
					}
					break;
				}
				case(2):{
					String provincia = pedirCadena("la provincia");
					for(Provincia p: provincias) {
						if(p.getNombre().equals(provincia)) {//hago esto porque creo que habra repetidas
							HashMap<String, Integer> mapa = mapaEditoriales();
							for(Localidad l: p.getLocalidades()) {
								for(Centro c: l.getCentros()) {
									for(Curso cur: c.getCursos()) {
										for(Materia m: cur.getMaterias()) {
											Libro lib = m.getLibro();
											if (mapa.containsKey(lib.getEditorial())){
												int valor = mapa.get(lib.getEditorial()) + 1;
												mapa.put(lib.getEditorial(), valor);
											}
										}
									}
								}
							}
							Iterator<String> itr = mapa.keySet().iterator();
							int maxEditoriales = 0;
							String editorial = "";
							while(itr.hasNext()) {
								String aux = itr.next();
								if(mapa.get(aux)>maxEditoriales) {
									maxEditoriales = mapa.get(aux);
									editorial = aux;
								}
							}
							System.out.println("La editorial más usada de la provincia de " + provincia + " es " + editorial);
						}	
					}
					break;
				}
				case(3):{
					String localidad = pedirCadena("la localidad");
					for(Localidad l: localidades) {
						HashMap<String, Integer> mapa = mapaEditoriales();
						if(l.getNombre().equalsIgnoreCase(localidad)) {
							for(Centro c: l.getCentros()) {
								for(Curso cur: c.getCursos()) {
									for(Materia m: cur.getMaterias()) {
										Libro lib = m.getLibro();
										if (mapa.containsKey(lib.getEditorial())){
											int valor = mapa.get(lib.getEditorial()) + 1;
											mapa.put(lib.getEditorial(), valor);
										}
									}
								}
							}
							Iterator<String> it = mapa.keySet().iterator();
							int maxEditoriales = 0;
							String editorial = "";
							while(it.hasNext()) {
								String aux = it.next();
								if(mapa.get(aux)>maxEditoriales) {
									maxEditoriales = mapa.get(aux);
									editorial = aux;
								}
							}
							System.out.println("La editorial más usada de la localidad de " + localidad + " es " + editorial);	
						}
					}
					break;
				}
				case(4):{//Mostrar la editorial más usada en una materia.
					String mat = pedirCadena("la materia");
					for(Materia m: materias) {
						HashMap<String, Integer> mapa = mapaEditoriales();
						if(m.getNombre().equals(mat)) {
							Libro lib = m.getLibro();
							if (mapa.containsKey(lib.getEditorial())){
								int valor = mapa.get(lib.getEditorial()) + 1;
								mapa.put(lib.getEditorial(), valor);
							}
						}
						Iterator<String> it = mapa.keySet().iterator();
						int maxEditoriales = 0;
						String editorial = "";
						while(it.hasNext()) {
							String aux = it.next();
							if(mapa.get(aux)>maxEditoriales) {
								maxEditoriales = mapa.get(aux);
								editorial = aux;
							}
						}
						System.out.println("La editorial más usada en la materia de " + mat + " es " + editorial);
					}
					break;
				}
				case(5):{//Listado de todos los libros usados en todas las materias en un centro(cod)
					String cod = pedirCadena("el código");
					StringBuilder listado = new StringBuilder();
					for(Centro c: centros) {
						if(c.getCodigo().equals(cod)) {
							for(Curso cur: c.getCursos()) {
								for(Materia m: cur.getMaterias()) {
									listado.append(m.getNombre() + ": ");
									listado.append(m.getLibro().toString() + "\n");
								}
							}
						}
					}
					System.out.println(listado.toString());
					break;
				}
				case(6):{//Listado de todos los libros usados en todas las materias en un centro(nombre).
					String nombre= pedirCadena("el nombre");
					StringBuilder listado = new StringBuilder();
					for(Centro c: centros) {
						if(c.getNombre().equals(nombre)) {
							for(Curso cur: c.getCursos()) {
								for(Materia m: cur.getMaterias()) {
									listado.append(m.getNombre() + ": ");
									listado.append(m.getLibro().toString() + "\n");
								}
							}
						}
					}
					System.out.println(listado.toString());
					break;
				}
				case(7):{//Listado de todos los libros usados en una materia en una localidad
					String localidad= pedirCadena("la localidad");
					StringBuilder listado = new StringBuilder();
					for(Localidad l: localidades) {
						if(l.getNombre().equals(localidad)) {
							for(Centro c: l.getCentros()) {
								for(Curso cur: c.getCursos()) {
									for(Materia m: cur.getMaterias()) {
										listado.append(m.getNombre() + ": ");
										listado.append(m.getLibro().toString() + "\n");
									}
								}
							}
						}
					}
					System.out.println(listado.toString());
					break;
				}
				case(8):{
					salir = true;
					break;
				}
			}
		}while(!salir);

	}
	private static String pedirCadena(String cadena) {
		System.out.println("Introduce "+cadena+": ");
		String result = teclado.nextLine();
		return result;
	}
	
	public static HashMap<String, Integer> mapaEditoriales(){
		HashMap<String, Integer> mapa = new HashMap<>();
		//conseguir todas las editoriales, con valor 0
		for(Libro l: libros) {
			String ed = l.getEditorial();
			if(!mapa.containsKey(ed)) {
				mapa.put(ed, 0);
			}
		}
		return mapa;
	}
	
	public static void leerFichero() {
		
		BufferedReader br = null;
	    try {
	    	br = new BufferedReader(new FileReader("ficheros\\gratuidadlibrosdetextoandalucia-2122.csv"));
	    	String linea = br.readLine();
	    	while (linea!=null) {
	    		//tomando la estructura del enunciado entiendo que se que tipo de dato tengo según el campo y solo 
	    		//tengo que coger y añadir según me interese
	            String[] campos = linea.split(",");
	            Libro l = new Libro(campos[7], campos[8], campos[9], campos[10]);
	            libros.add(l);
	            Materia m = new Materia(campos[6], l);
	            materias.add(m);
	            Curso c = new Curso(campos[5]);
	            c.addMateria(m);
	            cursos.add(c);
	            Centro ce = new Centro(campos[2], campos[3], campos[4]);
	            ce.addCurso(c);
	            centros.add(ce);
	            Localidad loc = new Localidad(campos[1]);
	            loc.addCentro(ce);
	            localidades.add(loc);
	            Provincia p = new Provincia(campos[0]);
	            if(!provincias.contains(p)) {
	            	 p.addLocalidad(loc);
	            	 provincias.add(p);
	            }
	            linea = br.readLine();
	    	}
	      }catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally {
	    	  if (br != null) {
	    		  try {
	    		    br.close();
	    		  } catch (IOException e) {
	    			  System.out.println(e.getMessage());
	    		  }
	    	  }
	      }
	}

	public static void escribirJson() throws IOException {
		
		FileWriter jsonFile = new FileWriter("ficheros\\librostexto.json");
		try {
			gson.toJson(provincias, jsonFile);
		} catch (JsonIOException e) {
			System.out.println(e.getMessage());
		}
	}

}
