package com.mygdx.darkside;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.darkside.utilidades.Recursos;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("DarkSide");
		config.setWindowedMode(Recursos.anchoPantalla,Recursos.altoPantalla);
		new Lwjgl3Application(new MainDarkSide(), config);
	}
}
