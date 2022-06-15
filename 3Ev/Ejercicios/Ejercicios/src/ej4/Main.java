package ej4;

public class Main {

	public static void main(String[] args) {
		Diccionario d = new Diccionario("esp");
		Significado s1 = new Significado("instrumento musical");
		Palabra teclado = new Palabra("teclado",s1);
		d.addPalabra(teclado);
		Significado s2 = new Significado("instrumento de escritura");
		teclado = new Palabra("teclado",s2);
		System.out.println(d.mostrarPalabras());
		d.addPalabra(teclado);
		System.out.println(d.mostrarPalabras());
		
		Significado s3 = new Significado("bebida alcoholica");
		Palabra tequila = new Palabra("tequila", s3);
		d.addPalabra(tequila);
		System.out.println(d.mostrarPalabras());
		System.out.println(d.palabrasEmpiezanPor("te"));;

	}

}
