package com.udacity.gamedev.gamesandscreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class DemoGame extends Game {

    public static final String TAG = DemoGame.class.getName();

    DeltaScreen demoScreen;
    FPSScreen textScreen;


    @Override
    public void create() {
        Gdx.app.log(TAG, "create() called");

        demoScreen = new DeltaScreen();
        textScreen = new FPSScreen();

        setScreen(demoScreen);

        Gdx.input.setInputProcessor(new ScreenSwitcher(this, demoScreen, textScreen));




    }


    @Override
    public void dispose() {



        Gdx.app.log(TAG, "dispose() called");
        demoScreen.dispose();
        textScreen.dispose();

    }
}
