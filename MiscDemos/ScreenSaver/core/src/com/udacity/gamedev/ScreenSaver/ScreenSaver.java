package com.udacity.gamedev.ScreenSaver;

import com.badlogic.gdx.Game;

public class ScreenSaver extends Game {

    @Override
    public void create() {
        setScreen(new ScreenSaverScreen());
    }

}
