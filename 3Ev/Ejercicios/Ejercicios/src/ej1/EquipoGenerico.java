package ej1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class EquipoGenerico {
	
	private String nombre;
	private LinkedList<T> lista;
	
	public Equipo(String nombre) {
		this.nombre = nombre;
		lista = new LinkedList<Alumno>();
	}

	public void addAlumno(Alumno a) throws EquipoException {
		if(lista.contains(a)) {
			throw new EquipoException("El alumno ya forma parte del equipo");
		}else {
			lista.add(a);
		} 		
	}
	
	public void delAlumno(Alumno a) throws EquipoException{
		if(!lista.contains(a)) {
			throw new EquipoException("El alumno no se puede eliminar porque no forma parte del equipo");
		}else {
			lista.remove(a);
		} 
	}
	public Alumno alumnoPertenece(Alumno a) {
		Alumno salida;
		if(!lista.contains(a)) {
			salida = null;
		}else {
			salida = a;
		} 
		return salida;
	}
	
	public String mostrarAlumnos() {
		StringBuilder salida = new StringBuilder();
		for(Alumno a: lista) {
			salida.append(a.toString());
		}
		return salida.toString();
	}
	
	public Equipo unirEquipos(Equipo b) throws EquipoException {
		StringBuilder nombre = new StringBuilder(this.nombre);
		nombre.append("-" + b.getNombre());
		Equipo salida = new Equipo(nombre.toString());
		//añadir alumnos equipo a
		Iterator<Alumno> iterador = lista.iterator();
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
		for(Alumno a: lista) {
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
