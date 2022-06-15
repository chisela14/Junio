package ej3;

public class Alumno extends Persona {

	private int edad;

	public Alumno(String nombre, String dni, int edad) {
		super(nombre, dni);
		this.edad = edad;
	}

	@Override
	protected void enviarMensaje(Persona destino, String textoMensaje) throws PersonaException {
		if(edad<18 && destino instanceof Alumno) {
			throw new PersonaException("Los alumnos menores de edad solo pueden enviar mensajes a profesores");
		}else {
			Mensaje m = new Mensaje(textoMensaje, this);
			destino.recibidos.add(m);
		}

	}

	@Override
	public String toString() {
		return "Alumno [edad=" + edad + ", nombre=" + nombre + ", dni=" + dni +"]";
	}
	

}
