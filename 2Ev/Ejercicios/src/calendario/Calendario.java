package calendario;

public class Calendario {
	
	private final int MAX_FECHAS = 100;
	private String nombre;
	private Fecha[] fechas;
	
	public Calendario(String nombre) {
		this.nombre = nombre;
		this.fechas = new Fecha[MAX_FECHAS];
	}
	
	public void addFecha(int dia, int mes, int anno) throws FechaException {
		Fecha f = new Fecha(dia,mes,anno);
		fechas[0] = f;
	}
	
	
}
