package com.jacaranda.datos;

import java.time.LocalDate;
import java.util.Objects;

public class Informacion implements Comparable<Informacion> {
	
	private double Valor;
	private int Agno;
	private String Periodo;
	private LocalDate fecha;

	public Informacion(double valor, int agno, String periodo) {
		super();
		Valor = valor;
		Agno = agno;
		Periodo = periodo;
		this.fecha = conseguirFecha(this.Periodo);
	}

	private LocalDate conseguirFecha(String cadena) {
		String dia = cadena.substring(4,5);
		String mes;
		if(dia.endsWith(" ")) {
			dia = dia.trim();
			mes = cadena.substring(9);
		}else {
			mes = cadena.substring(10);
		}
		
		switch(mes) {
		case("enero"):{
			mes = "01";
			break;
		}
		case("febrero"):{
			mes = "02";
			break;
		}
		case("marzo"):{
			mes = "03";
			break;
		}
		case("abril"):{
			mes = "04";
			break;
		}
		case("mayo"):{
			mes = "05";
			break;
		}
		case("junio"):{
			mes = "06";
			break;
		}
		case("julio"):{
			mes = "07";
			break;
		}
		case("agosto"):{
			mes = "08";
			break;
		}
		case("septiembre"):{
			mes = "09";
			break;
		}
		case("octubre"):{
			mes = "10";
			break;
		}
		case("noviembre"):{
			mes = "11";
			break;
		}
		case("diciembre"):{
			mes = "12";
			break;
		}
		}
		return LocalDate.parse("2022-"+mes+"-"+dia);
	}

	public double getValor() {
		return this.Valor;
	}

	public void setValor(double valor) {
		this.Valor = valor;
	}

	public int getAgno() {
		return this.Agno;
	}

	public void setAgno(int agno) {
		this.Agno = agno;
	}

	public String getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Agno, Periodo, Valor, fecha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Informacion other = (Informacion) obj;
		return Agno == other.Agno && Objects.equals(Periodo, other.Periodo)
				&& Double.doubleToLongBits(Valor) == Double.doubleToLongBits(other.Valor)
				&& Objects.equals(fecha, other.fecha);
	}

	@Override
	public String toString() {
		return "Informacion [Valor=" + Valor + ", Agno=" + Agno + ", fecha=" + fecha + "]";
	}



	@Override //por fecha
	public int compareTo(Informacion o) {
		int salida = 0;
		if(this.fecha.isAfter(o.getFecha())) {
			salida = 1;
		}else if(this.fecha.isBefore(o.getFecha())) {
			salida = -1;
		}
	
		return salida;
	}
	
}
