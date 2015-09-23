package com.udacity.gamedev.sierpinskitriangle.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.udacity.gamedev.sierpinskitriangle.SierpinskiTriangle;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SierpinskiTriangle(), config);
	}
}
