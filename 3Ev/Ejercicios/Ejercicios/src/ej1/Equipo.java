package ej1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Equipo {
	
	private String nombre;
	//Set no permite elementos repetidos
	private LinkedList<Alumno> alumnos;
	
	public Equipo(String nombre) {
		this.nombre = nombre;
		alumnos = new LinkedList<Alumno>();
	}

	public void addAlumno(Alumno a) throws EquipoException {
		if(alumnos.contains(a)) {
			throw new EquipoException("El alumno ya forma parte del equipo");
		}else {
			alumnos.add(a);
		} 		
	}
	
	public void delAlumno(Alumno a) throws EquipoException{
		if(!alumnos.contains(a)) {
			throw new EquipoException("El alumno no se puede eliminar porque no forma parte del equipo");
		}else {
			alumnos.remove(a);
		} 
	}
	public Alumno alumnoPertenece(Alumno a) {
		Alumno salida;
		if(!alumnos.contains(a)) {
			salida = null;
		}else {
			salida = a;
		} 
		return salida;
	}
	
	public String mostrarAlumnos() {
		StringBuilder salida = new StringBuilder();
		for(Alumno a: alumnos) {
			salida.append(a.toString());
		}
		return salida.toString();
	}
	
	public Equipo unirEquipos(Equipo b) throws EquipoException {
		StringBuilder nombre = new StringBuilder(this.nombre);
		nombre.append("-" + b.getNombre());
		Equipo salida = new Equipo(nombre.toString());
		//añadir alumnos equipo a
		Iterator<Alumno> iterador = alumnos.iterator();
		while(iterador.hasNext()) {
			salida.addAlumno(iterador.next());
		}
		//añadir alumnos equipo b
		iterador = b.alumnos.iterator();
		while(iterador.hasNext()) {
			salida.addAlumno(iterador.next());
		}
		return salida;
	}
	
	public Equipo interseccionEquipos(Equipo e) throws EquipoException {
		StringBuilder nombre = new StringBuilder(this.nombre);
		nombre.append("-" + e.getNombre() + " Intersección");
		Equipo salida = new Equipo(nombre.toString());
		//recorro los alumnos y añado al nuevo equipo si estan en el otro equipo
		for(Alumno a: alumnos) {
			if(e.alumnoPertenece(a)!=null) {
				salida.addAlumno(a);
			}
		}
		return salida;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
}
