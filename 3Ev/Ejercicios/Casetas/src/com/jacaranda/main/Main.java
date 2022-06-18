package com.jacaranda.main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

import com.google.gson.Gson;
import com.jacaranda.casetas.Caseta;

public class Main {
	
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
	
	public static void main(String[] args) {
		
		leerFichero();
		
		//crear json
		Gson gson = new Gson();
		
		
		//menú
		boolean salir = false;
		do {
			System.out.println(MENU);
			int opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion) {
				case(1):{
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
					break;
				}
				case(8):{
					salir = true;
					break;
				}
			}
			
		}while(!salir);
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

}
