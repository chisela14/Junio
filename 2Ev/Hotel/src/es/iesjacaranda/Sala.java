package es.iesjacaranda;

import java.util.Arrays;
import java.util.Objects;

public class Sala {
	private static int codigoSig = 1;
	private int codigo;
	private TiposSala tipo;
	private Reserva[] reservas;
	private int numReservas;
	
	public Sala(TiposSala tipo) {
		this.tipo = tipo;
		this.codigo = codigoSig;
		codigoSig ++;
	}
	
	public void addReserva(Reserva reserva) {
		reservas[0] = reserva;
		this.numReservas ++;
	}
	
	//debe borrar la reserva que se la pasa por parámetro de la lista de reservas de las salas
	//asumo que se puede hacer, se va a encontrar la reserva o se buscara que la reserva existe en otro lado
	public void delReserva(Reserva reserva) {
		//encontrar la reserva en el array
		for(int i=0;i<=reservas.length;i++) {
			if(reservas[i].compareTo(reserva)==0) {
				//borrarla
				for(int j=i+1;j<reservas.length;j++) {
					reservas[i-1] = reservas[i];
				}
			}
		}
		this.numReservas --;
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

	public Reserva[] getReservas() {
		return reservas;
	}

	public int getNumReservas() {
		return numReservas;
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
