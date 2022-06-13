package profesorado.jacaranda.com;

import java.util.Objects;

import centros.jacaranda.com.*;

public abstract class Profesor implements EvaluableAnualmente{

	protected String nombre;
	protected int antiguedad;
	protected Centro centroAdjudicado;
	
	protected Profesor(String nombre, Centro centro) {
		this.nombre = nombre;
		this.centroAdjudicado = centro;
		this.antiguedad = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	protected void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Centro getCentroAdjudicado() {
		return centroAdjudicado;
	}

	public abstract void setCentroAdjudicado(Centro centroAdjudicado) throws ProfesoresException;
	

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", antiguedad=" + antiguedad + ", centroAdjudicado=" + centroAdjudicado
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(nombre, other.nombre);
	}
	

}
