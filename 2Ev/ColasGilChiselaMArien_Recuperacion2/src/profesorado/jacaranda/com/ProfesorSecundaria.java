package profesorado.jacaranda.com;

import centros.jacaranda.com.Centro;

public class ProfesorSecundaria extends Profesor{
	
	private EspecialidadesSecundaria especialidad;
	private int totalNotas;
	private int numEv;
	
	public ProfesorSecundaria(String nombre, Centro centro, EspecialidadesSecundaria especialidad) throws ProfesoresException {
		super(nombre, centro);
		this.totalNotas = 0;
		this.numEv = 0;
		try {
			this.especialidad = especialidad;
		}catch(Exception e) {
			throw new ProfesoresException("Especialidad no encontrada");
		}
	}

	public EspecialidadesSecundaria getEspecialidad() {
		return especialidad;
	}

	public int getTotalNotas() {
		return totalNotas;
	}

	public int getNumEv() {
		return numEv;
	}

	@Override
	public void evaluacionAnual(int nota) throws ProfesoresException {
		if(nota<0 || nota>10) {
			throw new ProfesoresException("La nota no es correcta");
		}else {
			totalNotas = totalNotas + nota;
			numEv ++;
			this.antiguedad++;
		}
	}

	@Override
	public void setCentroAdjudicado(Centro centroAdjudicado) throws ProfesoresException {
		if(this.antiguedad>=2) {
			this.centroAdjudicado = centroAdjudicado;
			setAntiguedad(0);
		}else {
			throw new ProfesoresException("La antiguedad debe ser mayor o igual a 2 para cambiar de centro a un profesor de primaria");
		}
	}

	@Override
	public String toString() {
		return "ProfesorSecundaria [especialidad=" + especialidad + ", media=" + totalNotas/numEv + ", nombre=" + nombre
				+ ", antiguedad=" + antiguedad + ", centroAdjudicado=" + centroAdjudicado + "]";
	}

}
