package com.mygdx.darkside;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.darkside.pantallas.PantallaJuego;
import com.mygdx.darkside.pantallas.PantallaMenu;
import com.mygdx.darkside.utilidades.Renderizado;

public class MainDarkSide extends Game {

	@Override 
	public void create () {
		Renderizado.game = this;
		Renderizado.batch = new SpriteBatch();
		this.setScreen(new PantallaMenu());
	}
	
	@Override 
	public void render () {	
		super.render();
	}
	
	@Override
	public void dispose () {
		Renderizado.batch.dispose();
	}
}
