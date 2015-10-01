package com.udacity.gamedev.fpscounter;

import com.badlogic.gdx.Game;

public class FPSCounterGame extends Game {

    @Override
    public void create() {
        setScreen(new FPSCounterScreen());
    }

}
