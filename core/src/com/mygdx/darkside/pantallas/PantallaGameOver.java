package com.mygdx.darkside.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.mygdx.darkside.utilidades.Imagen;
import com.mygdx.darkside.utilidades.Recursos;
import com.mygdx.darkside.utilidades.Renderizado;

public class PantallaGameOver implements Screen {

	private Imagen background;
	private Imagen marcoPj;
	private Imagen gameOver;

	@Override
	public void show() {
		background = new Imagen("BackGrounds/fondo1.png");
		background.setSize(Recursos.anchoPantalla, Recursos.altoPantalla);
		marcoPj = new Imagen("BackGrounds/marco.png");
		marcoPj.setBounds(30, 550, 150, 150);
		gameOver = new Imagen("BackGrounds/gameover.png");
		gameOver.setBounds(385,150,500,500);

	}

	@Override
	public void render(float delta) {
		Renderizado.limpiarPantalla();

		Renderizado.batch.begin();
		background.dibujarImagen();
		marcoPj.dibujarImagen();
		gameOver.dibujarImagen();
		
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
			Renderizado.game.setScreen(new PantallaJuego());
		}
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
