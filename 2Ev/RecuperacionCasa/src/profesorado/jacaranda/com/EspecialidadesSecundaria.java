package profesorado.jacaranda.com;

public enum EspecialidadesSecundaria {
	
	INGLES(4),
	MATEMATICAS(5),
	LENGUA(5),
	INFORMATICA(2);
	
	private int numHoras;

	EspecialidadesSecundaria(int numHoras) {
		this.numHoras = numHoras;
	}

	public int getNumHoras() {
		return numHoras;
	}
	
}
