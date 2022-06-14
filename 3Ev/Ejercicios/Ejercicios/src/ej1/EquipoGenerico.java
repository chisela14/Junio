package ej1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class EquipoGenerico {
	
	private String nombre;
	private LinkedList<Object> lista;
	
	public EquipoGenerico(String nombre) {
		this.nombre = nombre;
		lista = new LinkedList<Object>();
	}

	public void addObjeto(Object o) throws EquipoException {
		if(lista.contains(o)) {
			throw new EquipoException("El objeto ya forma parte del equipo");
		}else {
			lista.add(o);
		} 		
	}
	
	public void delObjeto(Object o) throws EquipoException{
		if(!lista.contains(o)) {
			throw new EquipoException("El objeto no se puede eliminar porque no forma parte del equipo");
		}else {
			lista.remove(o);
		} 
	}
	public Object objetoPertenece(Object o) {
		Object salida;
		if(!lista.contains(o)) {
			salida = null;
		}else {
			salida = o;
		} 
		return salida;
	}
	
	public String mostrarObjetos() {
		StringBuilder salida = new StringBuilder();
		for(Object o: lista) {
			salida.append(o.toString());
		}
		return salida.toString();
	}
	
	public EquipoGenerico unirEquipos(EquipoGenerico b) throws EquipoException {
		StringBuilder nombre = new StringBuilder(this.nombre);
		nombre.append("-" + b.getNombre());
		EquipoGenerico salida = new EquipoGenerico(nombre.toString());
		//añadir obj equipo a
		Iterator<Object> iterador = lista.iterator();
		while(iterador.hasNext()) {
			salida.addObjeto(iterador.next());
		}
		//aÃ±adir alumnos equipo b
		iterador = b.lista.iterator();
		while(iterador.hasNext()) {
			salida.addObjeto(iterador.next());
		}
		return salida;
	}
	
	public EquipoGenerico interseccionEquipos(EquipoGenerico e) throws EquipoException {
		StringBuilder nombre = new StringBuilder(this.nombre);
		nombre.append("-" + e.getNombre() + " Intersección");
		EquipoGenerico salida = new EquipoGenerico(nombre.toString());
		//recorro los alumnos y añado al nuevo equipo si estan en el otro equipo
		for(Object o: lista) {
			if(e.objetoPertenece(o)!=null) {
				salida.addObjeto(o);
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
		EquipoGenerico other = (EquipoGenerico) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
}
