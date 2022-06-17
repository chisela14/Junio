package ej1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
//iMPLEMENTAR CLASE GENERICA<t>
public class EquipoGenerico <T> {
	
	private String nombre;
	private LinkedList<T> lista;
	
	public EquipoGenerico(String nombre) {
		this.nombre = nombre;
		lista = new LinkedList<T>();
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
	public Object objetoPertenece(T o) {
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
	
	public EquipoGenerico<T> unirEquipos(EquipoGenerico<T> b) throws EquipoException {
		StringBuilder nombre = new StringBuilder(this.nombre);
		nombre.append("-" + b.getNombre());
		EquipoGenerico<T> salida = new EquipoGenerico<T>(nombre.toString());
		//añadir obj equipo a
		Iterator<T> iterador = lista.iterator();
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
	
//	public EquipoGenerico<T> interseccionEquipos(EquipoGenerico<T> e) throws EquipoException {
//		StringBuilder nombre = new StringBuilder(this.nombre);
//		nombre.append("-" + e.getNombre() + " Intersección");
//		EquipoGenerico salida = new EquipoGenerico(nombre.toString());
//		//recorro los alumnos y añado al nuevo equipo si estan en el otro equipo
//		for(Object o: lista) {
//			if(e.objetoPertenece(o)!=null) {
//				salida.addObjeto(o);
//			}
//		}
//		return salida;
//	}
	
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
