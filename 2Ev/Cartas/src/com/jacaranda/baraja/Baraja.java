package com.jacaranda.baraja;

import java.util.Arrays;

public abstract class Baraja implements Repartible{
	protected int numCartas;
	private int siguiente;
	protected Carta[] cartas;
	private final int PALOS = 4;
	
	public Baraja(int numCartas) throws BarajaException {
		this.numCartas = numCartas;
		this.siguiente = 0;
		this.cartas = new Carta[numCartas];
		barajar();
	}
	
	public void barajar() throws BarajaException{
		if(this.numCartas%PALOS !=0) {
			throw new BarajaException("El numero de cartas no es divisible entre el numero de palos");
		}else {
			int cartasGeneradas = 0;
			while (cartasGeneradas < this.numCartas) {
				//genero un carta
				int numero = generaNumero();
				String palo = generaPalo();
				Carta c = new Carta(numero,palo);
				//compruebo la lista de cartas
				boolean encontrado = false;
				for (int i=0; i<cartasGeneradas && encontrado == false; i++) {
					if (c.equals(cartas[i])){
						encontrado = true;
					}
				}
				//si no la encuentro la añado
				if (encontrado == false) {
					cartas [cartasGeneradas++] = c;
				}
			}
			
		}
		
	}
	
	protected abstract String generaPalo();
	
	
	private int generaNumero() {
		
	}

	@Override
	public String toString() {
		return "Baraja [numCartas=" + numCartas + ", cartas=" + Arrays.toString(cartas) + "]";
	}
	
	public Carta getSiguiente() {
		
	}
	
}
