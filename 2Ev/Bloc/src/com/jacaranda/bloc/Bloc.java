package com.jacaranda.bloc;

import java.util.Arrays;
import java.util.Objects;

import com.jacaranda.notas.Nota;
import com.jacaranda.notas.NotaAlarma;

public class Bloc {
	
	private static final int NUMERO_NOTAS_MAXIMO = 10;
	private int numNotas;
	private String nombre;
	private Nota[] notas;
	
	public Bloc(String nombre) {
		this.nombre = nombre;
		this.notas = new Nota[NUMERO_NOTAS_MAXIMO];
		this.numNotas = 0;
	}
	
	//funcionalidades que me piden
	public void annadirNota (Nota n) throws BlocException {
		if(this.numNotas==NUMERO_NOTAS_MAXIMO) {
			throw new BlocException("Número máximo de notas en el bloc alcanzado");
		}else {
			notas[numNotas] = n;
			this.numNotas ++;
		}
	}
	
	public void eliminarNota (int posicion) {
		for(int i=posicion+1; i<this.numNotas; i++) {
				notas[i-1]=notas[i];
		}
		this.numNotas --;
	}
	
	public String listarNotas() {
		StringBuilder cadena = new StringBuilder();
		for (int i=0; i<this.numNotas; i++) {
			cadena.append(notas[i].toString()+"\n");
		}
		return cadena.toString();
	}
	
	public int getNumNotas() {
		return numNotas;
	}
	
	//uml
	public String getNota(int posicion) throws BlocException {
		if (notas[posicion]!= null) {
			return notas[posicion].toString();
		}else {
			throw new BlocException("La nota no existe");
		}
		
	}
	
	public void updateNota(int posicion, String texto) throws BlocException {
		Nota nota = notas[posicion];
		if (nota != null) {
			nota.setTexto(texto);
		}else {
			throw new BlocException("La nota no existe");
		}
		
	}
	
	public void activa(int posicion) throws BlocException {
		if (notas[posicion]!= null) {
			//comprobar si es nota o notaAlarma
			if (notas[posicion]instanceof NotaAlarma ) {
				NotaAlarma nota = (NotaAlarma)notas[posicion];
				//si la nota esta activada lanza exception
				if(nota.isActivado() == true) {
					throw new BlocException("La nota ya está activada");
				}else {
					nota.activar();
				}
			}
			else {
				throw new BlocException("No se puede activar una nota normal");
			}
		}else {
			throw new BlocException("La nota no existe");
		}
		
	}
	
	public void desactiva(int posicion) throws BlocException {
		if (notas[posicion]!= null) {
			//comprobar si es nota o notaAlarma
			if (notas[posicion]instanceof NotaAlarma) {
				NotaAlarma nota = (NotaAlarma)notas[posicion];
				//si la nota esta desactivada lanza exception
				if(nota.isActivado() == false) {
					throw new BlocException("La nota ya está desactivada");
				}else {
					nota.desactivar();
				}
			}
			else {
				throw new BlocException("No se puede desactivar una nota normal");
			}
		}else {
			throw new BlocException("La nota no existe");
		}
		
		
	}
	
	public static int getNumeroNotasMaximo() {
		return NUMERO_NOTAS_MAXIMO;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "Bloc [numNotas=" + numNotas + ", nombre=" + nombre + "]";
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
	
	public String ordenarBloc() {
		Nota notasOrdenar[]= new Nota[this.numNotas];
		StringBuilder cadena = new StringBuilder();
		//creo un array que contenta solo las notas (para evitar null)
		for(int i=0;i<this.numNotas;i++) {
			notasOrdenar[i]=notas[i];
		}
		//las ordena según el compareTo de nota
		Arrays.sort(notasOrdenar);
		//paso el resultado a una cadena, que es lo que debe devolver el método
		for(int i=0;i<this.numNotas;i++) {
			cadena.append(notasOrdenar[i].toString()+"\n");
		}	
		return cadena.toString();
	}
	
	
	
	

}
