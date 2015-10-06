package com.udacity.gamedev.bubblelevel;

import com.badlogic.gdx.Game;

public class BubbleLevelGame extends Game {
    @Override
    public void create() {
        setScreen(new BubbleLevelScreen());
    }
}
