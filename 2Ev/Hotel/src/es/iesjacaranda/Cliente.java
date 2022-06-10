package es.iesjacaranda;

import java.util.Objects;

public class Cliente {
	
	private String nombre;
	private String apellidos;
	private String dni;
	private Reserva[] reservas;
	private int numReservas;
	
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
		reservas[0] = reserva;
		this.numReservas ++;
	}
	
	//borra la reserva que se encuentra en la posición-1. Devolverá la reserva borrada y  si no existe lanzará una exception.
	public Reserva delReserva(int posicion) throws ClienteException {
		if(reservas[posicion-1]==null) {
			throw new ClienteException("La reserva que se quiere borrar no existe");
		}else {
			Reserva devolver = reservas[posicion-1];
			for(int i=posicion+1;i<this.numReservas;i++) {
				reservas[i-1] = reservas[i];
			}
			this.numReservas --;
			return devolver;
		}
	}
	
	public String getReservas() {
		StringBuilder lista = new StringBuilder();
		for(int i=0;i<this.numReservas;i++) {
			lista.append(i+1+".- "+reservas[i].toString()+"\n");
		}
		lista.append("............................................");
		return lista.toString();
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
