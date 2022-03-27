package com.ipartek.formacion.mf0967.uf2216;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeMap;

/**
 * Clase para demostrar la sintaxis b�sica de Java
 * 
 * @author JavierLete
 *
 */
public class Sintaxis {
	/**
	 * M�todo de entrada de la aplicaci�n
	 * 
	 * @param args argumentos recibidos por consola
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String[] args) {
		// Comentario de l�nea

		/*
		 * Comentario multi l�nea
		 */

		// TIPOS PRIMITIVOS
		byte b;
		short s;
		int i = 5;
		long l = 5L;

		float f = 0.3F;
		double d = 0.3;

		char c = '\n'; // 'g'; \n, \t, \r...

		boolean bl = false;

		b = 127;
		System.out.println(b);
		b++;
		System.out.println(b);

//		for(b = 1; b < 300; b++) {
//			System.out.println(b);
//		}

		// TIPOS REFERENCIA

		// Tipos primitivos encapsulados
		Byte be = null;
		Short se = null;
		Integer ie = null;
		Long le = null;

		Float fe = null;
		Double de = null;

		Character ce = null;
		Boolean ble = null;

		// Cadena de texto
		String nombre1 = new String("Javier");
		String nombre2 = new String("Javier");

		System.out.println(nombre1 == nombre2);
		System.out.println(nombre1.equals(nombre2));

		// M�todos de String

		System.out.println("Este es un texto".toUpperCase());

		StringBuffer log = new StringBuffer();

		log.append("l�nea1\n");
		log.append("l�nea2\n");

		String logS = log.toString();

		System.out.println(logS);

		// Conversiones de String a otro tipo
		String texto = "5";
		int enteroPrimitivo = Integer.parseInt(texto);

		// Conversiones de otro tipo a String
		enteroPrimitivo = 5;
		texto = String.valueOf(enteroPrimitivo);

		Integer enteroEncapsulado = 5;
		texto = enteroEncapsulado.toString();

		// Fechas
		// Java 1.0
		Date fecha10 = new Date(); // new Date(2021 - 1900, 11 - 1, 19, 20, 29, 00);
		System.out.println(fecha10.toLocaleString());

		// Java 1.1
		Calendar cal = new GregorianCalendar();
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(formato.format(cal.getTime()));

		// Java 1.8 (java.time)
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println(ldt.format(dtf));

		String fechaTexto = "18-12-2020 17:18:19";
		ldt = LocalDateTime.parse(fechaTexto, dtf);
		System.out.println(ldt);

		// Arrays � Arreglos
		// Conjunto de elementos de tama�o predefinido
		// El objeto de tipo array NUNCA cambia de tama�o una vez establecido
		// Es INMUTABLE (el objeto de array en cuanto a tama�o, no su contenido)
		// Todos los elementos son contiguos
		int tam = 2;
		int[] arr = new int[tam];

		arr[0] = 7;
		arr[1] = 5;
		// arr[2] = 8; //

		// arr.length = 6; //

		for (int indice = 0; indice < arr.length; indice++) {
			System.out.println(arr[indice]);
		}

		for (int dato : arr) {
			System.out.println(dato);
		}

		char[][] tablero = new char[8][8];

		tablero[0][0] = 't';
		tablero[0][1] = 'c';
		tablero[1][0] = 'p';

		tablero[6][0] = 'P';
		tablero[6][1] = 'P';
		tablero[7][0] = 'T';

		for (int x = 0; x < tablero.length; x++) {
			for (int y = 0; y < tablero[x].length; y++) {
				if (tablero[x][y] == '\0') {
					System.out.print('.');
				} else {
					System.out.print(tablero[x][y]);
				}
			}
			System.out.println();
		}

		// Colecciones (mutables)
		// Java 5 <Tipo>
		// Java 8 <>
		// Java 5 for

		ArrayList<Integer> al = new ArrayList<>();

		al.add(5);
		al.add(7);
		al.add(10);

		for (Integer dato : al) {
			System.out.println(dato);
		}

		System.out.println(al.get(1));

		TreeMap<String, String> diccionario = new TreeMap<>();

		diccionario.put("casa", "house");
		diccionario.put("coche", "car");

		System.out.println(diccionario.get("coche"));

		// Operadores
		System.out.println(6 % 4);

		int x = 2;
		System.out.println(1 + x + 10);

		System.out.println(1 <= x & x <= 10);
		System.out.println(1 <= x && x <= 10);

		System.out.println(6 & 3); // 110 & 011 = 010
		System.out.println(6 | 3); // 110 | 011 = 111
		System.out.println(6 ^ 3); // 110 ^ 011 = 101
		System.out.println(~6); // ~00000110 = 11111001

		System.out.println(-40 >>> 3); // 00101000 >> 3 = 00000101
		System.out.println(-40 >> 3); // 00101000 >> 3 = 00000101
		System.out.println(-10 << 3); // 00001010 << 3 = 01010000

		int y, z;
		System.out.println(y = z = 3);

		System.out.println(y++);
		System.out.println(++z);

		int a = 5, mayor;
		b = 20;

		mayor = a > b ? a : b;

		System.out.println(mayor);

		boolean estaEncendido = true;

		System.out.println(estaEncendido ? "Encendido" : "Apagado");

		// Sentencias de control

		if (estaEncendido) {
			System.out.println("Encendido");
		} else {
			System.out.println("Apagado");
		}

		int opcion = 2;

		switch (opcion) {
		case 1:
			System.out.println("Opci�n 1");
			break;
		case 2:
			System.out.println("Opci�n 2");
			break;
		case 3:
			System.out.println("Opci�n 3");
			break;
		default:
			System.out.println("Opci�n desconocida");
		}

		int dias, mes = 2;

		switch (mes) { // Se puede hacer con String en Java >= 7
		case 2:
			dias = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}

		System.out.println("El mes " + mes + " tiene " + dias + " d�as");

		int cont = 0;

		while (cont < 10) {
			System.out.println(++cont);
		}

		cont = 0;

		do {
			System.out.println(++cont);
		} while (cont < 10);

		for (int contador = 1; contador <= 10; contador++) {
			System.out.println(contador);
		}

//		int contador = 1;
//		while(contador <= 10) {
//			System.out.println(contador);
//			contador++;
//		}
	}

}
