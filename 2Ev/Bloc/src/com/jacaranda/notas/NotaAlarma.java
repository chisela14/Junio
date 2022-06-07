package com.jacaranda.notas;
import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable{
	
	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO = 5;
	private int minutosRepetir;
	private boolean activado;
	
	public NotaAlarma(String texto, LocalDateTime fechaAlarma, boolean activado) throws NotaAlarmaException {
		super(texto);
		setFechaAlarma(fechaAlarma);
		this.activado = activado;
		this.minutosRepetir = MINUTOS_REPETIR_POR_DEFECTO;
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutosRepetir) throws NotaAlarmaException {
		super(texto);
		setFechaAlarma(fechaAlarma);
		this.minutosRepetir = minutosRepetir;
		this.activado = true;
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) throws NotaAlarmaException {
		try {
			this.fechaAlarma = fechaAlarma;
		}catch (Exception e) {
			throw new NotaAlarmaException("La fecha y hora introducida no puede ser menor a la fecha y hora actual");
		}
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
