
public class Ejercicios {

	public static void main(String[] args) {
		//1
		System.out.println("Ejercicio 1");
		System.out.println(charactersInString("python",'o'));
		System.out.println(charactersInString("java",'a'));
		System.out.println(charactersInString("java",'o'));
		//2
		System.out.println("Ejercicio 2");
		System.out.println(lowCaseInString("ProgramACiON"));
		//3
		System.out.println("Ejercicio 3");
		System.out.println(upperCaseInString("ProgramACiON"));
		//4
		System.out.println("Ejercicio 4");
		System.out.println(numberInString("a5bhj34"));
		//5
		System.out.println("Ejercicio 5");
		System.out.println(palindrome("anilina"));
		System.out.println(palindrome("el abad le dio arroz al zorro"));
		//6
		System.out.println("Ejercicio 6");
		System.out.println(encontrarPalabra("shybaoxlna","hola"));
		System.out.println(encontrarPalabra("shybaoxlna","holm"));
		//7
		System.out.println("Ejercicio 7");
		System.out.println(cambiarPalabra("El perro bonito", "perro", "armario"));
		System.out.println(cambiarPalabra("El pez bonito", "perro", "gato"));
		//8
		System.out.println("Ejercicio 8");
		System.out.println(contarVocales("Abaco"));
		//9
		System.out.println("Ejercicio 9");
		System.out.println(consonantesInicio("curso de programacion"));
		//10
		System.out.println("Ejercicio 10");
		System.out.println(numPalabras("He estudiado mucho"));
		System.out.println(numPalabras(" He estudiado  mucho "));
		System.out.println(numPalabras("  He  estudiado   mucho  "));
		
	}
		
	/*
	1. Design a function called charactersInString that has a character string and a character as
	input parameters and returns how many times that character appears in the string. It should
	do if the string and character are lower case or upper case characters.
	 */
	public static int charactersInString(String cadena, Character caracter) {
		int resultado = 0;
		for (int i = 0; i <cadena.length (); i ++) {
			if (cadena.charAt(i)== caracter) {
				resultado ++;
			}
		}
		return resultado;
	}
	/*
	2. Design a function called lowCaseInString that has a string of characters as parameter, the
	method should return how many of those characters are low case letters.
	*/
	public static int lowCaseInString(String cadena) {
		int resultado = 0;
		for (int i = 0; i <cadena.length (); i ++) {
			char caracter = cadena.charAt(i);
			if (Character.isLowerCase(caracter)) {
				resultado++;
			}
		}
		return resultado;
	}
	/*
	3. Design a function called upperCaseInString that has a string of characters as parameter, the
	method should return how many of those characters are upper case letters.
	*/
	public static int upperCaseInString(String cadena) {
		int resultado = 0;
		for (int i = 0; i <cadena.length (); i ++) {
			char caracter = cadena.charAt(i);
			if (Character.isUpperCase(caracter)) {
				resultado++;
			}
		}
		return resultado;
	}
	/*
	4. Design a function called numberInString that has a string of characters as parameter, the
	method should return how many of those characters are numbers.
	*/
	public static int numberInString(String cadena) {
		int resultado = 0;
		for (int i = 0; i <cadena.length (); i ++) {
			char caracter = cadena.charAt(i);
			if (caracter >= 48 && caracter <=57) {
				resultado++;
			}
		}
		return resultado;
	}
	/*
	5. Design a function called palindrome that has a string of characters as parameter, and return
	true if it is a palindrome or false in other case. A word is a palindrome, if it is reads the
	same from left to right as from right to left, ignoring whites,. For example: "anilina" or "el
	abad le dio arroz al zorro" To simplify the problem, you can assume that simple characters
	are used, that is, without tildes or diresis.
	*/
	public static boolean palindrome(String cadena) {
		boolean resultado;
		//quitar espacios
		cadena = cadena.replace(" ", "");
		//cadena al reves
		String cadenaReves = invertirCadena(cadena);
		if (cadena.equals(cadenaReves)) {
			resultado = true;
		}
		else {
			resultado = false;
		}
		
		return resultado;
	}
	public static String invertirCadena(String cadena) {
		String resultado = "";
		for (int i=cadena.length()-1; i>=0; i--) {
			resultado = resultado + cadena.charAt(i);
		}
		return resultado;
	}
	/*
	6. Realizar una función que busque una palabra escondida dentro de un texto. Por ejemplo, si
	la cadena es “shybaoxlna” y la palabra que queremos buscar es “hola”, entonces si se
	encontrará y deberá devolver True, en caso contrario deberá devolver False.
	*/
	public static boolean encontrarPalabra(String cadena, String palabra) {
		boolean encontrado = true;
		int contador = 0;
		while (encontrado == true && contador != palabra.length()) {
			if (cadena.indexOf(palabra.charAt(contador))== -1) {
				encontrado = false;
			}
			contador ++;
		}
		return encontrado;
	}
	
