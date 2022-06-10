package es.iesjacaranda;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva implements Comparable<Reserva>{
	
	private LocalDate fechaI;
	private LocalDate fechaF;
	private Sala sala;
	private Cliente[] clientes;
	private int numClientes;
	
	public Reserva(LocalDate fechaI, LocalDate fechaF, Sala sala) {
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.sala = sala;
		clientes = new Cliente[sala.getOcupacionMaxima()];
	}
	
	public boolean solapa(LocalDate inicio, int dias) {
		boolean resultado = false;
		if (fechaI == inicio) {
			LocalDate acaba = fechaI.plusDays(dias);
			if(fechaF==acaba) {
				resultado = true;
			}
		}
		return resultado;
	}
	
	public int getCodigoSala() {
		return sala.getCodigo();
	}
	
	public void addCliente(Cliente cliente) {
		clientes[0] = cliente;
		this.numClientes ++;
	}
	
	public LocalDate getFechaI() {
		return fechaI;
	}

	public LocalDate getFechaF() {
		return fechaF;
	}

	@Override
	public String toString() {
		return "Reserva: Fecha Inicial: " + fechaI + " Fecha Final: " + fechaF + " Cliente: " + clientes.toString() + " Sala: " + sala.getCodigo();
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaF, fechaI, sala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(fechaF, other.fechaF) && Objects.equals(fechaI, other.fechaI)
				&& Objects.equals(sala, other.sala);
	}

	@Override
	public int compareTo(Reserva o) {
		int salida = 0;
		if(this.fechaI.isAfter(o.getFechaI())) {
			salida = 1;
		}else if(this.fechaI.isBefore(o.getFechaI())) {
			salida = -1;
		}
		return salida;
	}

	
}
