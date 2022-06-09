package rectangulo;

import java.util.Objects;

public class Rectangulo {

	private double longitud;
	private double ancho;
	
	public Rectangulo (){
		this.longitud = 1;
		this.ancho = 1;
	}
	
	public double calcularPerimetro () {
		double resultado;
		resultado = 2*this.longitud + 2*this.ancho;
		return resultado;
	}
	
	public double calcularArea () {
		double resultado;
		resultado = this.longitud*this.ancho;
		return resultado;
	}
	
	public double getLongitud() {
		return longitud;
	}

	public boolean setLongitud(double longitud) {
		boolean posible = false;
		if (longitud > 0 && longitud < 20) {
			posible = true;
			this.longitud = longitud;
		}
		return posible;
	}
	
	public double getAncho() {
		return ancho;
	}

	public boolean setAncho(double ancho) {
		boolean posible = false;
		if (ancho > 0 && ancho < 20) {
			posible = true;
			this.ancho = ancho;
		}
		return posible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ancho, longitud);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		return Double.doubleToLongBits(ancho) == Double.doubleToLongBits(other.ancho)
				&& Double.doubleToLongBits(longitud) == Double.doubleToLongBits(other.longitud);
	}

	@Override
	public String toString() {
		return "Rectangulo [longitud=" + longitud + ", ancho=" + ancho + "]";
	}
	

}
