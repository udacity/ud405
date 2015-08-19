package com.udacity.gamedev.ScreenSaver;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by silver on 8/19/15.
 */
public class ScreenSaverScreen extends InputAdapter implements Screen {

    ShapeRenderer shapeRenderer;

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
