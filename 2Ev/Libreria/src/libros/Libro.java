package libros;

import java.util.Objects;
import java.time.*;

public class Libro {
	protected String titulo;
	protected String autor;
	protected String editorial;
	protected LocalDate fechaEdicion;
	protected final String ISBN;
	protected final int CODIGO;
	protected static int codigoSiguiente = 1;
	
	public Libro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = generarIsbn();
		this.CODIGO = this.codigoSiguiente;
		this.codigoSiguiente ++;
		this.fechaEdicion = LocalDate.now();
	}

	public Libro(String titulo, String autor, String editorial) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.ISBN = generarIsbn();
		this.CODIGO = this.codigoSiguiente;
		this.codigoSiguiente ++;
		this.fechaEdicion = LocalDate.now();
	}
	
	private String generarIsbn() {
		 String isbn = "";
		 String titulo = this.titulo.replace(" ", "");
		 String autor = this.autor.replace(" ", "");
		//contador para restar a la longitud del autor
		 int contador = 3;
		 for(int i=0; i<8; i++) {
			 if(i<3) {
				 isbn = isbn + titulo.charAt(i);
			 }else if (i==3) {
				 isbn = isbn + titulo.length();
			 }else if (i<7) {
				 isbn = isbn + autor.charAt(autor.length()-contador);
				 contador --;
			 }else {
				 isbn = isbn + autor.length();
			 }
		 }
		 isbn = isbn.toUpperCase();
		 return isbn;
	 }
	
	protected int diasEntreEdiciones(Libro l2) {
		return Math.abs(this.fechaEdicion.getDayOfYear() - l2.getFechaEdicion().getDayOfYear());
	}

	protected String getEditorial() {
		return editorial;
	}

	protected void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	protected LocalDate getFechaEdicion() {
		return fechaEdicion;
	}

	protected void setFechaEdicion(LocalDate fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	protected String getTitulo() {
		return titulo;
	}

	protected String getAutor() {
		return autor;
	}

	protected String getISBN() {
		return ISBN;
	}

	protected int getCODIGO() {
		return CODIGO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(ISBN, other.ISBN);
	}

	@Override
	public String toString() {
		return "Libro: " + titulo + ". Autor: " + autor + ". ISBN: " + ISBN + ". Código: " + CODIGO + ".";
	}
	
	
}
