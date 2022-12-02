package com.mygdx.darkside.personajes;

import com.mygdx.darkside.utilidades.Imagen;

import colisiones.Colision;



public class Jugador extends Personaje implements Colision{
	
	private Imagen spr = new Imagen("Personajes/dinoPipa.png");
	private Imagen bullet = new Imagen("Balas/bala.png");
	
	private static int posx;
	private static Jugador jugador;
	
	private Jugador() {
		this.nombre= "Juan";
		this.vidaMax = 10;
		this.vida = this.vidaMax;
		this.ataque = 10;
		spr.setBounds(85,100,133,150);
		this.sprite=spr;
		this.bala=bullet;
		
		this.posx=(0);

	}
	
	public synchronized static Jugador getJugador(){
		if(jugador==null) {
			jugador=new Jugador();
		}
		return jugador;
	}
	
	public boolean comprobarColision(Personaje pj) {
		if (sprite.getBoundingRectangle().overlaps(pj.getSprite().getArea())) { // Se destruyen ambos	
			return true;
		}
		return false;
	}

}

