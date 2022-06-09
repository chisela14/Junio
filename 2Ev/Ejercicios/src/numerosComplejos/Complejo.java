package numerosComplejos;

import java.util.Objects;

public class Complejo {
	
	private double pReal; 
	private double pImaginaria; 
	
	public Complejo(double pReal, double pImaginaria) {
		this.pReal = pReal;
		this.pImaginaria = pImaginaria;
	}
	
	public Complejo suma (Complejo c2) {
		//obtener partes reales y sumarlas
		double r2 = c2.getpReal();
		double sumaReal = this.pReal + r2;
		//obtener partes imaginarias y sumarlas
		double i2 = c2.getpImaginaria();
		double sumaImag = (this.pImaginaria + i2);
		//crear y devolver el numero complejo con los resultados
		Complejo c3 = new Complejo (sumaReal, sumaImag);
		return c3;
	}
	
	public Complejo resta (Complejo c2) {
		//obtener partes reales y sumarlas
		double r2 = c2.getpReal();
		double restaReal = this.pReal - r2;
		//obtener partes imaginarias y sumarlas
		double i2 = c2.getpImaginaria();
		double restaImag = (this.pImaginaria - i2);
		//crear y devolver el numero complejo con los resultados
		Complejo c3 = new Complejo (restaReal, restaImag);
		return c3;
	}

	public double getpReal() {
		return pReal;
	}

	public void setpReal(double pReal) {
		this.pReal = pReal;
	}

	public double getpImaginaria() {
		return pImaginaria;
	}

	public void setpImaginaria(double pImaginaria) {
		this.pImaginaria = pImaginaria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pImaginaria, pReal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		return Double.doubleToLongBits(pImaginaria) == Double.doubleToLongBits(other.pImaginaria)
				&& Double.doubleToLongBits(pReal) == Double.doubleToLongBits(other.pReal);
	}

	@Override
	public String toString() {
		return "Número Complejo: " + pReal + "*" + pImaginaria + "*i";
	}
}
