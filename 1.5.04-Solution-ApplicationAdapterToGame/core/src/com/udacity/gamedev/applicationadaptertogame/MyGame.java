package com.udacity.gamedev.applicationadaptertogame;

import com.badlogic.gdx.Game;


/**
 * First complete all the TODOs in MyScreen, then:
 *
 * TODO: Once you're done in MyScreen, Delete the whole body of MyGame
 *
 * TODO: Declare that MyGame extends Game (com.badlogic.gdx.Game)
 *
 * TODO: Hit Ctrl-i to insert the create() method
 *
 * TODO: In create(), call setScreen() with a new instance of MyScreen()
 *
 * TODO: Run what we've created.
 *
 * Everything should still be working, but now the drawing is happening in MyScreen. That means it
 * would be easy to swap out MyScreen for another screen containing a game world, a menu, or
 * whatever. Nice work!
 */


public class MyGame extends Game {

    @Override
    public void create() {
        setScreen(new MyScreen());
    }
}
