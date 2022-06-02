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
	}
	
	//setfechaAlarma

	@Override
	public void activar() {
		this.activado = true;
		
	}

	@Override
	public void desactivar() {
		this.activado = false;
		
	}
}
