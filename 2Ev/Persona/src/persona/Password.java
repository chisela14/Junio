package persona;

public class Password {
	private int longitud;
	private String contrasenna;
	
	public Password() {
		super();
		this.longitud = 8;
		this.contrasenna = generarPassword();
	}

	public Password(int longitud) {
		super();
		this.longitud = longitud;
		this.contrasenna = generarPassword();
	}
	
	public String generarPassword() {
		
	}
}
