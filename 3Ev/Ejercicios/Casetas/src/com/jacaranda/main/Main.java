package com.jacaranda.main;

import java.util.ArrayList;
import java.util.Collections;
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

	public static Scanner teclado = new Scanner(System.in);

	private static final String MENU = "1. Mostrar todas las casetas existentes en una calle.\n"
			+ "2. Mostrar todas las casetas de tipo familiar. \n" + "3. Mostrar todas las casetas de tipo Distrito. \n"
			+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos. \n"
			+ "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen. \n"
			+ "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito que existen. \n"
			+ "7. Eliminar una caseta.\n" + "8. Salir. ";

	private static ArrayList<Caseta> casetas = new ArrayList<>();
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static void main(String[] args) {

		leerFichero();
		Collections.sort(casetas);

		// menú
		boolean salir = false;
		do {
			System.out.println(MENU);
			int opcion = Integer.parseInt(teclado.nextLine());
			switch (opcion) {
			case (1): {
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
			case (2): {
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
			case (3): {
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
			case (4): {
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
			case (5): {// mostrar número de casetas de tipo familiar en cada calle
				Iterator<Caseta> itr = casetas.iterator();
				StringBuilder salida = new StringBuilder();
				int contador = 0;
				String calleAnterior = "";
				while (itr.hasNext()) {
					Caseta c = itr.next();
					String calle = c.getCalle();
					if (!calle.equals(calleAnterior)) {
						if (!calleAnterior.isEmpty()) {
							salida.append("La calle " + calleAnterior + " tiene " + contador
									+ " casetas de tipo familiar." + System.lineSeparator());
						}
						contador = 0;
						calleAnterior = calle;

					}
					if (c.getClase().equals("FAMILIAR")) {
						contador++;
					}

				}
				System.out.println(salida.toString());
				break;
			}
			case (6): {
				Iterator<Caseta> itr = casetas.iterator();
				StringBuilder salida = new StringBuilder();
				int contador = 0;
				String calleAnterior = "";
				while (itr.hasNext()) {
					Caseta c = itr.next();
					String calle = c.getCalle();
					if (!calle.equals(calleAnterior)) {
						if (!calleAnterior.isEmpty()) {
							salida.append("La calle " + calleAnterior + " tiene " + contador
									+ " casetas de tipo distrito." + System.lineSeparator());
						}
						contador = 0;
						calleAnterior = calle;

					}
					if (c.getClase().equals("DISTRITO")) {
						contador++;
					}

				}
				System.out.println(salida.toString());
				break;
			}
			case (7): {// borrar caseta y cambiar las posteriores, descenderan de numero segun los
						// modulos de la eliminada
				String calle = pedirCadena("la calle de la caseta a eliminar");
				int num = Integer.parseInt(pedirCadena("el número de la caseta a eliminar"));
				boolean calleModificada = false;
				Iterator<Caseta> itr = casetas.iterator();
				while (itr.hasNext() && !calleModificada) {
					Caseta c = itr.next();
					if (c.getCalle().equalsIgnoreCase(calle)) {
						int numMenos = 0;
						if (c.getNumero() == num) {
							numMenos = c.getModulos();
							casetas.remove(c);
						} else if (c.getNumero() > num) {
							c.setNumero(c.getNumero() - numMenos);
						} else if (!c.getCalle().equals(itr.next().getCalle())) {
							calleModificada = true;
						}
					}
				}
				break;
			}
			case (8): {
				System.out.println("Se guardarán los datos en el fichero json");
				CompararNumeros comp = new CompararNumeros();
				Collections.sort(casetas, comp);
				try {
					escribirJson();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				salir = true;
				break;
			}
			}
		} while (!salir);
	}

	private static String pedirCadena(String cadena) {
		System.out.println("Introduce " + cadena + ": ");
		String result = teclado.nextLine();
		return result;
	}

	public static void leerFichero() {
		// leer fichero
		// File file = new File("ficheros\\casetasferia.xml");
		File file = new File("ficheros//casetasferia.xml");
		// Estructura: nodo raiz: newDataSet, xlsquema, nodos DatosLeidos(titulo, calle,
		// numero, modulos, clase, entidad, id, idCalle
		try {
			// parsear y normalizar
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList listaCasetas = doc.getElementsByTagName("DatosLeidos");// conseguir nodos DatosLeidos(las casetas)
			for (int i = 0; i < listaCasetas.getLength(); i++) {// recorrer los nodos
				Node nodo = listaCasetas.item(i);// 1 grupo de DatosLeidos
				// si el nodo es de tipo elemento lo obtenemos
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;
					NodeList listaTags = elemento.getChildNodes();// lista de atributos de ese nodo
					String titulo = "";
					String calle = "";
					int numero = 0;
					int modulos = 0;
					String clase = "";
					String entidad = "";
					int id = 0;
					int idCalle = 0;
					for (int j = 0; j < listaTags.getLength(); j = j + 1) {// recorrer esa lista
						Node atributo = listaTags.item(j);// obtengo el atributo
						// si el nodo es de tipo elemento lo obtenemos
						if (atributo.getNodeType() == Node.ELEMENT_NODE) {
							Element elementoAtributo = (Element) atributo;
							// comprobar y guardar cada atributo
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void escribirJson() throws IOException {
		// crear fichero json
		//ficheros\\casetasjson.json
		FileWriter jsonFile = new FileWriter("ficheros//casetasjson.json");

		try {
			gson.toJson(casetas, jsonFile);
		} catch (JsonIOException e) {
			System.out.println(e.getMessage());
		}
	}
}
