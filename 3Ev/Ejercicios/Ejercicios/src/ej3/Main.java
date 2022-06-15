package ej3;

public class Main {

	public static void main(String[] args) throws PersonaException {
		
		Alumno lucia = new Alumno("lucia", "1", 19);
		Alumno nadia = new Alumno("nadia", "2", 17);
		Profesor inma = new Profesor("inma", "3");
		try {//no debe pasar nada
			lucia.enviarMensaje(nadia, "hola");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {//muestra mensaje exception
			nadia.enviarMensaje(lucia, "hola");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {//no deberia pasar nada
			System.out.println(nadia.mostrarBuzon());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {//muestra mensaje exception
			System.out.println(inma.mostrarBuzon());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		inma.enviarMensaje(nadia, "hola2");
		System.out.println(nadia.mostrarBuzonOrdenado());
		try {//no tiene mensajes con esa frase
			nadia.encontrarMensajes("gh");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {//deberia tener mensajes con esa frase
			System.out.println(nadia.encontrarMensajes("ol"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
