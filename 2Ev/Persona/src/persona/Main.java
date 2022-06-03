package persona;

public class Main {

	public static void main(String[] args) {
		//Crear personas
		Persona p1 = new Persona();//defecto
		Persona p2 = new Persona("Pablo",23,Sexo.H);//nombre, edad, sexo(enum)
		Persona p3 = new Persona("Myriam",13,"12345678A",Sexo.M,50,1.55);//todos menos password
		//Probar clase Persona
		System.out.println(p1.getDni());
		System.out.println(p2.getDni());
		System.out.println(p3.getDni());
		System.out.println(p1.calcularIMC());
		System.out.println(p2.calcularIMC());
		System.out.println(p3.calcularIMC());
		System.out.println(p1.esMayorDeEdad());
		System.out.println(p2.esMayorDeEdad());
		System.out.println(p3.esMayorDeEdad());
		System.out.println(p1.comprobarSexo(p1.getSexo()));
		System.out.println(p2.comprobarSexo(p2.getSexo()));
		System.out.println(p3.comprobarSexo(p3.getSexo()));
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		//Probar clase Password
		Password passwd1 = p1.getPassword();
		System.out.println(passwd1.toString());
		System.out.println(passwd1.esFuerte());
		Password passwd2 = p2.getPassword();
		System.out.println(passwd2.toString());
		System.out.println(passwd2.esFuerte());
		Password passwd3 = p3.getPassword();
		System.out.println(passwd3.toString());
		System.out.println(passwd3.esFuerte());
		Password fuerte = new Password(11);
		fuerte.setPassword("123456aaAAA");
		System.out.println(fuerte);
		System.out.println(fuerte.esFuerte());
		
		
	}

}
