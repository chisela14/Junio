package ej3;

public class Profesor extends Persona {

	public Profesor(String nombre, String dni) {
		super(nombre, dni);
	}

	

	@Override
	public String toString() {
		return "Profesor [nombre=" + super.getNombre() + ", dni=" + getDni() + "]";
	}
	
	

}
