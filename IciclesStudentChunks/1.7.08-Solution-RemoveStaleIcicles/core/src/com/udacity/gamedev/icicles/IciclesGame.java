package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Game;


public class IciclesGame extends Game {

    @Override
    public void create() {
        setScreen(new IciclesScreen());
    }
}
