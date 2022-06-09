package es.iesjacaranda;

import java.time.LocalDate;

public class Hotel {
	//crear atributos de salas, clientes... con constantes
	private Cliente[] clientes;
	
	public Hotel(){
		inicializarHotel();
	}
	
	public void inicializarHotel() {
		
	}
	
	public String listarInstalaciones() {
		
	}
	
	public boolean encuentraCliente (String dni) {
		
	}
	
	public void nuevoCliente(String dni,String nombre, String apellido) {
		Cliente c = new Cliente(dni, nombre, apellido);
		clientes[0] = c;
	}
	
	private boolean salaLibre(Sala sala, LocalDate inicio, int dias) {
		
	}
	
	private Sala buscarSala(TiposSala tipo, LocalDate inicio, int dias) {
		
	}
	
	addReserva
}
