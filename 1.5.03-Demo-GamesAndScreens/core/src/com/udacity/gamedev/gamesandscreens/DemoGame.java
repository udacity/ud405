package com.udacity.gamedev.gamesandscreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 * TODO: 1. Check out the Game class first
 *
 * Instead of an ApplicationAdapter we're using a Game, which extends ApplicationListener.
 *
 * If we check out Game, we see it's got a screen member variable, and it seems that, for every
 * callback that ApplicationListener implements, it checks to see if it's got a Screen, and if so,
 * it delegates that callback to the Screen.
 *
 * So what's a screen? Well if we check out its source, we see:
 *
 * > Represents one of many application screens, such as a main menu, a settings menu, the game
 * screen and so on.
 *
 * And if we look at the required methods, it seems that the callbacks for a Screen are almost
 * identical to ApplicationListener.
 *
 * So if we want to switch between different logical screens in our game, we just need to call
 * setScreen() on our Game object, and all the ApplicationListener callbacks will be redirected to
 * the screen that we want to be active!
 */


public class DemoGame extends Game {

    public static final String TAG = DemoGame.class.getName();

    DeltaScreen deltaScreen;
    FPSScreen textScreen;


    /**
     * So let's see this in action. Here we've declared two screens. One of which displays the
     * number of frames displayed per second, and the other displays the number of seconds between
     * the current frame and the last one. Let's check out the DeltaScreen.
     */
    @Override
    public void create() {
        Gdx.app.log(TAG, "create() called");
        deltaScreen = new DeltaScreen();
        textScreen = new FPSScreen();
        setScreen(deltaScreen);

        // We'll talk about this soon. This lets us hit spacebar to swap screens
        Gdx.input.setInputProcessor(new ScreenSwitcher(this, deltaScreen, textScreen));
    }


    @Override
    public void dispose() {
        Gdx.app.log(TAG, "dispose() called");
        super.dispose();
    }
}
