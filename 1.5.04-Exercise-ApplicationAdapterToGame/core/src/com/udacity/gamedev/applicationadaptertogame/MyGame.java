package com.udacity.gamedev.applicationadaptertogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


/**
 * First complete all the TODOs in MyScreen, then:
 *
 * TODO: Delete the whole body of MyGame
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


public class MyGame extends ApplicationAdapter {

    SpriteBatch batch;
    BitmapFont font;
    ScreenViewport viewport;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(2);
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        viewport = new ScreenViewport();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        viewport.apply();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        font.draw(batch, "Hello from " + this.getClass().getSimpleName(),
                viewport.getWorldWidth() / 2,
                viewport.getWorldHeight() / 2,
                0,
                Align.center,
                false);

        batch.end();
    }
}

