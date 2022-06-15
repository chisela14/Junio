package ej4;

import java.util.Objects;

public class Significado {
	
	private String descripcion;

	public Significado(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Significado [descripcion=" + descripcion + "]";
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
