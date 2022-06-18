/*
 * Enumerado que almacena el tipo de elementos que nos podemos encontrar en el tablero.
 * Se define un tipo, un símbolo y un fichero
 */
package elementos;

import logicaJuego.Constantes;

public enum ElementType {
	
	ROCA(Constantes.ROCA,'R',"roca.png"),
	DINERO(Constantes.DINERO,'D',"dinero.png"),
	GEMA(Constantes.GEMA,'Y',"gema.png"),
	POCION(Constantes.POCION,'P',"pocion.png"),
	ELFO(Constantes.ELFO,'E',"elfo.png"),
	GUERRERO(Constantes.GUERRERO,'G',"guerrero.png"),
	MAGO(Constantes.MAGO,'M',"mago.png"),
	OGRO(Constantes.OGRO,'O',"ogro.png");
	
	private int type;
	private char symbol;
	private String image;
	
	
	private ElementType(int type, char symbol, String image) {
		this.type = type;
		this.symbol = symbol;
		this.image = image;
	}

	public int getType() {
		return type;
	}

	public char getSymbol() {
		return symbol;
	}

	public String getImage() {
		return image;
	}
	
	
	
	

}
