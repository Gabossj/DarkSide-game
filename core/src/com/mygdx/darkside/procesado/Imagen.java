package com.mygdx.darkside.procesado;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Imagen {

	private Texture t;
	private Sprite s;

	public Imagen(String rutaImagen) {
		t = new Texture(rutaImagen);
		s = new Sprite(t);
	}

	public void dibujarImagen() {
        s.draw(Renderizado.batch);
    }

    public void setTransparencia(float transparencia) {
        s.setAlpha(transparencia); // -> Dimensiona la transparencia
    }

    public void setSize(int ancho, int alto) {
        s.setSize(ancho, alto);
    }

    public void setPosition(int x, int y) {
        s.setPosition(x, y);
    }

}
