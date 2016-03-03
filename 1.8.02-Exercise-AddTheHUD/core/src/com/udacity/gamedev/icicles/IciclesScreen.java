package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.ExtendViewport;


public class IciclesScreen implements Screen {

    public static final String TAG = IciclesScreen.class.getName();

    ExtendViewport iciclesViewport;
    ShapeRenderer renderer;

    // TODO: Add ScreenViewport for HUD


    // TODO: Add SpriteBatch


    // TODO: Add BitmapFont


    Player player;
    Icicles icicles;

    // TODO: Add int to hold the top score


    @Override
    public void show() {
        iciclesViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        // TODO: Initialize the HUD viewport


        // TODO: Initialize the SpriteBatch


        // TODO: Initialize the BitmapFont


        // TODO: Give the font a linear TextureFilter


        player = new Player(iciclesViewport);
        icicles = new Icicles(iciclesViewport);

        // TODO: Set top score to zero

    }

    @Override
    public void resize(int width, int height) {
        iciclesViewport.update(width, height, true);

        // TODO: Update HUD viewport


        // TODO: Set font scale to min(width, height) / reference screen size


        player.init();
        icicles.init();
    }

    @Override
    public void dispose() {
        renderer.dispose();
        // TODO: Dispose of the SpriteBatch and font

    }


    @Override
    public void render(float delta) {
        icicles.update(delta);
        player.update(delta);
        if (player.hitByIcicle(icicles)) {
            icicles.init();
        }


        iciclesViewport.apply(true);
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(iciclesViewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);
        icicles.render(renderer);
        player.render(renderer);
        renderer.end();

        // TODO: Set the top score to max(topScore, iciclesDodges)


        // TODO: Apply the HUD viewport


        // TODO: Set the SpriteBatch's projection matrix


        // TODO: Begin the SpriteBatch


        // TODO: Draw the number of player deaths in the top left


        // TODO: Draw the score and top score in the top right


        // TODO: End the SpriteBatch


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
}
