package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Game;


public class IciclesGame extends Game {


    //TODO: call setScreen() with a new IciclesScreen()
    @Override
    public void create() {
        setScreen(new IciclesScreen());
    }
}
