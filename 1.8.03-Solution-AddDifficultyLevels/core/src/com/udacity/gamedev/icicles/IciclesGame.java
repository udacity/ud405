package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Game;
import com.udacity.gamedev.icicles.Constants.Difficulty;


public class IciclesGame extends Game {

    @Override
    public void create() {
        // TODO: Create IciclesScreen with a Difficulty
        setScreen(new IciclesScreen(Difficulty.HARD));
    }
}
