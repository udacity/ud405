package com.udacity.gamedev.gamesandscreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

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
