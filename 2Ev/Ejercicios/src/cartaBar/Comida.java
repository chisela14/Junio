package cartaBar;

public class Comida extends Articulo {
	
	private boolean gluten;
	private boolean leche;
	private boolean frutosSecos;
	private boolean marisco;
	private String descripcion;

	public Comida(double precio, String nombre, boolean gluten, boolean leche, boolean frutosSecos, boolean marisco,
			String descripcion) {
		super(precio, nombre);
		this.gluten = gluten;
		this.leche = leche;
		this.frutosSecos = frutosSecos;
		this.marisco = marisco;
		this.descripcion = descripcion;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public boolean isLeche() {
		return leche;
	}

	public void setLeche(boolean leche) {
		this.leche = leche;
	}

	public boolean isFrutosSecos() {
		return frutosSecos;
	}

	public void setFrutosSecos(boolean frutosSecos) {
		this.frutosSecos = frutosSecos;
	}

	public boolean isMarisco() {
		return marisco;
	}

	public void setMarisco(boolean marisco) {
		this.marisco = marisco;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	protected TipoArticulo clasificarTipo() {
		TipoArticulo tipo;
		if (this.precio <=2) {
			tipo = TipoArticulo.BARATO;
		}else if (this.precio>2 && this.precio<=5) {
			tipo = TipoArticulo.ECONOMICO;
		}else {
			tipo = TipoArticulo.DELICATESSEN;
		}
		return tipo;
	}


	@Override
	public String toString() {
		return "Comida [gluten=" + gluten + ", leche=" + leche + ", frutosSecos=" + frutosSecos + ", marisco=" + marisco
				+ ", descripcion=" + descripcion + ", precio=" + precio + ", nombre=" + nombre + ", CODIGO=" + CODIGO
				+ ", tipo=" + tipo + "]";
	}

	

	
	
}
