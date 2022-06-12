package cartaBar;

public class Bebida extends Articulo {
	
	private boolean alcoholica;
	private String tamanno;
	
	public Bebida(double precio, String nombre, boolean alcoholica, int tamanno) {
		super(precio, nombre);
		this.alcoholica = alcoholica;
		setTamanno(tamanno);
	}
	
	
	public boolean isAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(boolean alcoholica) {
		this.alcoholica = alcoholica;
	}

	public String getTamanno() {
		return tamanno;
	}

	private void setTamanno(int capacidad) {
		if(capacidad==200) {
			this.tamanno = "Copa";
		}else if(capacidad==500) {
			this.tamanno = "Botella";
		}else {
			this.tamanno = null;
		}
	}


	@Override
	protected TipoArticulo clasificarTipo() {
		TipoArticulo tipo = TipoArticulo.DELICATESSEN;
		if(this.precio<5) {
			tipo = TipoArticulo.ECONOMICO;
		}
		return tipo;
	}


	@Override
	public String toString() {
		return "Bebida [alcoholica=" + alcoholica + ", tamanno=" + tamanno + ", precio=" + precio + ", nombre=" + nombre
				+ ", CODIGO=" + CODIGO + ", tipo=" + tipo + "]";
	}
	
}