	/*
	7. Diseñar una función que reciba como parámetro tres cadenas, la primera será una frase y
	deberá buscar si existe la palabra que recibe como segundo parámetro y reemplazarla por la
	tercera.
	*/   		
	public static String cambiarPalabra(String frase, String palabra, String reemplazar) {
		String resultado;
		//comprobar que existe la palabra
		int posPalabra = frase.indexOf(palabra);
		//si se encuentra la palabra se creará una nueva cadena
		if (posPalabra != -1) {
			resultado = "";
			//contador valor de la palabra a reemplazar(else if)
			int valorReemplazar = 0;
			//diferencia de longitud entre la palabray el reemplazo
			int diferencia = Math.abs(palabra.length() - reemplazar.length());
			for (int i=0; i<frase.length()+diferencia; i++) {
				//añadir la frase a la nueva cadena hasta la posicion en la que se encuentra la palabra
				if (i<posPalabra) {
					resultado = resultado + frase.charAt(i);
				}
				//en la posicion en la que se encuentra la palabra se añade el reemplazo
				else if (i>= posPalabra && i< (posPalabra+reemplazar.length())) {
					resultado = resultado + reemplazar.charAt(valorReemplazar);
					valorReemplazar ++;
				}
				//después del reemplazo se añade la frase
				else {
					resultado = resultado + frase.charAt(i-diferencia);
				}
			}
		}else {
			resultado = "No se ha podido reemplazar, la palabra no está en la frase.";
		}
		return resultado;
	}
	/*
	8. Diseñar una función que determine la cantidad de vocales diferentes, que tiene una palabra
	o frase introducida por teclado. Por ejemplo, la cadena “Abaco”, devolvería 2.
	*/
	public static int contarVocales(String cadena) {
		int resultado = 0;
		cadena = cadena.toLowerCase();
		String vocales = "aeiou";
		for(int i=0; i<cadena.length(); i++) {
			//si i es una vocal sube el contador y se elimina la vocal del string
			if (vocales.indexOf(cadena.charAt(i))!=-1) {
				resultado ++;
				String vocal = String.valueOf(cadena.charAt(i));
				vocales = vocales.replace(vocal,"");
			}
		}
		return resultado;
	}
	/*
	9. Crear una función que, tomando una cadena de texto como entrada, construya y devuelva
	otra cadena formada de la siguiente manera: el método debe colocar todas las consonantes
	al principio y todas las vocales al final de la misma, eliminando los blancos.
	Por ejemplo, pasándole la cadena "curso de programacion", una posible solución sería
	"crsdprgrmcnuoeoaaio".
	*/
	public static String consonantesInicio(String cadena) {
		String resultado = "";
		//quitar espacios
		cadena = cadena.replace(" ", "");
		cadena = cadena.toLowerCase();
		for (int i=0; i<cadena.length(); i++) {
			char letra = cadena.charAt(i);
			if(esVocal(letra)==true) {
				resultado = resultado + letra;
			}else {
				resultado = letra + resultado;
			}
		}
		return resultado;
	}
	public static boolean esVocal(char letra) {
		boolean resultado;
		String vocales = "aeiou";
		if (vocales.indexOf(letra)!=-1) {
			resultado = true;
		}else {
			resultado = false;
		}
		return resultado;
	}
	/*
	10. Escribir una función que, devuelva el número de palabras que hay en una cadena que recibe
	como parámetro. Ten en cuenta que entre dos palabras puede haber más de un blanco.
	También al principio y al final de la frase puede haber blancos redundantes.
	Por ejemplo, si la cadena es “He estudiado mucho”, debe devolver 3.
	*/
	public static int numPalabras(String cadena) {
		int resultado = 0;
		String palabra = "";
		for (int i=0;i<cadena.length();i++) {
			//compruebo si el caracter es un espacio o no
			if(cadena.charAt(i)== ' ') {
				//si la palabra no esta vacia sumo y reseteo
				if (palabra.isEmpty()==false) {
					resultado ++;
					palabra = "";
				}
			}else {
				//si el caracter no es un espacio empiezo una palabra
				palabra = palabra + cadena.charAt(i);
			}
		}
		if (cadena.charAt(cadena.length()-1)!= ' ') {
			resultado ++;
		}
		return resultado;
	}
}
