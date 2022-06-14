package cartaBar;

import java.util.Scanner;

public class CartaMain {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static String menu = "1. Añadir elementos a la carta\n2. Borrar elementos de la carta\n"
			+ "3. Mostrar la carta\n4. Ordenar la carta\n5. Mostrar carta por orden alfabético\n"
			+ "6. Mostrar número de elementos en la carta\n7. Salir";
	
	public static void main(String[] args) throws CartaException {
		boolean salir = false;
		System.out.println("Introduce el nombre del bar a crear la carta: ");
		String nombre = teclado.nextLine();
		System.out.println("Introduce el número máximo de artículos que tendrá la carta: ");
		int num = Integer.parseInt(teclado.nextLine());
		Carta carta = new Carta(nombre,num);
		do {
			System.out.println(menu);
			int opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion) {
				case(1):{
					Articulo a = pedirArticulo();
					carta.addElemento(a);
					break;
				}
				case(2):{
					System.out.println("Introduzca la posicion del elemento a borrar: ");
					int pos = Integer.parseInt(teclado.nextLine());
					carta.delElemento(pos);
					break;
				}
				case(3):{
					System.out.println(carta.mostrarCarta());
					break;
				}
				case(4):{
					System.out.println("Introduzca la posicion del elemento a ordenar: ");
					int pos = Integer.parseInt(teclado.nextLine());
					System.out.println("Introduzca la posicion deseada para el elemento: ");
					int pos2 = Integer.parseInt(teclado.nextLine());
					carta.ordenarCarta(pos, pos2);
					break;
				}
				case(5):{
					System.out.println(carta.mostrarCartaAlfabetico());
					break;
				}
				case(6):{
					System.out.println(carta.toString());
					break;
				}
				case(7):{
					salir = true;
					break;
				}
			}
		}while(salir==false);
	}
	
	private static Articulo pedirArticulo() {
		System.out.println("¿Desea introducir una bebida(1) o un plato(2)?: ");
		int opcion = Integer.parseInt(teclado.nextLine());
		Articulo salida;
		System.out.println("Introduce el nombre: ");
		String nombre = teclado.nextLine();
		System.out.println("Introduce el precio: ");
		Double precio = Double.parseDouble(teclado.nextLine());
		char c;
		if(opcion==1) {
			System.out.println("¿Tiene alcohol (S/N)?: ");
			c = teclado.nextLine().charAt(0);
			boolean alcohol = false;
			if(c=='S') {
				alcohol=true;
			}
			System.out.println("¿Cuál es su capacidad (ml)?: ");
			int capacidad = Integer.parseInt(teclado.nextLine());
			salida = new Bebida(precio, nombre, alcohol, capacidad);
		}else {
			System.out.println("¿Tiene gluten?: ");
			c = teclado.nextLine().charAt(0);
			boolean gluten = false;
			if(c=='S') {
				gluten=true;
			}
			System.out.println("¿Tiene leche?: ");
			c = teclado.nextLine().charAt(0);
			boolean leche = false;
			if(c=='S') {
				leche=true;
			}
			System.out.println("¿Tiene frutos secos?: ");
			c = teclado.nextLine().charAt(0);
			boolean frutos = false;
			if(c=='S') {
				frutos=true;
			}
			System.out.println("¿Tiene marisco?: ");
			c = teclado.nextLine().charAt(0);
			boolean marisco = false;
			if(c=='S') {
				marisco=true;
			}
			System.out.println("Introduce su descripción: ");
			String descripcion = teclado.nextLine();
			salida = new Comida(precio, nombre, gluten, leche, frutos, marisco, descripcion);
		}
		return salida;
	}

}
