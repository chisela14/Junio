package es.iesjacaranda;

public enum TiposSala {
	SIMPLE(2,1),
	DOBLE(4,2),
	SUITE(2,3),
	REUNION(10,3.5),
	CELEBRACION(30,5);
	
	private int numPersonas;
	private double factor;
	
	private TiposSala(int numPersonas, double factor) {
		this.numPersonas = numPersonas;
		this.factor = factor;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public double getFactor() {
		return factor;
	}
	
	
}
