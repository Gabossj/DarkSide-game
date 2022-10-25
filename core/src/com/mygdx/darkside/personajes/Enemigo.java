package com.mygdx.darkside.personajes;

public class Enemigo implements Personaje{
	private int vida = 5000; private int ataque = 10;
	@Override
	public int setVida() {
		// TODO Auto-generated method stub
		return vida;
	}

	@Override
	public int setAtaque() {
		// TODO Auto-generated method stub
		return ataque;
	}

	@Override
	public void mostrarDatos() {
		// TODO Auto-generated method stub
		System.out.println("Vida : "+vida + "\n Ataque : "+ataque);
	}

}
