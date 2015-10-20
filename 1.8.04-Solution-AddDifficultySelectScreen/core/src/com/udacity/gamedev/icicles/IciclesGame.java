package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Game;
import com.udacity.gamedev.icicles.Constants.Difficulty;


public class IciclesGame extends Game {

    @Override
    public void create() {
        showDifficultyScreen();
    }

    public void showDifficultyScreen() {
        setScreen(new DifficultyScreen(this));
    }

    public void showIciclesScreen(Difficulty difficulty) {
        setScreen(new IciclesScreen(this, difficulty));
    }
}
