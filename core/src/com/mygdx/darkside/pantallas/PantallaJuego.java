package com.mygdx.darkside.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.darkside.personajes.Enemigo;
import com.mygdx.darkside.personajes.Jugador;
import com.mygdx.darkside.personajes.Personaje;
import com.mygdx.darkside.utilidades.Imagen;
import com.mygdx.darkside.utilidades.Recursos;
import com.mygdx.darkside.utilidades.Renderizado;

public class PantallaJuego implements Screen {

	private Imagen background;
	private Personaje pj, pj2;
	private ShapeRenderer formaJolteon,formaVaporeon;
	
	@Override
	public void show() {
		// Fondo
		background = new Imagen("BackGrounds/background.jpg");
		background.setSize(Recursos.anchoPantalla, Recursos.altoPantalla);
		
		//Rectangulo
		formaJolteon = new ShapeRenderer();
		formaVaporeon = new ShapeRenderer();

		// Personajes
		pj = new Jugador();
		pj2 = new Enemigo();
	}

	@Override
	public void render(float delta) {
		Renderizado.limpiarPantalla();

		Renderizado.batch.begin();
			background.dibujarImagen();
			pj.getSprite().dibujarImagen();
			pj2.getSprite().dibujarImagen();
			
			   //Movimiento en X
			   if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) pj.getSprite().setX(pj.getSprite().getX() - 150 * Gdx.graphics.getDeltaTime());
			   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) pj.getSprite().setX(pj.getSprite().getX() + 150 * Gdx.graphics.getDeltaTime());
			   //Movimiento en Y
			   if(Gdx.input.isKeyPressed(Input.Keys.UP)) pj.getSprite().setY(pj.getSprite().getY() + 150 * Gdx.graphics.getDeltaTime());
			   if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) pj.getSprite().setY(pj.getSprite().getY() - 150 * Gdx.graphics.getDeltaTime());
			   
		Renderizado.batch.end();
		   
		formaJolteon.begin(ShapeType.Line);
			formaJolteon.setColor(Color.YELLOW);
			formaJolteon.rect(pj.getSprite().getX(),pj.getSprite().getY(),pj.getSprite().getAncho(),pj.getSprite().getAlto());		
		formaJolteon.end();
		
		formaVaporeon.begin(ShapeType.Line);
			formaVaporeon.setColor(Color.YELLOW);
			formaVaporeon.rect(pj2.getSprite().getX(),pj2.getSprite().getY(),pj2.getSprite().getAncho(),pj2.getSprite().getAlto());	
		formaVaporeon.end();
			
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

}
