package com.mygdx.darkside.pantallas;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.darkside.balas.Bala;
import com.mygdx.darkside.personajes.Enemigo;
import com.mygdx.darkside.personajes.Jugador;
import com.mygdx.darkside.personajes.Personaje;
import com.mygdx.darkside.utilidades.Imagen;
import com.mygdx.darkside.utilidades.Recursos;
import com.mygdx.darkside.utilidades.Renderizado;

public class PantallaJuego implements Screen {

	private Imagen background;
	private Imagen marcoPj; private Imagen corazones;
	private Personaje pj;
	private static Enemigo pj2;
	
	//private ShapeRenderer formaJugador,formaEnemigo;
	private ArrayList<Bala> balas = new ArrayList<>();
	private boolean vaporeonVivo= true;
	private boolean izquierda = false; private boolean derecha= true;
	
	@Override
	public void show() {
		// Fondo
		background = new Imagen("BackGrounds/fondo1.png");
		background.setSize(Recursos.anchoPantalla, Recursos.altoPantalla);
		
		marcoPj = new Imagen("BackGrounds/marco.png");
		marcoPj.setBounds(30, 550, 150, 150);
		
		corazones= new Imagen("BackGrounds/corazones.png");
		corazones.setBounds(195, 570, 100, 100);
		
		//Rectangulo
		//formaJugador = new ShapeRenderer();
		//formaEnemigo = new ShapeRenderer();

		// Personajes
		
		//Mantener instancia de creacion en contexto
		pj = new Jugador(); 
		
		//Aplicacion patron singleton
		pj2 = pj2.getEnemigo();

	}

	@Override
	public void render(float delta) {
		Renderizado.limpiarPantalla();

		Renderizado.batch.begin();
			background.dibujarImagen();
			marcoPj.dibujarImagen();
			corazones.dibujarImagen();
			pj.getSprite().dibujarImagen();
			
			
			for(int i=0; i<4; i++) {
				

				if (vaporeonVivo) pj2.getSprite().dibujarImagen2(pj2.getPosx());
				
			   
			}
			
			   //Movimiento en X
			   if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				   //Girar la imagen
				   if (!izquierda) {
					   izquierda=true; derecha=false;
					   pj.getSprite().rotarImagen(izquierda);
				   }
				   pj.getSprite().setX(pj.getSprite().getX() - 500 * Gdx.graphics.getDeltaTime());
			   }
			   
			   
			   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				   //Girar la imagen 
				   if (!derecha) {
					   derecha=true; izquierda=false;
					   pj.getSprite().rotarImagen(derecha);
				   }
				   pj.getSprite().setX(pj.getSprite().getX() + 500 * Gdx.graphics.getDeltaTime());
			   }
			   
			   //LIMITAR MOVIMIENTO EJE X
			   if(pj.getSprite().getX()<=0) {
				   pj.getSprite().setX(0);
				}
			   if(pj.getSprite().getX()>=1146) {
				   pj.getSprite().setX(1146);
			   }
			   //Movimiento en Y
			   //if(Gdx.input.isKeyPressed(Input.Keys.UP)) pj.getSprite().setY(pj.getSprite().getY() + 500 * Gdx.graphics.getDeltaTime());
			   //if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) pj.getSprite().setY(pj.getSprite().getY() - 500 * Gdx.graphics.getDeltaTime());
			   
			   //Crear bala
			     if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) { 
			    	//para apuntar a cada lado segun donde este mirando
			    	 
			    	if (derecha) {
			    		
			        Bala bala = new Bala(pj.getSprite().getAncho()+pj.getSprite().getX()-15,(pj.getSprite().getAlto())/3+pj.getSprite().getY(),true);
				    balas.add(bala);
			    	}
			    	if (izquierda) {
			    	Bala bala = new Bala(pj.getSprite().getX()-pj.getSprite().getAncho()+15,(pj.getSprite().getAlto())/3+pj.getSprite().getY(),false);
					 balas.add(bala);	
			    	}
			    	
			     }
			     
			//Movimiento de las balas    
			for (int i = 0; i < balas.size(); i++) {     
			     Bala b = balas.get(i);
			     
			     //Dispara segun donde mire
			     b.moverBala();
			     
			     if(vaporeonVivo) {
			    	 if(b.comprobarColision(pj2)) {
			    		 vaporeonVivo=false;
			     	}
			     }
			     
			     if (b.seDestruyo()) balas.remove(b);
			}
			
			//Dibujo de las balas
			for (Bala b : balas) {
				b.dibujar();
			}
					
		Renderizado.batch.end();
		  
		/*
		formaJugador.begin(ShapeType.Line);
			formaJugador.setColor(Color.YELLOW);
			formaJugador.rect(pj.getSprite().getX(),pj.getSprite().getY(),pj.getSprite().getAncho(),pj.getSprite().getAlto());		
		formaJugador.end();
		/*
		
		/*
		if (vaporeonVivo) {
		formaEnemigo.begin(ShapeType.Line);
			formaEnemigo.setColor(Color.YELLOW);
			formaEnemigo.rect(pj2.getSprite().getX(),pj2.getSprite().getY(),pj2.getSprite().getAncho(),pj2.getSprite().getAlto());	
		formaEnemigo.end();
		}	
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
