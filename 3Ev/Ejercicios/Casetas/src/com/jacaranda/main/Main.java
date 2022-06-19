package com.jacaranda.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.jacaranda.casetas.Caseta;
import com.jacaranda.casetas.CompararNumeros;

public class Main {
	//la opcion 7 es la unica que no funciona, deberia borrar y modificar la caseta del xml tambien?, el json no se crea entero
	
	public static Scanner teclado = new Scanner(System.in);
	
	private static final String MENU = "1. Mostrar todas las casetas existentes en una calle.\n"
				+ "2. Mostrar todas las casetas de tipo familiar. \n"
				+ "3. Mostrar todas las casetas de tipo Distrito. \n"
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos. \n"
				+ "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen. \n"
				+ "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito que existen. \n"
				+ "7. Eliminar una caseta.\n" 
				+ "8. Salir. ";
	
	private static ArrayList<Caseta> casetas = new ArrayList<>();
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static void main(String[] args) {
		
		leerFichero();
		
		//menú
		boolean salir = false;
		do {
			System.out.println(MENU);
			int opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion) {
				case(1):{
					String calle = pedirCadena("la calle");
					Iterator<Caseta> itr = casetas.iterator();
					StringBuilder salida = new StringBuilder();
					while (itr.hasNext()) {
						Caseta c = itr.next();
						if (c.getCalle().equals(calle)) {
							salida.append(c.toString() + System.lineSeparator());
						}
					}
					System.out.println(salida.toString());
					break;
				}
				case(2):{
					Iterator<Caseta> itr = casetas.iterator();
					StringBuilder salida = new StringBuilder();
					while (itr.hasNext()) {
						Caseta c = itr.next();
						if (c.getClase().equals("FAMILIAR")) {
							salida.append(c.toString() + System.lineSeparator());
						}
					}
					System.out.println(salida.toString());
					break;
				}
				case(3):{
					Iterator<Caseta> itr = casetas.iterator();
					StringBuilder salida = new StringBuilder();
					while (itr.hasNext()) {
						Caseta c = itr.next();
						if (c.getClase().equals("DISTRITO")) {
							salida.append(c.toString() + System.lineSeparator());
						}
					}
					System.out.println(salida.toString());
					break;
				}
				case(4):{
					Iterator<Caseta> itr = casetas.iterator();
					StringBuilder salida = new StringBuilder();
					while (itr.hasNext()) {
						Caseta c = itr.next();
						if (!c.getClase().equals("DISTRITO") && !c.getClase().equals("FAMILIAR")) {
							salida.append(c.toString() + System.lineSeparator());
						}
					}
					System.out.println(salida.toString());
					break;
				}
				case(5):{//mostrar número de casetas de tipo familiar en cada calle
					HashSet<String> calles = conseguirCalles();
					StringBuilder salida = new StringBuilder();
					for(String s: calles) {
						salida.append("La calle " + s + " tiene ");
						int contador = 0;
						Iterator<Caseta> itr = casetas.iterator();
						while (itr.hasNext()) {
							Caseta c = itr.next();
							if (c.getCalle().equals(s) && c.getClase().equals("FAMILIAR")) {
								contador++;
							}
						}
						salida.append(contador + " casetas." + System.lineSeparator());
						System.out.println(salida.toString());
					}
					break;
				}
				case(6):{
					HashSet<String> calles = conseguirCalles();
					StringBuilder salida = new StringBuilder();
					for(String s: calles) {
						salida.append("La calle " + s + " tiene ");
						int contador = 0;
						Iterator<Caseta> itr = casetas.iterator();
						while (itr.hasNext()) {
							Caseta c = itr.next();
							if (c.getCalle().equals(s) && c.getClase().equals("DISTRITO")) {
								contador++;
							}
						}
						salida.append(contador + " casetas." + System.lineSeparator());
						System.out.println(salida.toString());
					}
					break;
				}
				case(7):{//borrar caseta y cambiar las posteriores, descenderan de numero segun los modulos de la eliminada
					String calle = pedirCadena("la calle de la caseta a eliminar");
					int num = Integer.parseInt(pedirCadena("el número de la caseta a eliminar"));
					HashSet<String> calles = conseguirCalles();
					Iterator<String> callesItr = calles.iterator();
					boolean calleEncontrada = false;
					while(callesItr.hasNext() && !calleEncontrada) {
						String s = callesItr.next();
						if(s.equalsIgnoreCase(calle)){
							Iterator<Caseta> itr = casetas.iterator();
							while (itr.hasNext()) {
								Caseta c = itr.next();
								if (c.getCalle().equals(s)) {
									int numMenos = 0;
									if(c.getNumero() == num) {
										numMenos = c.getModulos();
										casetas.remove(c);
									}else if(c.getNumero() > num) {
										c.setNumero(c.getNumero()- numMenos);
									}
								}
							}
							calleEncontrada = true;
						}
					}
					break;
				}
				case(8):{
					System.out.println("Se guardaran los cambios en el fichero json si los hubiera");
					CompararNumeros comp = new CompararNumeros();
					Collections.sort(casetas, comp);
					escribirJson();
					salir = true;
					break;
				}
			}
		}while(!salir);
	}
	private static String pedirCadena(String cadena) {
		System.out.println("Introduce " + cadena + ": ");
		String result = teclado.nextLine();
		return result;
	}
	private static HashSet<String> conseguirCalles(){
		Iterator<Caseta> itr = casetas.iterator();
		HashSet<String> calles = new HashSet<>();
		while (itr.hasNext()) {
			Caseta c = itr.next();
			if (!calles.contains(c.getCalle())) {
				calles.add(c.getCalle());
			}
		}
		return calles;
	}
	
	public static void leerFichero() {
		//leer fichero
		//linux File file = new File("/ficheros/casetasferia.xml");
		File file = new File("ficheros\\casetasferia.xml");
		//Estructura: nodo raiz: newDataSet, xlsquema, nodos DatosLeidos(titulo, calle, numero, modulos, clase, 
		//entidad, id, idCalle
		try {
			//parsear y normalizar
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
		
			NodeList listaCasetas = doc.getElementsByTagName("DatosLeidos");//conseguir nodos DatosLeidos(las casetas)
			for (int i = 0; i < listaCasetas.getLength(); i++) {//recorrer los nodos
				Node nodo = listaCasetas.item(i);//1 grupo de DatosLeidos
				//si el nodo es de tipo elemento lo obtenemos
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;
					NodeList listaTags = elemento.getChildNodes();//lista de atributos de ese nodo
					String titulo = "";
					String calle = "";
					int numero = 0;
					int modulos = 0;
					String clase = "";
					String entidad = "";
					int id = 0;
					int idCalle = 0;
					for (int j = 0; j < listaTags.getLength(); j = j + 1) {//recorrer esa lista
						Node atributo = listaTags.item(j);// obtengo el atributo
						//si el nodo es de tipo elemento lo obtenemos
						if (atributo.getNodeType() == Node.ELEMENT_NODE) {
							Element elementoAtributo = (Element) atributo;
							//comprobar y guardar cada atributo
							if (elementoAtributo.getTagName().equals("TITULO")) {
								titulo = elementoAtributo.getTextContent();
							} else if (elementoAtributo.getTagName().equals("CALLE")) {
								calle = elementoAtributo.getTextContent();
							} else if (elementoAtributo.getTagName().equals("NUMERO")) {
								numero = Integer.parseInt(elementoAtributo.getTextContent());
							} else if (elementoAtributo.getTagName().equals("MODULOS")) {
								modulos = Integer.parseInt(elementoAtributo.getTextContent());
							} else if (elementoAtributo.getTagName().equals("CLASE")) {
								clase = elementoAtributo.getTextContent();
							} else if (elementoAtributo.getTagName().equals("ENTIDAD")) {
								entidad = elementoAtributo.getTextContent();
							} else if (elementoAtributo.getTagName().equals("ID")) {
								id = Integer.parseInt(elementoAtributo.getTextContent());
							} else if (elementoAtributo.getTagName().equals("ID_CALLE")) {
								idCalle = Integer.parseInt(elementoAtributo.getTextContent());
							}
						}
					}
					Caseta c = new Caseta(titulo, calle, numero, modulos, clase, entidad, id, idCalle);
					casetas.add(c);
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void escribirJson() {
		//crear fichero json
		File jsonFile = new File("ficheros\\casetasjson.json");
		try{
			if(jsonFile.createNewFile()) {
				System.out.println("Se ha creado el fichero json correspondiente");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			gson.toJson(casetas, new FileWriter(jsonFile));
		} catch (JsonIOException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
