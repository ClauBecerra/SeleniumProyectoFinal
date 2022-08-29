package com.java;

public class Coche {
	
	// Caracteristicas de un objeto
	
	/*
	 * 1- Estado: se representa con instancias de variable
	 * 2- Comportamiento: se representa con metodos
	 * 3- Identidad: permite que los objetos interactuen entre si.
	 */
	
	int llantas;
	int asientos;
	String motor;
	boolean ac;
	String marca;
	String modelo;
	
	// Constructores
	
	/*
	 * 1- Tiene el mismo nombre de la clase
	 * 2- No se hereda
	 * 3- No puede devolver ningun valor
	 * 4- Puede haber mas de un constructor (Sobrecarga de constructores)
	 */
	
	public Coche(int llantas, int asientos, String motor, boolean ac, String marca, String modelo) {
		this.llantas = llantas;
		this.asientos = asientos;
		this.motor = motor;
		this.ac = ac;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Coche() {
		
	}
	
	public Coche(int asientos, String modelo) {
		this.llantas = 4;
		this.asientos = asientos;
		this.motor = "Combustion Interna";
		this.ac = true;
		this.marca = "Nissan";
		this.modelo = modelo;
	}
	
	public void acelerar() {
		System.out.println("El coche esta acelerando");
	}
	
	

	public void frenar() {
		System.out.println("El coche esta frenando");
	}
	
	public void encendido() {
		System.out.println("El coche esta encendido");
	}

}
