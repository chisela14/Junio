package cartaBar;

import java.util.Arrays;

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
	
	public void ordenarCarta(int posElemento, int posDeseada) {
		
	}
}
