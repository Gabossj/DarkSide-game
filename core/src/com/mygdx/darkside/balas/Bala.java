package com.mygdx.darkside.balas;

import com.mygdx.darkside.personajes.Personaje;
import com.mygdx.darkside.utilidades.Imagen;
import com.mygdx.darkside.utilidades.Recursos;

public class Bala {
	
	//private static Bala bala;
	
	
	private float xSpeed;
	private float ySpeed;
	private boolean destruido = false;
	private Imagen sprBala;
	private boolean direccionBala; // true -> derecha; false -> izquierda

	public Bala(float x, float y, boolean sentido) {
		sprBala = new Imagen("Balas/bala.png");
		this.xSpeed = 20;
		this.ySpeed = 0;
		sprBala.setSize(120, 30);
		sprBala.setPosition(x, y);
		if(!sentido) sprBala.rotarImagen(true);
		this.direccionBala = sentido;
	}
	
	/*
	private Bala(float x, float y, boolean sentido) {
		sprBala = new Imagen("Balas/bala.png");
		this.xSpeed = 20;
		this.ySpeed = 0;
		sprBala.setSize(120, 30);
		sprBala.setPosition(x, y);
		if(!sentido) sprBala.rotarImagen(true);
		this.direccionBala = sentido;
	}
	
	public synchronized static Bala getBala(float x, float y, boolean sentido) {
		if(bala==null) {
			bala = new Bala(x,y,sentido);
		}
		
		return bala;
	}*/
	
	
	

	// para cuando se sale de la pantalla, desaparece
	public void moverBala() {

		// Bala a la derecha
		if (direccionBala) {
			sprBala.setPosition(sprBala.getX() + xSpeed, sprBala.getY());
			if (sprBala.getX() < 0 || sprBala.getX() + sprBala.getAncho() > Recursos.anchoPantalla) {
				this.destruido = true;
			}

			if (sprBala.getY() < 0 || sprBala.getY() + sprBala.getAlto() > Recursos.altoPantalla) {
				this.destruido = true;
			}
		} // Bala a la izquierda
		else if (!direccionBala){
			sprBala.setPosition(sprBala.getX() - xSpeed, sprBala.getY());
			if (sprBala.getX() < 0 || sprBala.getX() + sprBala.getAncho() > Recursos.anchoPantalla) {
				this.destruido = true;
			}

			if (sprBala.getY() < 0 || sprBala.getY() + sprBala.getAlto() > Recursos.altoPantalla) {
				this.destruido = true;
			}
		}

		// Bala a la izquierda

	}

	public void dibujar() {
		sprBala.dibujarImagen();
	}

	public boolean comprobarColision(Personaje pj2) {
		if (sprBala.getBoundingRectangle().overlaps(pj2.getSprite().getArea())) { // Se destruyen ambos
			this.destruido = true;
			return true;
		}
		return false;
	}

	public boolean seDestruyo() {
		return this.destruido;
	}

}