package com.mygdx.darkside.balas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.darkside.personajes.Personaje;
import com.mygdx.darkside.utilidades.Imagen;
import com.mygdx.darkside.utilidades.Recursos;

public class Bala {
	private float xSpeed;
	private float ySpeed;
	private boolean destruido = false;
	private Imagen sprBala;
	private boolean direccionBala;// true -> derecha; false -> izquierda
	private Sound sonidoBala;
	
	public Bala(float x, float y, boolean sentido) {
		sprBala = new Imagen("Balas/bala.png");
		this.xSpeed = 20;
		this.ySpeed = 0;
		this.sonidoBala= Gdx.audio.newSound(Gdx.files.internal("Balas/flaunch.wav"));
		sprBala.setSize(70, 30);
		sprBala.setPosition(x, y);
		if(!sentido) sprBala.rotarImagen();
		this.direccionBala = sentido;
	}

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
	
	public Sound getSonidoBala() {
		return sonidoBala;
	}

}
