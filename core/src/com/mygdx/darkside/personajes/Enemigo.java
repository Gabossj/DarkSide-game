package com.mygdx.darkside.personajes;

import com.mygdx.darkside.utilidades.Imagen;

public class Enemigo extends Personaje{
	
	private Imagen spr = new Imagen("Personajes/vaporeon.png");
	private static Enemigo enemigo;
	
	/*public Enemigo() {
		this.nombre= "Pedro";
		this.vidaMax = 4500;
		this.vida = this.vidaMax;
		this.ataque = 60;
		spr.setBounds(1050,100,133,150);
		this.sprite=spr;
	}*/
	
	private Enemigo() {
		this.nombre= "Pedro";
		this.vidaMax = 4500;
		this.vida = this.vidaMax;
		this.ataque = 60;
		spr.setBounds(1050,100,133,150);
		this.sprite=spr;
		int num = (int)(Math.random()*1000); 
		this.posx=(num);
	}
	
	public synchronized static Enemigo getEnemigo() {
		if(enemigo==null) {
			enemigo=new Enemigo();
			int num = (int)(Math.random()*1000); 
			enemigo.setPosx(num);
		}

		return enemigo;
	}


}
