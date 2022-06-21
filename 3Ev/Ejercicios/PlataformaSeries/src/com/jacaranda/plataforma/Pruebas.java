package com.jacaranda.plataforma;

public class Pruebas {

	public static void main(String[] args) throws PlataformaException, SerieException {
		try {
			//DRAMA, COMEDIA, INTRIGA, CIENCIAFICCION;
			Plataforma netflox = new Plataforma("netflox");
			netflox.addPeliSerie(1, "atlantis", "cienciaficcion", 1999, 10000, 92);
			netflox.addPeliSerie(2, "friends", "comedia", 1998, 20000, 1);
			//netflox.addPeliSerie(3, "friends", "comedia", 1998, 20000, 50);opcion mal
			//netflox.addPeliSerie(2, "friends", "accion", 1998, 20000, 50);tema mal
			System.out.println(netflox.listarPelisSeries());//año y luego nombre
			
			netflox.setTema("friends", "drama");
			netflox.setDuracion("atlantis", 86);
			System.out.println(netflox.listarPorNombre());//nombre
			netflox.addEpisodio("friends", "piloto", 1);
			//netflox.addEpisodio("friends", "prueba", 3);//ep muy alto
			//netflox.addEpisodio("friends", "piloto", 1);//existe
			//netflox.addEpisodio("friends", "prueba", 2);//max capitulos
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
