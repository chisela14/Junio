package ej3;

import java.time.LocalDateTime;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(fechaHora, remitente, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(fechaHora, other.fechaHora) && Objects.equals(remitente, other.remitente)
				&& Objects.equals(texto, other.texto);
	}
	
	
}
