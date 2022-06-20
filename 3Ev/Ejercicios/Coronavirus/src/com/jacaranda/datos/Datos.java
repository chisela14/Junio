package com.jacaranda.datos;

import java.util.Objects;

public class Datos {

	private double valor;
	private int agno;
	private String periodo;
	private String parametro;
	
	public Datos(double valor, int agno, String periodo, String parametro) {
		this.valor = valor;
		this.agno = agno;
		this.periodo = periodo;
		this.parametro = parametro;
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

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agno, parametro, periodo, valor);
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
		return agno == other.agno && Objects.equals(parametro, other.parametro)
				&& Objects.equals(periodo, other.periodo)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}

	@Override
	public String toString() {
		return "Datos [valor=" + valor + ", agno=" + agno + ", periodo=" + periodo + ", parametro=" + parametro + "]";
	}

	
}
