package ej1;

public class Main {
	
	public static void main(String[] args) throws EquipoException {
		
		Equipo a = new Equipo("A");
		Equipo b = new Equipo("B");
		
		Alumno pepe = new Alumno("Pepe","1");
		Alumno paco = new Alumno("Paco","2");
		Alumno paula = new Alumno("Paula","3");
		Alumno pablo = new Alumno("Pablo","4");
		//añadir
		a.addAlumno(pepe);
	
		try {
			a.addAlumno(pepe);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		System.out.println(a.mostrarAlumnos());	
		System.out.println("_______________________");
		//comprobar si tiene un alumno
		System.out.println(a.alumnoPertenece(pepe));
		System.out.println(a.alumnoPertenece(paula));
		//borrar
		try {
			a.delAlumno(pablo);	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		a.delAlumno(pepe);
		System.out.println(a.mostrarAlumnos());	
		//unir equipos
		a.addAlumno(pepe);
		a.addAlumno(paco);
		b.addAlumno(paula);
		b.addAlumno(pablo);
		Equipo c = a.unirEquipos(b);
		System.out.println(c.getNombre());
		System.out.println(c.mostrarAlumnos());
		//interseccion equipos
		a.addAlumno(paula);
		Equipo d = a.interseccionEquipos(b);
		System.out.println(d.getNombre());
		System.out.println(d.mostrarAlumnos());
	}
	
}
