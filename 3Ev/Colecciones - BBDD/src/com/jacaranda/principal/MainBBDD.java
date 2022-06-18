package com.jacaranda.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jacaranda.partituras.Nota;
import com.jacaranda.partituras.NotaException;

public class MainBBDD {
	
	public static Scanner teclado = new Scanner(System.in);
	public static Connection c;
	public static Statement query;
	
	private final static String MENU_BBDD = "1. Guardar nota\n2. Borrar nota\n3. Modificar nota\n"
			+ "4. Ver notas\n5. Salir ";

	public static void main(String[] args)  {
		
		//inicio bbdd
		try {
			c = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain", "PARTITURAS", "PARTITURAS");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			query = c.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		boolean salir = false;
		do {
			System.out.println(MENU_BBDD);
			int opcion = Integer.parseInt(teclado.nextLine());
			String nombre, tipo;
			int alta;
			boolean b = false;
			switch(opcion) {
				case(1):{
					nombre = pedirCadena("el nombre de la nota");
					tipo = pedirCadena("el tipo de nota(blanca o negra)");
					alta = pedirInt("si es una nota alta(1) o no(0)");
					if(alta==1) {
						b = true;
					}
					try {
						//creo la nota por si no se han introducido bien los datos que salte exception
						Nota n = new Nota(nombre, tipo, b);
						String insert = "INSERT INTO NOTA VALUES('"+nombre+"','"+tipo.toUpperCase()+
								"',"+alta+")";
						query.executeQuery(insert);
					} catch (NotaException e) {
						System.out.println(e.getMessage());
					}catch(SQLException e2) {
						System.out.println(e2.getMessage());
					}
					break;
				}
				case(2):{
					System.out.println("Introduce los datos de la nota a borrar: ");
					nombre = pedirCadena("el nombre de la nota");
					tipo = pedirCadena("el tipo de nota(blanca o negra)");
					alta = pedirInt("si es una nota alta(1) o no(0)");
					String delete = "DELETE FROM NOTA WHERE NOMBRE='"+nombre+"' AND TIPO='"+tipo.toUpperCase()+
							"' AND ALTA="+alta;
					try {
						query.executeQuery(delete);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(3):{//el nombre y el tipo no tiene mucho sentido modificarlos, para eso creas una nueva
					System.out.println("Se modificará automáticamente el tipo de nota cuyas datos introduzcas: ");
					nombre = pedirCadena("el nombre de la nota");
					tipo = pedirCadena("el tipo de nota(blanca o negra)");
					alta = pedirInt("si es una nota alta(1) o no(0)");
					String tipoNuevo = "";
					if(tipo.equals("blanca")) {
						tipoNuevo = "NEGRA";
					}else if(tipo.equals("negra")) {
						tipoNuevo = "BLANCA";
					}
					String update = "UPDATE NOTA SET TIPO='"+tipoNuevo+"' WHERE NOMBRE='"+nombre
							+"' AND TIPO='"+tipo.toUpperCase()+"' AND ALTA="+alta;
					try {
						query.executeQuery(update);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(4):{
					String consulta = "SELECT* FROM NOTA";
					try {
						ResultSet resultado = query.executeQuery(consulta);
						StringBuilder salida = new StringBuilder();
						while(resultado.next()) {
							salida.append(resultado.getString("NOMBRE"));
							alta = resultado.getInt("ALTA");
							if(alta==1) {
								salida.append("' ");
							}else {
								salida.append(" ");
							}
							salida.append(resultado.getString("TIPO").toLowerCase() + System.lineSeparator());
						}
						System.out.println(salida.toString());
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case(5):{
					try {
						c.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					salir = true;
					break;
				}
			}
		}while(!salir);
	}

	private static String pedirCadena(String cadena) {
		System.out.println("Introduce " + cadena + ": ");
		String salida = teclado.nextLine();
		return salida;
	}
	private static int pedirInt(String cadena) {
		System.out.println("Introduce " + cadena + ": ");
		int salida = Integer.parseInt(teclado.nextLine());
		return salida;
	}
	
}
