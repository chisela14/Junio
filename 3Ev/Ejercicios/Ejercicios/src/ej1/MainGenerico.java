package ej1;

public class MainGenerico {

	public static void main(String[] args) throws EquipoException {
		
		EquipoGenerico a = new EquipoGenerico("A");
		EquipoGenerico b = new EquipoGenerico("B");
		
		//cambiar alumno por integer
		Integer pepe = new Integer(1);
		Integer paco = new Integer(2);
		Integer paula = new Integer(3);
		Integer pablo = new Integer(4);
		//añadir
		a.addObjeto(pepe);
		try {
			a.addObjeto(pepe);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		System.out.println(a.mostrarObjetos());	
		//comprobar si tiene un alumno
		System.out.println(a.objetoPertenece(pepe));
		System.out.println(a.objetoPertenece(paula));
		//borrar
		try {
			a.delObjeto(pablo);	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		a.delObjeto(pepe);
		System.out.println(a.mostrarObjetos());	
		//unir equipos
		a.addObjeto(pepe);
		a.addObjeto(paco);
		b.addObjeto(paula);
		b.addObjeto(pablo);
		EquipoGenerico c = a.unirEquipos(b);
		System.out.println(c.getNombre());
		System.out.println(c.mostrarObjetos());
		//interseccion equipos
		a.addObjeto(paula);
		EquipoGenerico d = a.interseccionEquipos(b);
		System.out.println(d.getNombre());
		System.out.println(d.mostrarObjetos());
	}

}
