package es.iesjacaranda;

import java.util.Objects;

public class Cliente {
	private String nombre;
	private String apellidos;
	private String dni;
	
	public Cliente(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void addReserva(Reserva reserva) {
		
	}
	
	//borra la reserva que se encuentra en la posición int -1. Devolverá la reserva borrada y  si no existe lanzará una exception.
	public Reserva delReserva(int posicion) {
		
	}
	
//    • El método getReserva devolverá un String con las reservas con el siguiente formato:
//	1.- reserva.toString
//	2.- reserva.toString()
//	…………………….
//		n.- reserva.toString()
	public String getReservas() {
		
	}


	@Override
	public String toString() {
		return "Cliente: Dni: " + dni + ", " + nombre + " " + apellidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	
	

}
