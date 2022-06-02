package libros;

public class LibroDigital extends Libro {
	private int precio;
	private String formato;
	
	public LibroDigital(String titulo, String autor, int precio, String formato) throws LibroException {
		super(titulo, autor);
		this.precio = precio;
		this.formato = formato;
	}

	public LibroDigital(String titulo, String autor, String editorial, int precio, String formato) throws LibroException  {
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

	public int getPrecio() {
		return precio;
	}

	public String getFormato() {
		return formato;
	}
	
	@Override
	public String toString() {
		return "Libro: " + titulo + ". Autor: " + autor + ". ISBN: " + ISBN + ". Código: " + CODIGO + ". Precio: " + precio + ". Formato: " + formato + ".";
	}
	
	
	

}
