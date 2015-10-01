package com.udacity.gamedev.screensaver;

import com.badlogic.gdx.Game;

public class ScreenSaver extends Game {

    @Override
    public void create() {
        setScreen(new BallScreen());
    }

}
