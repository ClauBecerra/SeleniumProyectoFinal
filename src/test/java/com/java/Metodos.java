package com.java;

public class Metodos {

	public static void main(String[] args) {
		// Metodos en Java = Funcion
		
		int suma1 = 1+1;
		int suma2 = 2+2;
		
		// Caracteristicas de un metodo
		
//		1- Siempre pertenece a una clase;
//		2- no se pueden escribir metodo sobre metodo;
//		3- Un metodo puede regresar cualquier tipo de dato(int, string, double, objecto)
//			si no regresa nada un metodo se le conoce como metodo Void
//		4- Un metodo puede invocar a otro metodo
		
		int sumaTotal = suma(5,2);
		System.out.println(sumaTotal);
		
		// Ejercicio #4
		
		/*
		 * Crear un metodo que imprima la multiplicacion de 3 numeros.
		 *  - Metodo tipo void
		 */
		
		multiplicacionDeTres(2,3,4);

	}
	
	// Metodo
	public static int suma(int x, int y) {
		int total = x+y;
		return total;
	}
	
	public static void sayHello() {
		System.out.println("Hello");
		
	}
	
	public static void multiplicacionDeTres(int x, int y, int z) {
		int total = x*y*z;
		System.out.println("El resultado de multiplicar los tres numeros es: " + total);
		
	}
	
	public static void algo() {
		
	}

}
