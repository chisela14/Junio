package com.jacaranda.notas;
import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable{
	
	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO = 5;
	private int minutosRepetir;
	private boolean activado;
	
	public NotaAlarma(String texto, LocalDateTime fechaAlarma, boolean activado) {
		super(texto);
		this.fechaAlarma = fechaAlarma;
		this.activado = activado;
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutosRepetir) {
		super(texto);
		this.fechaAlarma = fechaAlarma;
		this.minutosRepetir = minutosRepetir;
		this.activado = true;
	}
	
	//setfechaAlarma
	public void setFechaAlarma(LocalDateTime fechaAlarma) {
		this.fechaAlarma = fechaAlarma;
	}
	
	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}

	@Override
	public void activar() {
		this.activado = true;
		
	}

	@Override
	public void desactivar() {
		this.activado = false;
		
	}

	public boolean isActivado() {
		return activado;
	}

	@Override
	public String toString() {
		return "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", activado="
				+ activado + "]";
	}
	
	
}
