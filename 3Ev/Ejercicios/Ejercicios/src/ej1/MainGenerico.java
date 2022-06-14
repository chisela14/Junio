package ej1;

public class MainGenerico {

	public static void main(String[] args) throws EquipoException {
		
		Equipo a = new Equipo("A");
		Equipo b = new Equipo("B");
		
		//cambiar alumno por integer
		Integer pepe = new Integer(1);
		Integer paco = new Integer(2);
		Integer paula = new Integer(3);
		Integer pablo = new Integer(4);
		//añadir
		a.addAlumno(pepe);
		try {
			a.addAlumno(pepe);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		System.out.println(a.mostrarAlumnos());	
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
