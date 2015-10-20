package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;



public class IciclesScreen implements Screen {

    public static final String TAG = IciclesScreen.class.getName();


    // TODO: Add an ExtendViewport
    ExtendViewport iciclesViewport;

    // TODO: Add a ShapeRenderer
    ShapeRenderer renderer;

    // TODO: Add an Icicle
    Icicle icicle;

    @Override
    public void show() {
        // TODO: Initialize the viewport using the world size constant
        iciclesViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        // TODO: Initialize the ShapeRenderer
        renderer = new ShapeRenderer();

        // TODO: Set autoShapeType(true) on the ShapeRenderer
        renderer.setAutoShapeType(true);

        // TODO: Create a new Icicle in the middle of the world
        icicle = new Icicle(new Vector2(Constants.WORLD_SIZE / 2, Constants.WORLD_SIZE / 2));

    }

    @Override
    public void resize(int width, int height) {
        // TODO: Ensure that the viewport updates correctly
        iciclesViewport.update(width, height, true);
    }

    @Override
    public void dispose() {

    }


    @Override
    public void render(float delta) {

        // TODO: Apply the viewport
        iciclesViewport.apply(true);

        // TODO: Clear the screen to the background color
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Set the ShapeRenderer's projection matrix
        renderer.setProjectionMatrix(iciclesViewport.getCamera().combined);

        // TODO: Draw the Icicle

        renderer.begin(ShapeType.Filled);
        icicle.render(renderer);
        renderer.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    // TODO: Dispose of the ShapeRenderer
    @Override
    public void hide() {
        renderer.dispose();
    }
}
