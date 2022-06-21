package com.jacaranda.datos;

import java.time.LocalDate;
import java.util.Objects;

public class Datos implements Comparable<Datos> {

	private double valor;
	private int agno;
	private LocalDate periodo;
	
	public Datos(double valor, int agno, String periodo) {
		this.valor = valor;
		this.agno = agno;
		this.periodo = conseguirFecha(periodo);
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
		LocalDate result = LocalDate.parse("2022-"+mes+"-"+dia);
		return result;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getAgno() {
		return agno;
	}

	public void setAgno(int agno) {
		this.agno = agno;
	}

	public LocalDate getPeriodo() {
		return periodo;
	}

	public void setPeriodo(LocalDate periodo) {
		this.periodo = periodo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agno, periodo, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Datos other = (Datos) obj;
		return agno == other.agno && Objects.equals(periodo, other.periodo)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}

	@Override
	public String toString() {
		return "Datos [valor=" + valor + ", agno=" + agno + ", periodo=" + periodo + "]";
	}

	@Override //por fecha
	public int compareTo(Datos o) {
		int salida = 0;
		if(this.periodo.isAfter(o.getPeriodo())) {
			salida = 1;
		}else if(this.periodo.isBefore(o.getPeriodo())) {
			salida = -1;
		}
	
		return salida;
	}

	

	

	
}
