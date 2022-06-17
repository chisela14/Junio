package ej1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class EquipoGenerico <T> {
	
	private String nombre;
	private LinkedList<T> lista;
	
	public EquipoGenerico(String nombre) {
		this.nombre = nombre;
		lista = new LinkedList<>();
	}

	public void addObjeto(T o) throws EquipoException {
		if(lista.contains(o)) {
			throw new EquipoException("El objeto ya forma parte del equipo");
		}else {
			lista.add(o);
		} 		
	}
	
	public void delObjeto(T o) throws EquipoException{
		if(!lista.contains(o)) {
			throw new EquipoException("El objeto no se puede eliminar porque no forma parte del equipo");
		}else {
			lista.remove(o);
		} 
	}
	public T objetoPertenece(T o) {
		T salida = null;
		if(lista.contains(o)) {
			boolean encontrado = false;
			Iterator<T> itr = lista.iterator();
			while(itr.hasNext()&&!encontrado) {
				T o2= itr.next();
				if(o2.equals(o)) {
					salida = o2;
					encontrado = true;
				}
			}
		}
		return salida;
	}
	
	public String mostrarObjetos() {
		StringBuilder salida = new StringBuilder();
		for(T o: lista) {
			salida.append(o.toString());
		}
		return salida.toString();
	}
	
	public EquipoGenerico<T> unirEquipos(EquipoGenerico<T> b) throws EquipoException {
		StringBuilder nuevoNombre = new StringBuilder(this.nombre);
		nuevoNombre.append("-" + b.getNombre());
		EquipoGenerico<T> salida = new EquipoGenerico<>(nuevoNombre.toString());
		//añadir obj equipo a
		Iterator<T> iterador = lista.iterator();
		while(iterador.hasNext()) {
			salida.addObjeto(iterador.next());
		}
		//añadir alumnos equipo b
		iterador = b.lista.iterator();
		while(iterador.hasNext()) {
			salida.addObjeto(iterador.next());
		}
		return salida;
	}
	
	public EquipoGenerico<T> interseccionEquipos(EquipoGenerico<T> e) throws EquipoException {
		StringBuilder nuevoNombre = new StringBuilder(this.nombre);
		nuevoNombre.append("-" + e.getNombre() + " Intersección");
		EquipoGenerico<T> salida = new EquipoGenerico<>(nuevoNombre.toString());
		for(T o: lista) {
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
		EquipoGenerico<T> other = (EquipoGenerico<T>) obj;
		return Objects.equals(nombre, other.nombre);
	}

	

	
}
