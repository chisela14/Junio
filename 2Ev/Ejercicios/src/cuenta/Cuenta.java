package cuenta;

import java.util.Objects;

public class Cuenta {

	private double saldo;
	
	public Cuenta (double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void hacerReintegro (double dinero) {
		saldo = saldo - dinero;
	}
	public void hacerIngreso (double dinero) {
		saldo = saldo + dinero;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(saldo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return saldo == other.saldo;
	}
	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + "]";
	}
}
