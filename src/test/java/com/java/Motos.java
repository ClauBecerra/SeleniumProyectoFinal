package com.java;

public class Motos extends Coche{
	
	private int llantas;
	private String motor;
	private String marca;
	private String modelo;
	private String tipo;
	
	
	public Motos(int llantas, String motor, String marca, String modelo, String tipo) {
		this.llantas = llantas;
		this.motor = motor;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
	}
	
	public Motos() {
		
	}
	
		
	public int getLlantas() {
		return llantas;
	}

	public void setLlantas(int llantas) {
		this.llantas = llantas;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void acelerar() {
		System.out.println("La moto esta acelerando");
	}
	
	public void frenar() {
		System.out.println("La moto esta frenando");
	}
	
	public void encendido() {
		System.out.println("La moto  esta encendida");
	}
	
	public void apagado() {
		System.out.println("La moto  esta apagada");
	}
	
}
