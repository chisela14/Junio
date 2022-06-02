package libros;

public class LibroDigital extends Libro {
	private double precio;
	private Formato formato;
	
	public LibroDigital(String titulo, String autor, double precio, Formato formato) throws LibroException {
		super(titulo, autor);
		this.precio = precio;
		this.formato = formato;
	}

	public LibroDigital(String titulo, String autor, String editorial, double precio, Formato formato) throws LibroException  {
		super(titulo, autor, editorial);
		this.precio = precio;
		this.formato = formato;
	}
	
	public boolean esMasCaro(LibroPapel libroP) {
		boolean resultado = false;
		if (this.precio>libroP.getPrecio()) {
			resultado = true;
		}
		return resultado;
	}

	public double getPrecio() {
		return precio;
	}

	public Formato getFormato() {
		return formato;
	}
	
	@Override
	public String toString() {
		return "Libro: " + titulo + ". Autor: " + autor + ". ISBN: " + ISBN + ". Codigo: " + CODIGO + ". Precio: " + precio + ". Formato: " + formato + ".";
	}
	
	
	

}
