package cartaBar;

import java.util.Objects;

public abstract class Articulo implements Comparable<Articulo> {
	protected double precio;
	protected String nombre;
	protected final int CODIGO;
	protected static int codSiguiente = 0;
	protected TipoArticulo tipo;
	
	protected Articulo(double precio, String nombre) {
		this.precio = precio;
		this.nombre = nombre;
		this.CODIGO = codSiguiente;
		codSiguiente++;
		this.tipo = clasificarTipo();
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCODIGO() {
		return CODIGO;
	}

	public TipoArticulo getTipo() {
		return tipo;
	}
	
	protected abstract TipoArticulo clasificarTipo();

	
	@Override
	public int hashCode() {
		return Objects.hash(CODIGO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return CODIGO == other.CODIGO;
	}

	@Override
	public String toString() {
		return "Articulo [precio=" + precio + ", nombre=" + nombre + ", CODIGO=" + CODIGO + ", tipo=" + tipo + "]";
	}
	
	@Override
	public int compareTo(Articulo o) {
		return this.nombre.compareTo(o.getNombre());
	}
	
	
}
