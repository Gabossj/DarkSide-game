package com.mygdx.darkside.balas;

import com.mygdx.darkside.utilidades.Imagen;
import com.mygdx.darkside.utilidades.Recursos;

public class Bala {
	private float xSpeed;
	private float ySpeed;
	private boolean destruido = false;
	private Imagen sprBala;

	public Bala(float x, float y) {
		sprBala = new Imagen("Balas/bala.png");
		this.xSpeed = 20;
		this.ySpeed = 0;
		sprBala.setSize(120,30);
		sprBala.setPosition(x, y);
	}

	// para cuando se sale de la pantalla, desaparece
	public void moverBala() {
		sprBala.setPosition(sprBala.getX() + xSpeed, sprBala.getY() + ySpeed);
		
		if (sprBala.getX() < 0 || sprBala.getX() + sprBala.getAncho() > Recursos.anchoPantalla) {
			this.destruido = true;
		}
		
		if (sprBala.getY() < 0 || sprBala.getY() + sprBala.getAlto() > Recursos.altoPantalla) {
			this.destruido = true;
		}

	}

	public void dibujar() {
		sprBala.dibujarImagen();
	}

	/*
	 * public boolean checkCollision(Ball2 b2) {
	 * if(spr.getBoundingRectangle().overlaps(b2.getArea())){ // Se destruyen ambos
	 * this.destroyed = true; return true;
	 * 
	 * } return false; }
	 * 
	 * 
	 */
	
	public boolean seDestruyo() {
		return this.destruido;
	}

}
