package avion;

import java.util.Objects;

public class Avion {

	private String idAvion;
	private int capacidad;
	private int numVuelos;
	private double kmVolados;
	private String compannia;

	public Avion(String idAvion, int capacidad) {
		super();
		this.idAvion = idAvion;
		this.capacidad = capacidad;
		this.numVuelos = 0;
		this.kmVolados = 0;
		this.compannia = "";
	}

	public Avion(String idAvion, int capacidad, String compannia) {
		super();
		this.idAvion = idAvion;
		this.capacidad = capacidad;
		this.compannia = compannia;
		this.numVuelos = 0;
		this.kmVolados = 0;
	}

	public String getIdAvion() {
		return idAvion;
	}

	private void setIdAvion(String idAvion) {
		this.idAvion = idAvion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	private void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getNumeroVuelos() {
		return numVuelos;
	}

	private void setNumVuelos(int numVuelos) {
		this.numVuelos = numVuelos;
	}

	public double getTotalKm() {
		return kmVolados;
	}

	private void setKmVolados(float kmVolados) {
		this.kmVolados = kmVolados;
	}

	public double getMediaKm() {
		return kmVolados / numVuelos;
	}

	public String getCompannia() {
		return compannia;
	}

	public void setCompannia(String compannia) {
		this.compannia = compannia;
	}
	//asiento ocupados seria una caracteristica a guardar des vuelo, y no se va a guardar
	public boolean asignarVuelo(int asientos, double kilometros) {
		boolean resultado;
		if (asientos <= this.capacidad) {
			resultado = true;
			this.kmVolados = this.kmVolados + kilometros;
			this.numVuelos = this.numVuelos + 1;
		} else {
			resultado = false;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Avion [idAvion=" + idAvion + ", capacidad=" + capacidad + ", numVuelos=" + numVuelos + ", kmVolados="
				+ kmVolados + ", compannia=" + compannia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAvion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		return Objects.equals(idAvion, other.idAvion);
	}
	

}
