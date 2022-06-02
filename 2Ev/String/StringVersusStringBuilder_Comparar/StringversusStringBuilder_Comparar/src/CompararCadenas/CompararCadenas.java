package CompararCadenas;

import java.util.Scanner;

public class CompararCadenas {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		comparaStringIguales();
		comparaStringConLectura();
		comparaStringEqual();
		comparaStringCompareTo();
		comparaStringBuilderEqual();	
	}
	
	// Si funcionaría porque son el mismo objeto
	public static void comparaStringIguales() {
		String s1 = "Inma", s2 ="Inma";
		System.out.println("Si son el mismo literal == devuevle True\ns1=" + s1 +" s2=" +s2);
		System.out.println(s1==s2);
	}
	
	// No funcionaría aunque escribamos Inma porque
	// son dos objetos distintos
	
	public static void comparaStringConLectura(){
		String s1 = "Inma", s2;
		System.out.println("Introduce cadena:");
		s2= teclado.nextLine();
		System.out.println("Si no son el mismo literal, aunque tengan el mismo contenido == devuelve false\ns1=" + s1 +" s2=" +s2);
		System.out.println(s1==s2);
	}
	
	// La comparación de String con equals si funciona
	
	public static void comparaStringEqual() {
		String s1 = "Inma", s2;
		System.out.println("Introduce cadena:");
		s2= teclado.nextLine();
		System.out.println("Las cadenas siempre deben compararse con equals\ns1=" + s1 +" s2=" +s2);
		System.out.println(s1.equals(s2));
	}
	
	// La comparación de String con compareTo si funciona
	public static void comparaStringCompareTo(){
		String s1 = "Inma", s2;
		System.out.println("Introduce cadena:");
		s2= teclado.nextLine();
		System.out.println("Las cadenas también pueden compararse con compareTo\ns1=" + s1 +" s2=" +s2);
		System.out.println(s1.compareTo(s2));
	}
	
	// StringBuilder no funciona ni la comparación ni el equal
	public static void comparaStringBuilderEqual(){
		StringBuilder s1 = new StringBuilder("Inma");
		StringBuilder s2 = new StringBuilder("Inma");
		System.out.println("Los objetos StringBuilder no tienen implementado el método equal, por lo que no funciona la comparación equals. Se debe usar compareTo\ns1=" + s1 +" s2=" +s2);
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println("Los objetos StringBuilder debe comparase con compareTo\n s1=" + s1 +" s2=" +s2);
		System.out.println(s1.compareTo(s2));
		System.out.println("Introduce cadena:");
		s2.delete(0, s2.length());
		s2.append(teclado.nextLine());
		System.out.println(s1.compareTo(s2));
	}
	
	
	
}
