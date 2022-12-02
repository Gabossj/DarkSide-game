package com.mygdx.darkside.pantallas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.darkside.balas.Bala;
import com.mygdx.darkside.personajes.Enemigo;
import com.mygdx.darkside.personajes.Jugador;
import com.mygdx.darkside.personajes.Personaje;
import com.mygdx.darkside.utilidades.Imagen;
import com.mygdx.darkside.utilidades.Recursos;
import com.mygdx.darkside.utilidades.Renderizado;

public class PantallaJuego implements Screen {

	private Imagen background;
	private Imagen marcoPj;
	private Imagen corazones;
	private Jugador pj;
	
	private ArrayList<Bala> balas = new ArrayList<>();
	private ArrayList<Personaje> enemigos = new ArrayList<>();
	private int cantidadEnemigos = 15;
	private boolean izquierda = false;
	private boolean derecha = true;


	@Override
	public void show() {
		// Fondo
		background = new Imagen("BackGrounds/fondo1.png");
		background.setSize(Recursos.anchoPantalla, Recursos.altoPantalla);

		marcoPj = new Imagen("BackGrounds/marco.png");
		marcoPj.setBounds(30, 550, 150, 150);

		corazones = new Imagen("BackGrounds/corazon.png");
		corazones.setBounds(205, 590, 60, 60);


		// Personajes
		
		pj = pj.getJugador();//aplicacion singleton


		for (int i = 0; i < cantidadEnemigos; i++) {
			Personaje enemigo = new Enemigo(1000 + (i*200));
			enemigos.add(enemigo);
		}
	}

	@Override
	public void render(float delta) {
		Renderizado.limpiarPantalla();

		Renderizado.batch.begin();
		background.dibujarImagen();
		marcoPj.dibujarImagen();
		corazones.dibujarImagen();
		pj.getSprite().dibujarImagen();

		for (Personaje e : enemigos) {
			if (e.getVida() > 0)
			e.getSprite().dibujarImagen();
		}


		// Movimiento en X
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			// Girar la imagen
			if (!izquierda) {
				izquierda = true;
				derecha = false;
				pj.getSprite().rotarImagen();
			}
			pj.getSprite().setX(pj.getSprite().getX() - 500 * Gdx.graphics.getDeltaTime());
		} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			// Girar la imagen
			if (!derecha) {
				derecha = true;
				izquierda = false;
				pj.getSprite().rotarImagen();
			}
			pj.getSprite().setX(pj.getSprite().getX() + 500 * Gdx.graphics.getDeltaTime());
		}
		
		
		//Limitar movimiento personaje (no salir de la pantalla)
		
		if(pj.getSprite().getX()<=0) {
			pj.getSprite().setX(0);
		}
		if(pj.getSprite().getX()>=1146) {
			pj.getSprite().setX(1146);
		}
		

		// Crear bala
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			// para apuntar a cada lado segun donde este mirando
			if (derecha) {
				Bala bala = new Bala(pj.getSprite().getAncho() + pj.getSprite().getX() - 15,
						(pj.getSprite().getAlto()) / 3 + pj.getSprite().getY(), true);
				balas.add(bala);
				bala.getSonidoBala().play();
			}
			if (izquierda) {
				Bala bala = new Bala(pj.getSprite().getX() - pj.getSprite().getAncho() + 15,
						(pj.getSprite().getAlto()) / 3 + pj.getSprite().getY(), false);
				balas.add(bala);
				bala.getSonidoBala().play();
			}

		}

		// Movimiento Enemigo

		for (int i = 0; i < enemigos.size(); i++) {
			if (pj.getSprite().getX() < enemigos.get(i).getSprite().getX()) {
				enemigos.get(i).getSprite().setX(enemigos.get(i).getSprite().getX() - 180 * Gdx.graphics.getDeltaTime());
			} else if (pj.getSprite().getX() > (enemigos.get(i).getSprite().getX())) {
				enemigos.get(i).getSprite().setX(enemigos.get(i).getSprite().getX() + 180 * Gdx.graphics.getDeltaTime());
			}
			if (pj.comprobarColision(enemigos.get(i))) {
				
				Renderizado.game.setScreen(new PantallaGameOver());
			}
				
		}

		// Movimiento de las balas
		for (int i = 0; i < balas.size(); i++) {
			Bala b = balas.get(i);

			// Dispara segun donde mire
			b.moverBala();
			for (int j = 0; j < enemigos.size(); j++) {
				if (enemigos.get(j).getVida() >  0) {
					if (b.comprobarColision(enemigos.get(j))) {
						//enemigos.get(j).setVida(enemigos.get(j).getVida() - pj.getAtaque()); 
						enemigos.get(j).setVida(enemigos.get(i).recibeDaño(enemigos.get(j).getVida(), pj.getAtaque()));
					}
				}else if (enemigos.get(j).getVida()<= 0 ) enemigos.remove(j);
				
			}

			if (b.seDestruyo())
				balas.remove(b);
		}

		// Dibujo de las balas
		for (Bala b : balas) {
			b.dibujar();
		}

		Renderizado.batch.end();

		/*//Para dibujar el rectangulo del area del personaje
		 * formaJugador.begin(ShapeType.Line); formaJugador.setColor(Color.YELLOW);
		 * formaJugador.rect(pj.getSprite().getX(),pj.getSprite().getY(),pj.getSprite().
		 * getAncho(),pj.getSprite().getAlto()); formaJugador.end(); /*
		 * 
		 * /* if (vaporeonVivo) { formaEnemigo.begin(ShapeType.Line);
		 * formaEnemigo.setColor(Color.YELLOW);
		 * formaEnemigo.rect(pj2.getSprite().getX(),pj2.getSprite().getY(),pj2.getSprite
		 * ().getAncho(),pj2.getSprite().getAlto()); formaEnemigo.end(); }
		 */

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
