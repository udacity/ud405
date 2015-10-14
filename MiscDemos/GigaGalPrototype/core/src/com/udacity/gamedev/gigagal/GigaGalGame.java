package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.Game;

public class GigaGalGame extends Game {

    @Override
    public void create() {
        setScreen(new GameplayScreen());
    }

}
