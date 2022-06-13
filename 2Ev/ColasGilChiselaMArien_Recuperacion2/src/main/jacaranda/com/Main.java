package main.jacaranda.com;

import java.util.Arrays;
import java.util.Scanner;

import centros.jacaranda.com.*;
import profesorado.jacaranda.com.Profesor;
import profesorado.jacaranda.com.ProfesorPrimaria;

public class Main {
	
	public static Scanner teclado = new Scanner(System.in);
	
	private final static int MAX_PROFESORES = 100;
	private static Profesor[] profesores = new Profesor[MAX_PROFESORES];
	private static int numProfesores = 0;
	private final static int MAX_CENTROS = 20;
	private static Centro[] centros = new Centro[MAX_CENTROS];
	private static int numCentros = 0;
	
	private static String menuPrincipal = "1. Dar de alta un centro\n2. Listado ordenado de centros\n"
									+ "3. Dar de alta un profesor de primaria\n4. Salir";
	
	public static void main(String[] args) throws CentroException, MainException {
		
		boolean salir = false;
		do {
			mostrarMenu();
			int opcion = seleccionarOpcion();
			switch(opcion) {
				case(1):{
					try {
						addCentro();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println(centros[numCentros-1].toString());
					break;
				}
				case(2):{
					Arrays.sort(centros);
					System.out.println(listarCentros());
					break;
				}
				case(3):{
					addProfesorP();
					System.out.println(listarProfesores());
					break;
				}
				case(4):{
					salir = true;
					break;
				}
			}
		}while (salir==false);
		
	}
	
	public static void mostrarMenu() {
		System.out.println(menuPrincipal);
	}
	
	public static int seleccionarOpcion() {
		int opcion = Integer.parseInt(teclado.nextLine());
		return opcion;
	}
	
	public static void addCentro() throws CentroException, MainException {
		Centro c;
		if(numCentros == MAX_CENTROS) {
			throw new MainException("Número máximo de centros alcanzado, no se pueden añadir más.");
		}else {
			System.out.println("Introduce el código: ");
			String codigo = teclado.nextLine();
			System.out.println("Introduce el nombre: ");
			String nombre = teclado.nextLine();
			System.out.println("Introduce la dirección: ");
			String direccion = teclado.nextLine();
			if(codigo.isBlank() ||codigo.isEmpty()) {
				c = new Centro(nombre,direccion);
			}else {
				//comprobar que no existe (si existe saltará exception)
				if(centroExiste(codigo)==true){
					throw new MainException("El centro ya está registrado");
				}else {
					c = new Centro(codigo,nombre,direccion);
				}
			}
			centros[numCentros] = c;
			numCentros++;
		}
	}
	
	private static boolean centroExiste(String codigo) {
		boolean salida = false;
		for(int i=0;i<numCentros;i++) {
			if(centros[i].getCodigo().equals(codigo)) {
				salida = true;
			}
		}
		return salida;
	}
	
	public static String listarCentros() {
		StringBuilder salida = new StringBuilder();
		for(int i=0; i<numCentros;i++) {
			salida.append(i+1 +".- "+centros[i].toString());
		}
		return salida.toString();
	}
		
	public static void addProfesorP() throws MainException {
		System.out.println("Introduce el nombre: ");
		String nombre = teclado.nextLine();
		System.out.println("Introduce la especialidad: ");
		String especialidad = teclado.nextLine();
		System.out.println("Introduce el código del centro: ");
		String codigo = teclado.nextLine();
		if(centroExiste(codigo)==true) {
			Centro centro = getCentro(codigo);
			ProfesorPrimaria p = new ProfesorPrimaria(nombre,centro,especialidad);
			profesores[numProfesores] = p;
			numProfesores ++;
		}else {
			throw new MainException("El centro no existe, por favor regístrelo antes de añadir al profesor");
		}
	}
	
	public static Centro getCentro(String codigo) throws MainException {
		for(int i=0; i<numCentros;i++) {
			if(centros[i].getCodigo().equals(codigo)) {
				return centros[i];
			}
		}
		//no deberia saltar nunca si se usa despues de comprobar que un centro existe
		throw new MainException("No se ha podido recuperar el centro con el codigo proporcionado");
	}
	
	public static String listarProfesores() {
		StringBuilder salida = new StringBuilder();
		for(int i=0; i<numProfesores;i++) {
			salida.append(i+1 +".- "+profesores[i].toString());
		}
		return salida.toString();
	}
}
