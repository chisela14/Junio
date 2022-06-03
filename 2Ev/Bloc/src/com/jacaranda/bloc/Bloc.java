package com.jacaranda.bloc;

import java.util.ArrayList;
import java.util.Objects;

import com.jacaranda.notas.Nota;
import com.jacaranda.notas.NotaAlarma;
//no me queda claro como interaccionan bloc y notaAlarma
public class Bloc {
	
	private static final int NUMERO_NOTAS_MAXIMO = 10;
	private int numNotas;
	private String nombre;
	private ArrayList<Nota> notas;
	
	public Bloc(String nombre) {
		this.nombre = nombre;
		this.notas = new ArrayList<Nota>();
	}
	//funcionalidades que me piden
	//si le paso una nota por parametro ¿tambien acepta que sea una NotaAlarma o tengo que hacer otro metodo?
	public void annadirNota (Nota n) throws BlocException {
		if(this.numNotas==NUMERO_NOTAS_MAXIMO) {
			throw new BlocException("Número máximo de notas en el bloc alcanzado");
		}else {
			notas.add(n);
			this.numNotas ++;
		}
	}
	
	public void eliminarNota (int posicion) {
		notas.remove(posicion);
	}
	
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	
	public int getNumNotas() {
		return numNotas;
	}
	
	//uml
	public String getNota(int posicion) {
		return notas.get(posicion).toString();
	}
	
	public void updateNota(int posicion, String texto) {
		Nota nota = notas.get(posicion);
		nota.setTexto(texto);
	}
	
	public void activa(int posicion) {
		Nota nota = notas.get(posicion);
		nota.activar();
	}
	
	public void desactiva(int posicion) {
		Nota nota = notas.get(posicion);
		nota.desactivar();
	}
	
	public static int getNumeroNotasMaximo() {
		return NUMERO_NOTAS_MAXIMO;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "Bloc [numNotas=" + numNotas + ", nombre=" + nombre + ", notas=" + notas + "]";
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
		Bloc other = (Bloc) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	//ordenaBloc se refiere a un compareTo o a un método para ordenar 
	//las notas de un bloque (compareTo de nota supongo?)?
	
	
	
	

}
