package maquinaCafe;

import java.util.Scanner;

public class MaquinaMain {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Crear maquina
		System.out.println("Introduce el monedero de la máquina: ");
		int monedero = Integer.parseInt(teclado.nextLine());
		Maquina m1 = new Maquina (monedero);
		
		//Menu para el usuario
		boolean salir = false;
		do {
			System.out.println("1. Servir café solo (1 euro)\n2. Servir leche (0,8 euros)\n3. Servir café con leche (1,5 euros)\n"
					+ "4. Consultar estado máquina\n5. Apagar máquina y salir");
			int opcion = Integer.parseInt(teclado.nextLine());
			
			switch(opcion) {
				case (1):{
					double bebida = m1.getCAFE();
					int pago = hacerPago();
					boolean hayDinero = m1.vaciarMonedero(pago, bebida);
					m1.servirBebida(bebida, hayDinero);
					break;
				}
				case (2):{
					double bebida = m1.getLECHE();
					int pago = hacerPago();
					boolean hayDinero = m1.vaciarMonedero(pago, bebida);
					m1.servirBebida(bebida, hayDinero);
					break;
				}
				case (3):{
					double bebida = m1.getCAFECONLECHE();
					int pago = hacerPago();
					boolean hayDinero = m1.vaciarMonedero(pago, bebida);
					m1.servirBebida(bebida, hayDinero);
					break;
				}
				case (4):{
					System.out.println(m1.consultarEstado());
					break;
				}
				case (5):{
					salir = true;
					break;
				}
			}
		}while (salir == false);
	}
	
	public static int hacerPago () {
		System.out.println("Introduce el dinero: ");
		int pago = Integer.parseInt(teclado.nextLine());
		return pago;
	}
}
