package com.udacity.gamedev.orthographiccamera.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.udacity.gamedev.orthographiccamera.OrthographicCameraExercise;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new OrthographicCameraExercise(), config);
	}
}
