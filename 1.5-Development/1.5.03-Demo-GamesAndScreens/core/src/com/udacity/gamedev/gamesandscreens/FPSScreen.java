package com.udacity.gamedev.gamesandscreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

/**
 * TODO: 3 Check out this screen class third
 *
 * In this screen, we're doing almost the same thing as in DeltaScreen, except we're instead
 * displaying the current frames per second. Let's try running this game, and see how the
 * Game/Screen lifecycle works.
 *
 * When we start up the app, first the Game is created, then we called setScreen() with a
 * DeltaScreen, so DeltaScreen has its show and resize methods called. If we hit space to swap out
 * screens, hide is called on DeltaScreen, and show and resize are called on FPS screen.
 *
 * Finally, when we close the game, hide is called on the active screen, then the dispose method is
 * called on the Game, which cleans up the screens as well.
 */


public class FPSScreen implements Screen {

    public static final String TAG = FPSScreen.class.getName();

    private static final Float FONT_SCALE = 3.0f;

    BitmapFont font;
    SpriteBatch batch;

    @Override
    public void show() {
        Gdx.app.log(TAG, "show() called");
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        font.getData().setScale(FONT_SCALE);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "FPS = " + Gdx.graphics.getFramesPerSecond(), Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2, 0, Align.left, false);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(TAG, "resize(" + width + ", " + height + ") called");
    }

    @Override
    public void pause() {
        Gdx.app.log(TAG, "pause() called");
    }

    @Override
    public void resume() {
        Gdx.app.log(TAG, "resume() called");
    }

    @Override
    public void hide() {
        Gdx.app.log(TAG, "hide() called");
    }

    @Override
    public void dispose() {
        Gdx.app.log(TAG, "dispose() called");
        batch.dispose();
    }
}
