package com.mygdx.darkside.personajes;

import com.mygdx.darkside.utilidades.Imagen;

public class Jugador extends Personaje{
	
	private Imagen spr = new Imagen("Personajes/dinoPipa.png");
	private Imagen bullet = new Imagen("Balas/bala.png");
	
	public Jugador() {
		this.nombre= "Juan";
		this.vidaMax = 300;
		this.vida = this.vidaMax;
		this.ataque = 100;
		spr.setBounds(85,100,133,150);
		this.sprite=spr;
		this.bala=bullet;
		
		this.posx=(0);

	}

}

