package ej1;

public class MainGenerico {

	public static void main(String[] args) throws EquipoException {
		
		EquipoGenerico<Integer> a = new EquipoGenerico<>("A");
		EquipoGenerico<Alumno> b = new EquipoGenerico<>("B");
		
		Integer pepe = 1;
		Integer paco = 2;
		Integer paula = 3;
		Integer pablo = 4;
		Alumno pedro = new Alumno("pedro","5");
		Alumno pol = new Alumno("pol","6");
		//añadir
		b.addObjeto(pedro);
		try {
			b.addObjeto(pedro);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		System.out.println(b.mostrarObjetos());	
		//comprobar si tiene un objeto
		System.out.println(b.objetoPertenece(pedro));
		System.out.println(b.objetoPertenece(pol));
		//borrar
		try {
			b.delObjeto(pol);	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		b.delObjeto(pedro);
		System.out.println(b.mostrarObjetos());	
		
		//no van a funcionar con Objetos de diferentes clases
		//unir equipos
		EquipoGenerico<Integer> c = new EquipoGenerico<>("C");
		a.addObjeto(pepe);
		a.addObjeto(paco);
		c.addObjeto(paula);
		c.addObjeto(pablo);
		EquipoGenerico<Integer> d = a.unirEquipos(c);
		System.out.println(d.getNombre());
		System.out.println(d.mostrarObjetos());
		//interseccion equipos
		a.addObjeto(paula);
		EquipoGenerico<Integer> e = a.interseccionEquipos(c);
		System.out.println(e.getNombre());
		System.out.println(e.mostrarObjetos());
	}

}
