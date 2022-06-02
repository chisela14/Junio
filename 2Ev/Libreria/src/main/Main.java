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

	public static void main(String[] args) {
		
		//CREAR DOS LIBROS USANDO LOS DOS CONSTRUCTORES
		System.out.println("Vamos a crear dos libros");
		//1
		System.out.println("Introduce el título del primer libro: ");
		String titulo1 = teclado.nextLine();
		System.out.println("Introduce el autor del primer libro: ");
		String autor1 = teclado.nextLine();
		Libro libro1 = new Libro(titulo1,autor1);
		//2
		System.out.println("Introduce el título del segundo libro: ");
		String titulo2 = teclado.nextLine();
		System.out.println("Introduce el autor del segundo libro: ");
		String autor2 = teclado.nextLine();
		System.out.println("Introduce la editorial del segundo libro");
		String editorial2 = teclado.nextLine();
		Libro libro2 = new Libro(titulo2,autor2, editorial2);
		//mostrar
		System.out.println(libro1.toString());
		System.out.println(libro2.toString());
		//introducir fecha de edicion y utilizar el método diasEntreEdiciones
		LocalDate date1 = LocalDate.parse("2018-11-01");
		libro1.setFechaEdicion(date1);
		LocalDate date2 = LocalDate.parse("2018-10-01");
		libro2.setFechaEdicion(date2);
		System.out.println(libro1.diasEntreEdiciones(libro2));
		
		//CREAR DOS LIBROS EN PAPEL CON LOS DOS CONSTRUCTORES
		System.out.println("Vamos a crear dos libros en papel");
		//1
		System.out.println("Introduce el título del primer libro: ");
		String tPapel1 = teclado.nextLine();
		System.out.println("Introduce el autor del primer libro: ");
		String aPapel1 = teclado.nextLine();
		System.out.println("Introduce el peso del primer libro: ");
		double peso1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce el precio del primer libro: ");
		double precio1 = Double.parseDouble(teclado.nextLine());
		LibroPapel papel1 = new LibroPapel(tPapel1,aPapel1, peso1, precio1);
		//2
		System.out.println("Introduce el título del segundo libro: ");
		String tPapel2 = teclado.nextLine();
		System.out.println("Introduce el autor del segundo libro: ");
		String aPapel2 = teclado.nextLine();
		System.out.println("Introduce la editorial del segundo libro");
		String ePapel2 = teclado.nextLine();
		System.out.println("Introduce el peso del segundo libro: ");
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
		System.out.println("Introduce el título del primer libro: ");
		String tDigital1 = teclado.nextLine();
		System.out.println("Introduce el autor del primer libro: ");
		String aDigital1 = teclado.nextLine();
		System.out.println("Introduce el precio del primer libro: ");
		double pDigital1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce el formato del primer libro: ");
		//como hago esto?
		Formato formato1 = teclado.nextLine();
		try {
			LibroDigital digital1 = new LibroDigital(tDigital1,aDigital1, pDigital1, formato1);
		} catch (LibroException e) {
			System.out.println("Formato no válido");
			//debería hacer un bucle para que lo vuelva a pedir?
		}
		//2
		System.out.println("Introduce el título del segundo libro: ");
		String tDigital2 = teclado.nextLine();
		System.out.println("Introduce el autor del segundo libro: ");
		String aDigital2 = teclado.nextLine();
		System.out.println("Introduce la editorial del segundo libro");
		String eDigital2 = teclado.nextLine();
		System.out.println("Introduce el precio del segundo libro: ");
		double pDigital2 = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce el formato del segundo libro: ");
		Formato formato2 = teclado.nextLine();
		try {
			LibroDigital digital2 = new LibroDigital(tDigital2,aDigital2,eDigital2, pDigital2, formato2);
		} catch (LibroException e) {
			System.out.println("Formato no válido");
		}
		//mostrar
		System.out.println(digital1.toString());
		System.out.println(digital2.toString());
				
		//probar el método esMasCaro entre un libro en papel y uno digital y viceversa
		System.out.println(papel1.esMasCaro(digital1));
		System.out.println(digital2.esMasCaro(papel2));
	}

}
