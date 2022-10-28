package com.mygdx.darkside.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.mygdx.darkside.utilidades.Imagen;
import com.mygdx.darkside.utilidades.Recursos;
import com.mygdx.darkside.utilidades.Renderizado;

public class PantallaMenu implements Screen {

	private Imagen fondo;
	private Imagen arboles;
	private BitmapFont fuente, DarkSide;
	private String textos[] = { "Click para iniciar Partida", "Salir..." , "DarkSide"};
	private FreeTypeFontGenerator generador1,generador2;
	private FreeTypeFontParameter parametros1,parametros2;
	

	private boolean TransparenciaInTerminado = false;
	private boolean mostrarTexto = false;
	private float transparencia = 0;
	private float contTiempo = 0;

	@Override
	public void show() {
		//Textos opciones
		generador1 = new FreeTypeFontGenerator(Gdx.files.internal(Recursos.fuente1));
		parametros1 = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parametros1.size = 35; fuente = generador1.generateFont(parametros1);
		
		//Texto DarkSide
		generador2 = new FreeTypeFontGenerator(Gdx.files.internal(Recursos.fuente3));
		parametros2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parametros2.size = 80; parametros2.color= Color.BLACK; DarkSide= generador2.generateFont(parametros2);
		
		//Imagenes
		fondo = new Imagen("Pantallas/p1.png");
		arboles = new Imagen("Pantallas/p5.png");
		fondo.setSize(Recursos.anchoPantalla, Recursos.altoPantalla);
		fondo.setTransparencia(0);
		arboles.setSize(Recursos.anchoPantalla, Recursos.altoPantalla);
		arboles.setTransparencia(0);
		
	
	}

	@Override
	public void render(float delta) { 
		Renderizado.limpiarPantalla();

		Renderizado.batch.begin();
		fondo.dibujarImagen();
		arboles.dibujarImagen();
		procesarTransparencia();
		
		
		if (mostrarTexto) {
			fuente.draw(Renderizado.batch, textos[0], Recursos.anchoPantalla / 3, (Recursos.altoPantalla / 2) -60);
			fuente.draw(Renderizado.batch, textos[1], Recursos.anchoPantalla / 3, (Recursos.altoPantalla / 2) - 120);
			DarkSide.draw(Renderizado.batch, textos[2], Recursos.anchoPantalla / 12, (Recursos.altoPantalla ) - 160);
			if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
				Renderizado.game.setScreen(new PantallaJuego());
			}
		}
		Renderizado.batch.end();
		
		
	}

	//Función que se encarga de dejar esteticamente mas bonito la carga en el menu
	public void procesarTransparencia() {
		if (!TransparenciaInTerminado) {
			transparencia += 0.006f;
			if (transparencia > 1) {
				transparencia = 1;
				TransparenciaInTerminado = true;
			}
		} else if (!mostrarTexto) {
			contTiempo += 0.02f;
			if (contTiempo >= 1) {
				mostrarTexto = true;
			}
		}

		fondo.setTransparencia(transparencia);
		arboles.setTransparencia(transparencia);
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
