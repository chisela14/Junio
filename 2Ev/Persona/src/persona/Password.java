package persona;

import java.util.Random;

public class Password {
	private final int LONGITUD;
	private String contrasenna;
	
	public Password() {
		this.LONGITUD = 8;
		this.contrasenna = generarPassword();
	}

	public Password(int longitud) {
		this.LONGITUD = longitud;
		this.contrasenna = generarPassword();
	}
	
	public String generarPassword() {
		String password = "";
		String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";//61
		Random r = new Random();
		for (int i=0; i<this.LONGITUD; i++) {
			int posicion = r.nextInt(61)+1;
			password = password + alfabeto.charAt(posicion);
		}
		return password;
	}
	
	public boolean esFuerte() {
		int mayus = 0, minus = 0, num = 0;
		boolean resultado;
		for (int i=0; i<this.contrasenna.length(); i++) {
			if (Character.isUpperCase(this.contrasenna.charAt(i))==true) {
				mayus = mayus + 1;
			}else if (Character.isLowerCase(this.contrasenna.charAt(i))==true) {
				minus = minus + 1;
			}else if (Character.isDigit(this.contrasenna.charAt(i))==true) {
				num = num +1;
			}
		}
		if (mayus>2 && minus>1 && num>5) {
			resultado = true;
		}else {
			resultado = false;
		}
		return resultado;
	}

	public int getLongitud() {
		return LONGITUD;
	}

	public String getPassword() {
		return contrasenna;
	}
	
	//genero este para crear una contraseña fuerte para probar el método
	public void setPassword(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	@Override
	public String toString() {
		return "Password [contrasenna=" + contrasenna + "]";
	}
	
	
}
