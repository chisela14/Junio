package profesorado.jacaranda.com;

import centros.jacaranda.com.Centro;

public class ProfesorPrimaria extends Profesor {
	
	private EspecialidadesPrimaria especialidad;
	private int notaEvaluacion;

	public ProfesorPrimaria(String nombre, Centro centro) {
		super(nombre, centro);
		this.especialidad = EspecialidadesPrimaria.GENERAL;
	}
	
	public ProfesorPrimaria(String nombre, Centro centro, String especialidad) {
		super(nombre, centro);
		try {
			this.especialidad = EspecialidadesPrimaria.valueOf(especialidad);
		}catch(Exception e) {
			this.especialidad = EspecialidadesPrimaria.GENERAL;
			System.out.println("Especialidad vacía o no aceptada, se guardará el profesor con la especialidad 'General'");
		}
	}

	public int getNotaEvaluacion() {
		return notaEvaluacion;
	}

	private void setNotaEvaluacion(int notaEvaluacion) {
		this.notaEvaluacion = notaEvaluacion;
	}

	public EspecialidadesPrimaria getEspecialidad() {
		return especialidad;
	}

	@Override
	public void evaluacionAnual(int nota) throws ProfesoresException {
		if(nota<0 || nota>5) {
			throw new ProfesoresException("La nota no es correcta");
		}else {
			setNotaEvaluacion(nota);
			this.antiguedad++;
		}
	}

	@Override
	public void setCentroAdjudicado(Centro centroAdjudicado) throws ProfesoresException {
		if(this.antiguedad>=3) {
			this.centroAdjudicado = centroAdjudicado;
			setAntiguedad(0);
		}else {
			throw new ProfesoresException("La antiguedad debe ser mayor o igual a 3 para cambiar de centro a un profesor de primaria");
		}
	}

	@Override
	public String toString() {
		return "ProfesorPrimaria [especialidad=" + especialidad + ", notaEvaluacion=" + notaEvaluacion + ", nombre="
				+ nombre + ", antiguedad=" + antiguedad + ", centroAdjudicado=" + centroAdjudicado + "]";
	}
	

}
