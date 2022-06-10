package es.iesjacaranda;

import java.time.LocalDate;
import java.util.Scanner;

public class PrincipalGui {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static final String MENU_PRINCIPAL = "1. Listar todas las estancias.\n"+
												"2. Reservar una estancia.\n"+
												"3. Mostrar todas las reservas ordenadas por fecha.\n"+
												"4. Mostrar todos los clientes del hotel.\n"+
												"5. Mostrar todas las reservas de un cliente.\n"+
												"6. Mostrar las reservas posteriores a una fecha.\n"+
												"7. Anular una reserva\n"+
												"8. Salir";
	
//	2 y 7: Si queremos hacer una reserva nos pedirá la fecha inicial de la reserva, el número de días,
//	el tipo de habitación y el número de personas, si es necesario. Una vez que vemos que hay
//	disponibilidad le pediremos el dni de la persona responsable o de las personas si son dos
//	en habitación doble o suite. Si el cliente no existe, se deberá solicitar el nombre y el
//	apellido.
	
	//fecha por defecto: "yyyy-mm-dd"  �:
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//LocalDate localDate = LocalDate.parse(date, formatter);
	
	public static void main(String[] args) throws HotelException, ClienteException {
		
		//creo un hotel
		Hotel hotel = new Hotel();
		
		boolean salir = false;
		do {
			//variables para usar en el menu
			LocalDate fecha;
			int dias, personas, numReserva;
			TiposSala habitacion;
			String dni, nombre, apellidos;
			
			mostrarMenuPrincipal();
			int opcion = seleccionarOpcionMenuPrincipal();
			switch(opcion) {
				case(1):{
					System.out.println(hotel.listarInstalaciones());
					break;
				}
				case(2):{
					//no se si he puesto bien la informacion en los try catch, he comentado lo que quiero hacer
					fecha = obtenerFecha();
					dias = obtenerEntero("días");
					habitacion = obtenerTipoSala();
					personas = obtenerEntero("personas");
					try {
						hotel.addReserva(habitacion, fecha, dias, personas);//esta es la linea a probar
					}catch(Exception e) {//si la primera linea salta exception (num personas no permitido o no se peude hacer la reserva) se informa
						System.out.println(e.getMessage());
					}
					//si en la primera linea no salta exception se hace lo siguiente:
					for (int i=0;i<personas;i++) {
						dni = obtenerCadena(String.valueOf(i+1)+"º dni");
						try {
							hotel.addClienteUltimaReserva(dni);
						}catch (Exception e) {
							nombre = obtenerCadena("nombre");
							apellidos = obtenerCadena("apellido");
							hotel.nuevoCliente(dni,nombre,apellidos);
							hotel.addClienteUltimaReserva(dni);
						}
					}
					break;
				}
				case(3):{
					System.out.println(hotel.getReservasFechas());
					break;
				}
				case(4):{
					System.out.println(hotel.getClientes());
					break;
				}
				case(5):{
					dni = obtenerCadena("dni del cliente");
					try {
						hotel.getReservasClientes(dni);
					}catch(Exception e) {
						System.out.println("El cliente no existe o no tiene reservas.");
					}
					break;
				}
				case(6):{
					fecha = obtenerFecha();
					try {
						hotel.getReservasPosteriores(fecha);
					}catch (Exception e) {
						System.out.println("No hay reservas posteriores a esa fecha.");
					}
					break;
				}
				case(7):{
					//encontrar reserva
					dni = obtenerCadena("dni");
					hotel.getReservasClientes(dni);
					numReserva = obtenerEntero("reserva");
					//borrar reserva
					try {
						hotel.delReserva(dni, numReserva);
					}
					//si el cliente no existe (HotelException) se recoge la excepcion para crear un cliente y despues crear la reserva
					catch (HotelException e) {
						nombre = obtenerCadena("nombre");
						apellidos = obtenerCadena("apellido");
						hotel.nuevoCliente(dni,nombre,apellidos);
						hotel.delReserva(dni, numReserva);
					}
					//si salta ClienteException simplemente se muestra el mensaje de error
					catch (ClienteException e2) {
						System.out.println(e2.getMessage());
					}
					break;
				}
				case(8):{
					salir = true;
					break;
				}
			}
			
		}while (salir == false);
		
	}
	
	private static void mostrarMenuPrincipal() {
		System.out.println(MENU_PRINCIPAL);
	}
	
	private static int seleccionarOpcionMenuPrincipal() {
		System.out.println("Introduce una opcion: ");
		int opcion = Integer.parseInt(teclado.nextLine());
		return opcion;
	}
	
	//revisar como hace el parse para lanzar exception en el menu
	private static LocalDate obtenerFecha() {
		System.out.println("Introduce la fecha (yyyy-mm-dd): ");
		LocalDate fecha = LocalDate.parse(teclado.nextLine());
		return fecha;
	}
	
	private static TiposSala obtenerTipoSala() {
		System.out.println("Introduce el tipo de sala (simple, doble, suite, reunion o celebracion): ");
		String cadena = teclado.nextLine().toUpperCase();
		TiposSala salida = TiposSala.valueOf(cadena);
		return salida;
	}
	
//	No se cuando se usa este
//	private static String obtenerCliente() {
//		
//	}
	
	private static int obtenerEntero(String cadena) {
		System.out.println("Introduce el numero de "+cadena+": ");
		int salida = Integer.parseInt(teclado.nextLine());
		return salida;
	}
	
	private static String obtenerCadena (String cadena) {
		System.out.println("Introduce el "+cadena+": ");
		String salida = teclado.nextLine();
		return salida;
	}

}
