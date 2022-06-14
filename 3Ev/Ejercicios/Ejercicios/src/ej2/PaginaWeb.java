package ej2;

import java.time.LocalDateTime;
import java.util.Objects;

public class PaginaWeb {
	
	private String url;
	private LocalDateTime fechaHora;
	
	public PaginaWeb(String url) {
		this.url = url;
		this.fechaHora = LocalDateTime.now();
	}

	public String getUrl() {
		return url;
	}
	
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginaWeb other = (PaginaWeb) obj;
		return Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "Página Web: " + url + " Fecha visita: " + fechaHora;
	}

	
	
	
}
