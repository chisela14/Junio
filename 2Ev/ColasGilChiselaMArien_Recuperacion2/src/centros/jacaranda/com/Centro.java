package centros.jacaranda.com;

import java.util.Objects;

public class Centro implements Comparable<Centro> {
	
	private String codigo;
	private String nombre;
	private String direccion;
	private static int codigoSiguiente = 0;
	
	public Centro(String codigo, String nombre, String direccion) throws CentroException {
		this.codigo = codigo;
		comprobarCodigo();
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Centro(String nombre, String direccion) {
		setCodigo();
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	private void comprobarCodigo() throws CentroException {
		String[] inicios = {"04","11","14","18","21","23","29","41"};
		//la longitud debe ser de 8 digitos
		if(this.codigo.length()!=8) {
			throw new CentroException("El código debe tener obligatoriamente 8 dígitos");
		}else {
			//comprobar que empieza por 04,11,14,18,21,23,29 ó 41
			boolean empieza = false;
			int contadorInicios = 0;
			while(empieza == false && contadorInicios <inicios.length) {
				for(int i=0; i<inicios.length;i++) {
					if(this.codigo.startsWith(inicios[i])) {
						empieza = true;
					}
					contadorInicios++;
				}
			}
			if(empieza == false) {
				throw new CentroException("El código debe empezar por un código postal de provincia (04,11,14,18,21,23,29 ó 41)");
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigo() {
		return codigo;
	}
	
	private void setCodigo() {
		StringBuilder codigo = new StringBuilder(8);
		codigo.append("04"+String.valueOf(codigoSiguiente));
		while(codigo.length()<codigo.capacity()) {
			codigo.append("0");
		}
		codigoSiguiente ++;
		this.codigo= codigo.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Centro [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	@Override
	public int compareTo(Centro o) {
		int salida = 0;
		if(Integer.parseInt(codigo) > Integer.parseInt(o.getCodigo())) {
			salida = 1;
		}else if (Integer.parseInt(codigo) < Integer.parseInt(o.getCodigo())) {
			salida = -1;
		}
		return salida;
	}
	
}
