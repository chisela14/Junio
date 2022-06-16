package ej4;

import java.util.Objects;

public class Significado {
	
	private String descripcion;

	public Significado(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Significado other = (Significado) obj;
		return Objects.equals(descripcion, other.descripcion);
	}

}
