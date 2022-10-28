package com.mygdx.darkside.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.darkside.personajes.Enemigo;
import com.mygdx.darkside.personajes.Jugador;
import com.mygdx.darkside.personajes.Personaje;
import com.mygdx.darkside.utilidades.Imagen;
import com.mygdx.darkside.utilidades.Recursos;
import com.mygdx.darkside.utilidades.Renderizado;

public class PantallaJuego implements Screen, Transparencias {

	private Imagen background;
	private Personaje pj1, pj2;
	private ShapeRenderer formaJolteon,formaVaporeon;
	private boolean TransparenciaTerminada = false; private float transparencia = 0;

	
	@Override
	public void show() {
		// Fondo
		background = new Imagen("BackGrounds/background.jpg");
		background.setSize(Recursos.anchoPantalla, Recursos.altoPantalla);
		background.setTransparencia(0);
		
		//Rectangulo
		formaJolteon = new ShapeRenderer();
		formaVaporeon = new ShapeRenderer();
		
		// Personajes
		pj1 = new Jugador();
		pj2 = new Enemigo();
		
	}

	@Override
	public void render(float delta) {
		Renderizado.limpiarPantalla();
		
		Renderizado.batch.begin();
			background.dibujarImagen();
			procesarTransparencia();
			
			if (TransparenciaTerminada==true) {
			pj1.getSprite().dibujarImagen();
			pj2.getSprite().dibujarImagen();
			
			   //Movimiento en X
			   if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) pj1.getSprite().setX(pj1.getSprite().getX() - 150 * Gdx.graphics.getDeltaTime());
			   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) pj1.getSprite().setX(pj1.getSprite().getX() + 150 * Gdx.graphics.getDeltaTime());
			   //Movimiento en Y
			   if(Gdx.input.isKeyPressed(Input.Keys.UP)) pj1.getSprite().setY(pj1.getSprite().getY() + 150 * Gdx.graphics.getDeltaTime());
			   if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) pj1.getSprite().setY(pj1.getSprite().getY() - 150 * Gdx.graphics.getDeltaTime());
			   
			   //Check colision con el otro sprite
			   if(pj1.getSprite().getBoundingRectangle().overlaps(pj2.getSprite().getBoundingRectangle())) {
			       System.out.println("Colision");
			   }
			   
			   
			}
		Renderizado.batch.end();

		if (TransparenciaTerminada == true) {
		//Dibuja el rectangulo
		formaJolteon.begin(ShapeType.Line);
			formaJolteon.setColor(Color.YELLOW);
			formaJolteon.rect(pj1.getSprite().getX(),pj1.getSprite().getY(),pj1.getSprite().getAncho(),pj1.getSprite().getAlto());		
		formaJolteon.end();
		//Dibuja el rectangulo
		formaVaporeon.begin(ShapeType.Line);
			formaVaporeon.setColor(Color.YELLOW);
			formaVaporeon.rect(pj2.getSprite().getX(),pj2.getSprite().getY(),pj2.getSprite().getAncho(),pj2.getSprite().getAlto());	
		formaVaporeon.end();
		}
		
	}

	@Override
	public void procesarTransparencia() {
		if (!TransparenciaTerminada) {
			transparencia += 0.011f;
			if (transparencia > 1) {
				transparencia = 1;
				TransparenciaTerminada = true;
			}
		} 
		background.setTransparencia(transparencia);
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
