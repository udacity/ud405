package com.udacity.gamedev.reciprocatingmotion;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * TODO: Start Here
 *
 * In this exercise we'll make a circle move back and forth smoothly. We'll pick a period and and
 * amplitude, the set the circle x position to the center of the screen plus the amplitude times the
 * sin of 2Pi the elapsed time divided by the period.
 */


public class ReciprocatingMotion extends ApplicationAdapter {

    private static final float WORLD_SIZE = 480;
    private static final float CIRCLE_RADIUS = WORLD_SIZE / 20;
    private static final float MOVEMENT_DISTANCE = WORLD_SIZE / 4;

    // TODO: Define a constant that fixes how long a cycle of the animation should take in seconds
    private static final float PERIOD = 2;

    ShapeRenderer renderer;
    ExtendViewport viewport;

    // TODO: Create a long to hold onto ApplicationAdapter creation time
    long startTime;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);

        // TODO: Save current value of TimeUtils.nanoTime()
        startTime = TimeUtils.nanoTime();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void render() {
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);

        // Since we're using an extend viewport, the world might be bigger than we expect
        float worldCenterX = viewport.getWorldWidth() / 2;
        float worldCenterY = viewport.getWorldHeight() / 2;

        // TODO: Figure out how long it's been since the animation started using TimeUtils.nanoTime()
        long elapsedNanos = TimeUtils.nanoTime() - startTime;

        // TODO: Use MathUtils.nanoToSec to figure out how many seconds the animation has been running
        float elapsedSeconds = MathUtils.nanoToSec * elapsedNanos;

        // TODO: Figure out how many cycles have elapsed since the animation started running
        float cycles = elapsedSeconds / PERIOD;

        // TODO: Figure out where in the cycle we are
        float cyclePosition = cycles % 1;

        // TODO: Use MathUtils.sin() to set the x position of the circle
        float x = worldCenterX + MOVEMENT_DISTANCE * MathUtils.sin(MathUtils.PI2 * cyclePosition);

        float y = worldCenterY;
        renderer.circle(x, y, CIRCLE_RADIUS);
        renderer.end();

    }
}
