package com.mygdx.darkside.personajes;

import com.mygdx.darkside.utilidades.Imagen;

public class Enemigo extends Personaje{
	
	private Imagen spr = new Imagen("Personajes/vaporeon.png");
	
	public Enemigo() {
		this.nombre= "Pedro";
		this.vidaMax = 4500;
		this.vida = this.vidaMax;
		this.ataque = 60;
		spr.setBounds(1050,100,133,150);
		this.sprite=spr;
	}

}
