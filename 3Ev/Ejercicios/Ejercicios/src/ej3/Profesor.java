package ej3;

public class Profesor extends Persona {

	public Profesor(String nombre, String dni) {
		super(nombre, dni);
	}

	@Override
	protected void enviarMensaje(Persona destino, String textoMensaje) {
		Mensaje m = new Mensaje(textoMensaje, this);
		destino.recibidos.add(m);
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	

}
