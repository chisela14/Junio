package cartaBar;

import java.util.Arrays;
import java.util.Objects;

public class Carta {
	
	private String nombreBar;
	private final int NUM_ARTICULOS_MAX;
	private Articulo[] elementos;
	private int numElementos;
	
	public Carta(String nombreBar, int numArticulos) {
		NUM_ARTICULOS_MAX = numArticulos;
		elementos = new Articulo[NUM_ARTICULOS_MAX];
		this.numElementos = 0;
	}
	
	public void addElemento(Articulo a) {
		elementos[numElementos] = a;
		numElementos++;
	}
	
	public void delElemento(int posicion) {
		for(int i=posicion; i<this.numElementos; i++) {
			elementos[i-1] = elementos[i];
		}
		this.numElementos --;
	}
	
	public String mostrarCarta() {
		StringBuilder carta = new StringBuilder();
		for(int i=0; i<this.numElementos; i++) {
			carta.append(i+1 + ".- " + elementos[i].toString());
		}
		return carta.toString();
	}
	
	public String mostrarCartaAlfabetico() {
		Arrays.sort(elementos);
		return mostrarCarta();
	}
	
	public void ordenarCarta(int posElemento, int posDeseada) throws CartaException {
		Articulo a = elementos[posElemento];
		if(posElemento<posDeseada) {
			for(int i=posElemento; i<this.numElementos; i++) {
				if(i<posDeseada-1) {
					elementos[i-1] = elementos[i];
				}else if(i==posDeseada-1) {
					elementos[i]= a;
				}
			}
		}else if(posElemento>posDeseada){
			Articulo b = elementos[posDeseada];
			for(int i=posDeseada-1; i<this.numElementos; i++) {
				if(i==posDeseada-1) {
					elementos[i+1] = elementos[i];
					elementos[i]= a;
				}else if(i>posDeseada-1 && i<posElemento) {
					elementos[i+1] = elementos[i];
				}
			}
		}else {
			throw new CartaException("La posición del elemento y la posición deseada son la misma");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreBar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return Objects.equals(nombreBar, other.nombreBar);
	}

	@Override
	public String toString() {
		return "La carta de " + nombreBar + "tiene " + numElementos + " elementos";
	}
	
}
