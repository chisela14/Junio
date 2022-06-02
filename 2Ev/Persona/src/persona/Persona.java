package persona;

import java.util.Objects;
import java.util.Random;

public class Persona {
	private String nombre;
	private int edad;
	private String dni;
	private Password password;
	private Sexo sexo;
	private double peso;
	private double altura;
	private final int LIMITEINFERIOR = 20;
	private final int LIMITESUPERIOR = 20;
	
	public Persona() {
		this.nombre = "";
		this.edad = 0;
		this.dni = generaDni();
		this.password = new Password();
		this.sexo = Sexo.M;
		this.peso = 0;
		this.altura = 0;
	}
	
	public Persona(String nombre, int edad, Sexo sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.dni = generaDni();
		this.password = new Password();
		this.peso = 0;
		this.altura = 0;
	}

	public Persona(String nombre, int edad, String dni, Sexo sexo, double peso, double altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.password = new Password();
	}

	private String generaDni() {
		String dni = "";
		Random r = new Random();
		String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i=0; i<8; i++) {
			int num = r.nextInt(8)+1;
			dni = dni + num;
		}
		int posicion = r.nextInt(26)+1;
		dni = dni + mayus.charAt(posicion);
		return dni;
	}
	
	public int calcularIMC() {
		int resultado;
		double imc;
		//calcular imc
		imc = this.peso/(Math.pow(this.altura,2));
		//calcular resultado
		if (imc<LIMITEINFERIOR) {
			resultado = -1;
		}else if (imc>=LIMITEINFERIOR && imc<=LIMITESUPERIOR) {
			resultado = 0;
		}else {
			resultado = 1;
		}
		return resultado;
	}
	
	public boolean esMayorDeEdad() {
		boolean resultado;
		if(this.edad>17) {
			resultado = true;
		}else {
			resultado = false;
		}
		return resultado;
	}
	
	public boolean comprobarSexo(Sexo sexo) {
		boolean resultado = false;
		if(sexo==this.sexo) {
			resultado = true;
		}
		return resultado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", password=" + password + ", sexo="
				+ sexo + ", peso=" + peso + ", altura=" + altura + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
}
