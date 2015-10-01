package com.udacity.gamedev.gamesandscreens.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.udacity.gamedev.gamesandscreens.DemoGame;


/**
 * TODO: 4. Finally, check out the configuration in the desktop launcher
 *
 * We haven't talked about this file yet, but here's the entry point into the Desktop game, and it's
 * also where you can configure the Application that hosts your ApplicationListener. For instance,
 * we can set the frame rate down to 10. If we run the game again, we see that delta is now about
 * .1, or 100ms.
 */

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

//        config.foregroundFPS = 10;
        new LwjglApplication(new DemoGame(), config);
    }
}
