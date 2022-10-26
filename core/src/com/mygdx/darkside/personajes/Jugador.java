package com.mygdx.darkside.personajes;

import com.mygdx.darkside.utilidades.Imagen;

public class Jugador extends Personaje{
	
	private Imagen spr = new Imagen("Personajes/jolteon.png");
	
	public Jugador() {
		this.nombre= "Juan";
		this.vidaMax = 300;
		this.vida = this.vidaMax;
		this.ataque = 100;
		spr.setBounds(85,290,133,150);
		this.sprite=spr;
	}

}
