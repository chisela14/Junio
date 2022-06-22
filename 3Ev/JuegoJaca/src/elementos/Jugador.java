package elementos;

import logicaJuego.Constantes;

public class Jugador extends Element{
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType player;
	
	public Jugador(PlayerType player) {
		super(ElementType.valueOf(player.name()));
		this.player = player;
		this.dinero = 0;
		this.pociones = 0;
		this.gemas = 0;
	}
	public String getNombre() {
		return this.player.name();
	}
	public int getFuerza() {
		return this.player.getFuerza();
	}
	public int getFuerzaParaLuchar() {
		return (int)(Math.random()*getFuerza()+1);
	}
	public int getMagia() {
		return this.player.getMagia();
	}
	public int getMagiaParaLuchar() {
		return (int)(Math.random()*getMagia()+1);
	}
	public int getVelocidad() {
		return this.player.getVelocidad();
	}
	public int getVelocidadParaLuchar() {
		return (int)(Math.random()*getVelocidad()+1);
	}
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public int getPociones() {
		return pociones;
	}
	public void setPociones(int pociones) {
		this.pociones = pociones;
	}
	public int getGemas() {
		return gemas;
	}
	public void setGemas(int gemas) {
		this.gemas = gemas;
	}
	public PlayerType getPlayer() {
		return player;
	}
	
	public String resumen() {
		return "Jugador: " + player + " Dinero " + dinero + ", Pociones " + pociones + ", Gemas " + gemas;
	}
	//0 empate
	//1 gana jugador, j2 usa pocion
	//2 gana jugador, j2 muere
	//-1 pierde jugador, usa pocion
	//-2 muere jugador
	public int lucha (Jugador j2) {
		int resultado = 0;
		int lucha = this.getFuerzaParaLuchar() - j2.getFuerzaParaLuchar();
		if (lucha > 0) {
			if (j2.getDinero() > 0) {
				dinero = dinero + j2.getDinero();
				j2.setDinero(0);
			}else {
				if (j2.getPociones() > 0) {
					j2.setPociones(j2.getPociones() - 1);
					resultado = 1;
				}else {
					resultado = 2;
				}
			}
		} else {
			if (dinero > 0) {
				j2.setDinero(j2.getDinero() + dinero);
				dinero = 0;
			} else {
				if (pociones > 0) {
					pociones--;
					resultado = -1;
				}else {
					resultado = -2;
				}
			}
		}
		return resultado;
	}
	//0 usa gema
	//1 no gemas rompe
	//-1 no gemas no rompe
	public int encuentraRoca() {
		int resultado = 0;
		if (this.getGemas() > 0) {
			gemas--;
		} else {
			if (getMagiaParaLuchar() > 4) {
				resultado = 1;
			} else {
				resultado = -1;
			}
		}
		return resultado;
	}
	
	public void encuentraDinero() throws JugadorException {
		dinero++;
		if (dinero==Constantes.NUM_DINERO) {
			throw new JugadorException("El jugador a alcanzado la máxima cantidad de dinero, ha ganado.");
		} 
	}

	public void encuentraPocion() throws JugadorException {
		if(pociones==Constantes.NUM_POCIONES) {
			throw new JugadorException("El jugador no puede obtener más pociones.");
		}else {
			pociones++;
		}
	}
	public void encuentraGema() throws JugadorException {
		if(pociones==Constantes.NUM_GEMAS) {
			throw new JugadorException("El jugador no puede obtener más gemas.");
		}else {
			pociones++;
		}
	}
	
}
