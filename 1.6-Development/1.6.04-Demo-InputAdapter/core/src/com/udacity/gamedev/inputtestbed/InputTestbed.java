package com.udacity.gamedev.inputtestbed;

import com.badlogic.gdx.Game;

public class InputTestbed extends Game {

    @Override
    public void create() {
        setScreen(new BallScreen());
    }

}
