package com.uce.edu.demo.tarea35.hilos;

public class MainTareaParalelo {

	public static void main(String[] args) {

		Jugador j1 = new Jugador("Ariel M.", "just5ebas");
		Jugador j2 = new Jugador("Diego M.", "dimal316");
		Jugador j3 = new Jugador("Carlos V.", "theCarloxV");
		Jugador j4 = new Jugador("Aleiza T.", "majinomaha");
		Jugador j5 = new Jugador("Javier D.", "VIJAXER");

		Consola c1 = new Consola(j1);
		c1.start();

		Consola c2 = new Consola(j2);
		c2.start();

		Consola c3 = new Consola(j3);
		c3.start();
		
		Consola c4 = new Consola(j4);
		c4.start();
		
		Consola c5 = new Consola(j5);
		c5.start();

	}

}
