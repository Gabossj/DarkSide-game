package com.mygdx.darkside.utilidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.darkside.MainDarkSide;
import com.badlogic.gdx.utils.ScreenUtils;

public class Renderizado {

	public static SpriteBatch batch;
	public static MainDarkSide game;
	
	public static void limpiarPantalla() {
		ScreenUtils.clear(0,0,0,0);
	}
	
}
