package ej3;

import java.time.LocalDateTime;

public class Mensaje implements Comparable<Mensaje> {
	private String texto;
	private Persona remitente;
	private LocalDateTime fechaHora;
	
	public Mensaje(String texto, Persona remitente) {
		this.texto = texto;
		this.remitente = remitente;
		this.fechaHora = LocalDateTime.now();
	}
	
	public String getTexto() {
		return texto;
	}

	public Persona getRemitente() {
		return remitente;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	public String fechaHoraString() {
		StringBuilder salida = new StringBuilder();
		salida.append(String.valueOf(fechaHora.getDayOfMonth())+"-");
		salida.append(String.valueOf(fechaHora.getMonthValue())+"-");
		salida.append(String.valueOf(fechaHora.getYear())+" ");
		salida.append(String.valueOf(fechaHora.getHour())+":");
		salida.append(String.valueOf(fechaHora.getMinute()));
		return salida.toString();
	}

	@Override
	public String toString() {
		return "Mensaje [texto=" + texto + ", remitente=" + remitente + ", fechaHora=" + fechaHoraString() + "]";
	}

	//segun su remitente por orden alfabetico
	@Override
	public int compareTo(Mensaje o) {
		return this.remitente.getNombre().compareTo(o.getRemitente().getNombre());
	}
	
	
}
