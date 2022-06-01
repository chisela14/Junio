package persona;

public class Persona {
	private String nombre;
	private int edad;
	private String dni;
	private Password password;
	private char sexo;
	private double peso;
	private double altura;
	
	public Persona() {
		super();
		this.nombre = "";
		this.edad = 0;//no sé si puedo poner valores numéricos vacíos así que lo pongo a 0
		this.dni = generarDni();
		this.password = new Password();
		this.sexo = 'M';
		this.peso = 0;
		this.altura = 0;
	}
	
	public Persona(String nombre, int edad, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.dni = generarDni();
		this.password = new Password();
		this.peso = 0;
		this.altura = 0;
	}

	public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.password = new Password();
	}


	public String generarDni() {
		
	}
	
}
