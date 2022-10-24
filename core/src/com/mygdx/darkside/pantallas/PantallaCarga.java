package com.mygdx.darkside.pantallas;

import com.badlogic.gdx.Screen;
import com.mygdx.darkside.procesado.Imagen;
import com.mygdx.darkside.procesado.Recursos;
import com.mygdx.darkside.procesado.Renderizado;

public class PantallaCarga implements Screen {

	private Imagen fondo;
	
	//inicializamos todo
	@Override 
	public void show() {
		fondo = new Imagen(Recursos.fotoCarga);
		fondo.setSize(1280/2 ,720/2);
	}

	@Override
	public void render(float delta) {
		Renderizado.batch.begin(); 
		fondo.dibujarImagen();		
		Renderizado.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
