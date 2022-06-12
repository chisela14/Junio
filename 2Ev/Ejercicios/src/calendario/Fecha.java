package calendario;

import java.time.LocalDate;

public class Fecha {
	private int dia;
	private String diaSemana;
	private int mes;
	private int anno;
	private final String[] DIAS_SEMANA = {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
	private final String[] MESES = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	
	public Fecha(int dia, int mes, int anno) throws FechaException {
		if(mes==0 || mes>12) {
			throw new FechaException("El número introducido para el mes no es correcto");
		}else {
			this.dia = dia;
			this.mes = mes;
			this.anno = anno;
			this.diaSemana = conseguirDiaSemana();
		}
	}


	@Override
	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + MESES[mes-1] + ", anno=" + anno + "]";
	}

}
