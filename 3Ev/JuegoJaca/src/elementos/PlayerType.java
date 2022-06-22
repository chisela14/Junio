/*
 * Enumerado que almacena el tipo de jugadores que nos podemos encontrar en el tablero.
 * Se define la fuerza, la magia y la velocidad para cada uno de los jugadores
 */
package elementos;

import logicaJuego.Constantes;

public enum PlayerType {
	
	ELFO(Constantes.ELFO_FUERZA, Constantes.ELFO_MAGIA, Constantes.ELFO_VELOCIDAD), 
	GUERRERO(Constantes.GUERRERO_FUERZA, Constantes.GUERRERO_MAGIA, Constantes.GUERRERO_VELOCIDAD), 
	MAGO(Constantes.MAGO_FUERZA, Constantes.MAGO_MAGIA, Constantes.MAGO_VELOCIDAD), 
	OGRO(Constantes.OGRO_FUERZA, Constantes.OGRO_MAGIA, Constantes.OGRO_VELOCIDAD);
	
	private int fuerza;
	private int magia;
	private int velocidad;
	
	private PlayerType(int fuerza, int magia, int velocidad) {
		this.fuerza = fuerza;
		this.magia = magia;
		this.velocidad = velocidad;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getMagia() {
		return magia;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	
	
}
