package rectangulo;

import java.util.Scanner;

public class RectanguloMain {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		//Crear rectagulo 
		Rectangulo r1 = new Rectangulo ();
		
		//Guardar longitud y ancho que de el usuario
		double longitud, ancho;
		System.out.println("Introduce la longitud del rect�ngulo: ");
		longitud = Double.parseDouble(teclado.nextLine());
		System.out.println("Introduce el ancho del rect�ngulo: ");
		ancho = Double.parseDouble(teclado.nextLine());
		
		//cambiar ancho y longitud de nuestro rectangulo (1,1) por los del usuario
		r1. setLongitud(longitud);
		r1. setAncho (ancho);
		
		//Mostrar resultado del m�todo en Rectangulo con los datos del usuario
		double area = r1.calcularArea();
		double perimetro = r1.calcularPerimetro();
		System.out.println("El �rea del rect�ngulo es: " + area);
		System.out.println("El per�metro del rect�ngulo es: " + perimetro);
	}

	

}
