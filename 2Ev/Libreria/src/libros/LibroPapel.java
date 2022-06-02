package libros;

public class LibroPapel extends Libro {
	private double peso;
	private double precio;
	
	public LibroPapel(String titulo, String autor, double peso, double precio) {
		super(titulo, autor);
		this.peso = peso;
		this.precio = precio;
	}

	public LibroPapel(String titulo, String autor, String editorial, double peso, double precio) {
		super(titulo, autor, editorial);
		this.peso = peso;
		this.precio = precio;
	}
	
	public boolean esMasCaro(LibroDigital libroD) {
		boolean resultado = false;
		if (this.precio>libroD.getPrecio()) {
			resultado = true;
		}
		return resultado;
	}

	public double getPeso() {
		return peso;
	}

	public double getPrecio() {
		return precio;
	}
	
	@Override
	public String toString() {
		return "Autor: " + autor + ". ISBN: " + ISBN + ". Código: " + CODIGO + ". Precio: " + precio + ". Peso: " + peso + ". Libro: " + titulo + ".";
	}
	

}
