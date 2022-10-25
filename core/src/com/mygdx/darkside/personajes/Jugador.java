package com.mygdx.darkside.personajes;

public class Jugador implements Personaje{

	private int vida =300;
	private int ataque = 50;
	
	@Override
	public int setVida() {
		return vida;
	}

	@Override
	public int setAtaque() {
		return ataque;
	}

	@Override
	public void mostrarDatos() {
		System.out.println("Vida : "+vida + "\n Ataque : "+ataque);
	}

	

}
