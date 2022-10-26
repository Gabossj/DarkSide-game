package com.mygdx.darkside.personajes;

import com.mygdx.darkside.utilidades.Imagen;

public abstract class Personaje {

	protected String nombre;
	protected float vidaMax;
	protected float vida;
	protected float ataque;
	protected Imagen sprite;

	// No tendra constructor, ya que no sera necesario
	// porque asignaremos los valores desde sus clases hijas

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(float vidaMax) {
		this.vidaMax = vidaMax;
	}

	public float getVida() {
		return vida;
	}

	public void setVida(float vida) {
		this.vida = vida;
	}

	public float getAtaque() {
		return ataque;
	}

	public void setAtaque(float ataque) {
		this.ataque = ataque;
	}

	public Imagen getSprite() {
		return sprite;
	}

	public void setSprite(Imagen sprite) {
		this.sprite = sprite;
	}

}
