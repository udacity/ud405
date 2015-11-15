package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Game;
import com.udacity.gamedev.icicles.Constants.Difficulty;


public class IciclesGame extends Game {

    @Override
    public void create() {
        showDifficultyScreen();
    }


    public void showDifficultyScreen() {
        // TODO: Show the difficulty screen
        setScreen(new DifficultyScreen(this));
    }

    public void showIciclesScreen(Difficulty difficulty) {
        // TODO: Show the Icicles screen with the appropriate difficulty
        setScreen(new IciclesScreen(this, difficulty));
    }
}
