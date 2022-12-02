package com.mygdx.darkside.utilidades;

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
        s.setAlpha(transparencia);
    }
    
    public void setSize(int ancho, int alto) {
        s.setSize(ancho, alto);
    }

    public void setPosition(float x, float y) {
        s.setPosition(x, y);
    }
    
    public void setBounds(int x, int y, int width, int height) {
    	s.setBounds(x, y, width, height);
    }
    
    public float getX() {
    	return s.getX();
    }
    
    public float getY() {
    	return s.getY();
    }
    
    public void setX(float x) {
    	s.setX(x);
    }
    
    public void setY(float y) {
    	s.setY(y);
    }
    
    public float getAlto() {
    	return s.getHeight();
    }
    
    public float getAncho() {
    	return s.getWidth();
    }
    

}
