package com.jacaranda.principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class PruebasMain {

	public static void main(String[] args) {
//		fichero = "ficheros\\url.json";
//		String furl = leerFichero(fichero);
//		Pruebas prueba = conseguirDatos2(furl);
		
//		public void format() {
//		this.fecha = conseguirFecha(this.Periodo);
//	}

	}
	public static String leerFichero(String f) {
		String linea;
		StringBuilder fichero = new StringBuilder();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		    linea=br.readLine();
		    while (linea != null) {
		        fichero.append(linea);
		        linea=br.readLine();
		    }
		    fr.close();
		    br.close();
		} catch (FileNotFoundException e) {
		    System.out.println(e.getMessage());
		} catch (IOException e2) {
		    System.out.println(e2.getMessage());
		}
		return fichero.toString();
	}
public static Pruebas conseguirDatos2(String file) {
//	JsonElement je = gson.fromJson(file, JsonElement.class);
//	JsonObject jo = je.getAsJsonObject();
//	System.out.println(jo.get("Respuesta"));
		Gson gson = new Gson();
		System.out.println("hola2");
		Pruebas p = gson.fromJson(file, Pruebas.class);
		System.out.println(p.Datos.get(0).getAgno());
		
		return p;
	}

}
