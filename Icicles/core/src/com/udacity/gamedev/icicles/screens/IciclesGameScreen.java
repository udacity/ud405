package com.udacity.gamedev.icicles.screens;

import com.badlogic.gdx.Screen;
import com.udacity.gamedev.icicles.world.WorldController;
import com.udacity.gamedev.icicles.world.WorldRenderer;

/**
 * Created by silver on 8/2/15.
 */
public class IciclesGameScreen implements Screen {

    private WorldController worldController;
    private WorldRenderer worldRenderer;

    @Override
    public void show() {
        worldController = new WorldController();
        worldRenderer = new WorldRenderer(worldController);
    }

    @Override
    public void render(float delta) {
        worldRenderer.render();
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
