package main;

import java.time.LocalDate;

import java.util.Scanner;

import libros.Formato;
import libros.Libro;
import libros.LibroDigital;
import libros.LibroException;
import libros.LibroPapel;

public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws LibroException {
		
		//CREAR DOS LIBROS USANDO LOS DOS CONSTRUCTORES
		System.out.println("Vamos a crear dos libros");
		//1
		System.out.println("Introduce el titulo del primer libro: ");
		String titulo1 = teclado.nextLine();
		System.out.println("Introduce el autor del primer libro: ");
		String autor1 = teclado.nextLine();
		Libro libro1 = new Libro(titulo1,autor1);
		//2
		System.out.println("Introduce el titulo del segundo libro: ");
		String titulo2 = teclado.nextLine();
		System.out.println("Introduce el autor del segundo libro: ");
		String autor2 = teclado.nextLine();
		System.out.println("Introduce la editorial del segundo libro");
		String editorial2 = teclado.nextLine();
		Libro libro2 = new Libro(titulo2,autor2, editorial2);
		//mostrar
		System.out.println(libro1.toString());
		System.out.println(libro2.toString());
		//introducir fecha de edicion y utilizar el m�todo diasEntreEdiciones
		LocalDate date1 = LocalDate.parse("2018-11-01");
		libro1.setFechaEdicion(date1);
		LocalDate date2 = LocalDate.parse("2018-10-01");
		libro2.setFechaEdicion(date2);
		System.out.println(libro1.diasEntreEdiciones(libro2));
		
		//CREAR DOS LIBROS EN PAPEL CON LOS DOS CONSTRUCTORES
		System.out.println("Vamos a crear dos libros en papel");
		//1
		System.out.println("Introduce el titulo del primer libro: ");
		String tPapel1 = teclado.nextLine();
		System.out.println("Introduce el autor del primer libro: ");
		String aPapel1 = teclado.nextLine();
		System.out.println("Introduce el peso del primer libro: ");
		double peso1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce el precio del primer libro: ");
		double precio1 = Double.parseDouble(teclado.nextLine());
		LibroPapel papel1 = new LibroPapel(tPapel1,aPapel1, peso1, precio1);
		//2
		System.out.println("Introduce el titulo del segundo libro: ");
		String tPapel2 = teclado.nextLine();
		System.out.println("Introduce el autor del segundo libro: ");
		String aPapel2 = teclado.nextLine();
		System.out.println("Introduce la editorial del segundo libro");
		String ePapel2 = teclado.nextLine();
		System.out.println("Introduce el peso del segundo libro: ");
		//se podria hacer un try catch aqui para comprobar que es un double
		double peso2 = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce el precio del segundo libro: ");
		double precio2 = Double.parseDouble(teclado.nextLine());
		LibroPapel papel2 = new LibroPapel(tPapel2,aPapel2,ePapel2, peso2, precio2);
		//mostrar
		System.out.println(papel1.toString());
		System.out.println(papel2.toString());
		
		//CREAR DOS LIBROS DIGITALES CON LOS DOS CONSTRUCTORES
		System.out.println("Vamos a crear dos libros digitales");
		//1
		System.out.println("Introduce el titulo del primer libro: ");
		String tDigital1 = teclado.nextLine();
		System.out.println("Introduce el autor del primer libro: ");
		String aDigital1 = teclado.nextLine();
		System.out.println("Introduce el precio del primer libro: ");
		double pDigital1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce el formato del primer libro: ");
		String cadena = teclado.nextLine().toUpperCase();
		Formato formato1;
		try {
			 formato1 = Formato.valueOf(cadena);
			 //generará  IllegalArgumentException, podemos simplemente poner el padre de todas 
		} catch (Exception  e) {
			formato1 = Formato.PDF;
			//generar
			throw new LibroException ("Formato no valido, se asignará el formato por defecto PDF");
			
		}  
		LibroDigital digital1 = new LibroDigital(tDigital1,aDigital1, pDigital1, formato1);
		
		//2
		System.out.println("Introduce el t�tulo del segundo libro: ");
		String tDigital2 = teclado.nextLine();
		System.out.println("Introduce el autor del segundo libro: ");
		String aDigital2 = teclado.nextLine();
		System.out.println("Introduce la editorial del segundo libro");
		String eDigital2 = teclado.nextLine();
		System.out.println("Introduce el precio del segundo libro: ");
		double pDigital2 = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce el formato del segundo libro: ");
		cadena = teclado.nextLine().toUpperCase();
		Formato formato2;
		try {
			formato2 = Formato.valueOf(cadena);
		} catch (Exception e) {
			formato2 = Formato.PDF;
			//se lanza y nadie la recoge así que parará el programa
			throw new LibroException ("Formato no valido, se asignará el formato por defecto PDF");
		}
		LibroDigital digital2 = new LibroDigital(tDigital2,aDigital2,eDigital2, pDigital2, formato2);
		
		//mostrar
		System.out.println(digital1.toString());
		System.out.println(digital2.toString());
				
		//probar el metodo esMasCaro entre un libro en papel y uno digital y viceversa
		System.out.println(papel1.esMasCaro(digital1));
		System.out.println(digital2.esMasCaro(papel2));
	}

}
