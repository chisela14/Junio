package es.iesjacaranda;

import java.util.Arrays;
import java.util.Objects;

public class Sala {
	private static int codigoSig = 1;
	private int codigo;
	private TiposSala tipo;
	private Reserva[] reservas;
	
	public Sala(TiposSala tipo) {
		this.tipo = tipo;
		this.codigo = codigoSig;
		codigoSig ++;
	}
	
	public void addReserva(Reserva reserva) {
		
	}
	//debe borrar la reserva que se la pasa por parámetro de la lista de reservas de las salas
	public void delReserva(Reserva reserva) {
		
	}

	public int getCodigo() {
		return codigo;
	}
	
	public TiposSala getTipo() {
		return tipo;
	}
	
	public int getOcupacionMaxima() {
		return tipo.getNumPersonas();
	}
	
	public double getFactor() {
		return tipo.getFactor();
	}

	@Override
	public String toString() {
		return "Sala: " + codigo + " Tipo: " + tipo + " Ocupacion Máxima: " + getOcupacionMaxima() + " Reservas: " + Arrays.toString(reservas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return codigo == other.codigo;
	}
	
	
	

}
