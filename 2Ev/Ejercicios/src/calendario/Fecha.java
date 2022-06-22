package calendario;

import java.time.LocalDate;
import java.util.Objects;

public class Fecha implements Comparable<Fecha>{
	private int dia;
	private String diaSemana;
	private int mes;
	private int anno;
	private final String[] DIAS_SEMANA = {"Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"};
	private final String[] MESES = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	
	public Fecha(int dia, int mes, int anno) throws FechaException {
		if(mes==0 || mes>12) {
			throw new FechaException("El número introducido para el mes no es correcto");
		}else {
			this.dia = dia;
			this.mes = mes;
			this.anno = anno;
			this.diaSemana = DIAS_SEMANA[conseguirDiaSemana()];
		}
	}
	
	public int getDia() {
		return dia;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public int getMes() {
		return mes;
	}
	public int getAnno() {
		return anno;
	}
	

	//puedo usar getDayOfTheWeek
	private int conseguirDiaSemana() {
		LocalDate fecha = LocalDate.of(anno, mes, dia);
		return fecha.getDayOfWeek().getValue();
	}
	private boolean esBisiesto() {
		boolean resultado = false;
		if(anno%4==0) {
			resultado = true;
		}
		return resultado;
	}
	//calcular esto si me pasan un entero enorme se hace muy complicado sin LocalDate asi que lo hare todo con 30 
	public void annadirDias(int dias){
		int comprobar = dia + dias;
		if(comprobar>30) {
			int sumarMeses = (dias-dia)/30;
			dia = dia + Math.round(dias%30);
			mes = mes + sumarMeses;
		}else {
			dia = comprobar;
		}	
	}
	public void restarDias(int dias) {
		int comprobar = dia - dias;
		if(comprobar<=0) {
			int sumarMeses = Math.abs((dias+dia)/30);
			dia = dia - Math.round(dias%30);
			mes = mes - sumarMeses;
		}else {
			dia = comprobar;
		}
	}
	public void annadirMeses(int meses) {
		int comprobar = mes + meses;
		if(comprobar>12) {
			int anyos = (meses+mes)/12;
			mes = mes + Math.round(meses%12);
			anno=anno + anyos;
		}else {
			mes = comprobar;
		}
	}
	public void restarMeses(int meses) {
		int comprobar = mes + meses;
		if(comprobar<=0) {
			int anyos = Math.round((meses-mes)/12);
			mes = Math.abs(comprobar)%12;
			anno=anno - anyos;
		}else {
			mes = comprobar;
		}
	}
	
	@Override
	public String toString() {
		return "Fecha: "+ diaSemana +" "+ dia + " de " + MESES[mes-1] + " de " + anno;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(anno, dia, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		return anno == other.anno && dia == other.dia && mes == other.mes;
	}

	@Override
	public int compareTo(Fecha o) {
		LocalDate fecha = LocalDate.of(anno, mes, dia);
		LocalDate fecha2 = LocalDate.of(o.getAnno(), o.getMes(), o.getDia());
		int salida = 0;
		if(fecha.isAfter(fecha2)) {
			salida = -1;
		}else if(fecha.isBefore(fecha2)){
			salida = 1;
		}
		return salida;
	}

}
