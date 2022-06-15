package ej3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public abstract class Persona {
	
	protected String nombre;
	protected String dni;
	protected LinkedList<Mensaje> recibidos;
	
	public Persona(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.recibidos = new LinkedList<>();
	}

	protected abstract void enviarMensaje(Persona destino, String textoMensaje) throws PersonaException;
	
	protected String mostrarBuzon() throws PersonaException {
		StringBuilder salida = new StringBuilder();
		if(recibidos.isEmpty()) {
			throw new PersonaException("No hay mensajes");
		}else {
			int num = 1;
			for(Mensaje m: recibidos) {
				//para usar el to String tendria que poner el X al principio
				//si quiero poner el formato que me piden tengo que construirlo de 0 no?
				Persona remitente = m.getRemitente();
				salida.append("Mensaje " + num +": De: " + remitente.getNombre() + " Texto: " + m.getTexto()
				+System.lineSeparator() + "Fecha y hora: " + m.fechaHoraString()+System.lineSeparator());
				num++;
			}
		}
		return salida.toString();
		}
	
	protected String mostrarBuzonOrdenado() throws PersonaException {
		Collections.sort(recibidos);
		return mostrarBuzon();
	}
	
	protected void delMensaje(int pos) throws PersonaException {
		if(recibidos.get(pos)==null) {
			throw new PersonaException("No existe ningún mensaje con ese número");
		}else {
			recibidos.remove(pos);
		}
	}
	
	protected String encontrarMensajes(String frase) throws PersonaException {
		StringBuilder salida = new StringBuilder();
		ArrayList<Mensaje> encontrados = new ArrayList<>();
		//crear lista con los mensajes
		for(Mensaje m: recibidos) {
			if(m.getTexto().contains(frase)) {
				encontrados.add(m);
			}
		}
		if(encontrados.isEmpty()) {
			throw new PersonaException("No se han encontrado mensajes que contengan esa frase");
		}else {
			//mostrar lista
			Iterator<Mensaje> itr = encontrados.iterator();
			while(itr.hasNext()) {
				salida.append(itr.next().toString());
			}
			return salida.toString();
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", recibidos=" + recibidos.size() + "]";
	}
	
}
