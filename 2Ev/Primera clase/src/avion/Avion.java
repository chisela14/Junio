package avion;

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

	public boolean asignarVuelo(int capacidad, double kilometros) {
		boolean resultado;
		if (capacidad <= this.capacidad) {
			resultado = true;
			this.capacidad = this.capacidad - capacidad;
			this.kmVolados = this.kmVolados + kilometros;
			this.numVuelos = this.numVuelos + 1;
		} else {
			resultado = false;
		}
		return resultado;
	}

}
