package com.jacaranda.main;

import java.time.LocalDateTime;

import com.jacaranda.bloc.Bloc;
import com.jacaranda.bloc.BlocException;
import com.jacaranda.notas.Nota;
import com.jacaranda.notas.NotaAlarma;
import com.jacaranda.notas.NotaAlarmaException;

public class Main {

	public static void main(String[] args) throws NotaAlarmaException, BlocException {
		//Crear y probar un bloc
		Bloc b1 = new Bloc("uno");
			//crear una serie de notas para el bloc
			Nota n1 = new Nota("hola");
			Nota n2 = new Nota("hola");
			Nota n3 = new Nota("hol");
			NotaAlarma na1 = new NotaAlarma("alarma",LocalDateTime.now().plusHours(1),true);//texto, fecha alarma, activado
			NotaAlarma na2 = new NotaAlarma("alarma2",LocalDateTime.now().plusHours(1),10);//texto, fecha alarma, minutos repetir
			
			//metodos bloc
			b1.annadirNota(n1);
			b1.annadirNota(n2);
			System.out.println(b1.getNotas());
			System.out.println(b1.getNota(0));
			System.out.println(b1.getNumNotas());
			b1.eliminarNota(0);
			System.out.println(b1.getNumNotas());
			System.out.println(b1.getNotas());
	}

}
