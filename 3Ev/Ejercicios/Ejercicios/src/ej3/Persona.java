package ej3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public abstract class Persona {
	
	private String nombre;
	private String dni;
	private LinkedList<Mensaje> recibidos;
	
	protected Persona(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.recibidos = new LinkedList<>();
	}
	
	//tod0 lo común se escribe aquí y únicamente en su hijo lo que sea diferente 
	public void enviarMensaje(Persona destino, String textoMensaje) throws PersonaException {
		Mensaje m = new Mensaje(textoMensaje, this);
		destino.recibidos.add(m);
	}
	
	public String mostrarBuzon() throws PersonaException {
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
	
	public String mostrarBuzonOrdenado() throws PersonaException {
		Collections.sort(recibidos);
		return mostrarBuzon();
	}
	
	public void delMensaje(int pos) throws PersonaException {
		if(recibidos.get(pos)==null) {
			throw new PersonaException("No existe ningún mensaje con ese número");
		}else {
			recibidos.remove(pos);
		}
	}
	
	public String encontrarMensajes(String frase) throws PersonaException {
		StringBuilder salida = new StringBuilder();
		for(Mensaje m: recibidos) {
			if(m.getTexto().contains(frase)) {
				salida.append(m.toString() + "\n");
			}
		}
		if(salida.isEmpty()) {
			throw new PersonaException("No se han encontrado mensajes que contengan esa frase");
		}
		return salida.toString();
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
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
