package com.mygdx.darkside.personajes;

import com.mygdx.darkside.utilidades.Imagen;

public class Enemigo extends Personaje{
	
	private Imagen spr = new Imagen("Personajes/dinoEnemigo.png");
	
	public Enemigo(int x) {
		this.nombre= "Pedro";
		this.vidaMax = 30;
		this.vida = this.vidaMax;
		this.ataque = 10;
		spr.setBounds(x,100,220,150);
		//x=1050; 
		this.sprite=spr;
	}

}
