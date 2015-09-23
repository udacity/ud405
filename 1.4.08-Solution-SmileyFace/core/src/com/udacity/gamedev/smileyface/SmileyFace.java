package com.udacity.gamedev.smileyface;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * TODO: Start here
 *
 * The goal of this exercise is just to draw a similey face. Feel free to get as artistic as you
 * want, but we've provided a bunch of constants you may find useful.
 *
 * The tricky part is drawing the mouth. Since we can't draw thick lines, making a thick line for
 * the mouth is hard. The trick is to draw two arcs. One black one, then a slightly smaller yellow
 * one. The portion of the black arc that isn't covered by the yellow arc becomes the mouth.
 */

public class SmileyFace extends ApplicationAdapter {


    static final float FACE_CENTER_X = 20.0f;
    static final float FACE_CENTER_Y = 20.0f;
    static final float WORLD_WIDTH = 10.0f;
    static final float WORLD_HEIGHT = 10.0f;
    static final float FACE_RADIUS = 0.8f * WORLD_WIDTH / 2;
    static final float EYE_OFFSET = 0.5f * FACE_RADIUS;
    static final float EYE_RADIUS = 0.2f * FACE_RADIUS;
    static final float MOUTH_OUTER_RADIUS = 0.8f * FACE_RADIUS;
    static final float MOUTH_INNER_RADIUS = 0.6f * FACE_RADIUS;
    static final float MOUTH_START_ANGLE = 180.0f;
    static final float MOUTH_DEGREES = 180.0f;
    static final int FACE_SEGMENTS = 40;
    static final int EYE_SEGMENTS = 20;
    static final int MOUTH_SEGMENTS = 20;

    // TODO: Declare a ShapeRenderer and an ExtendViewport
    ShapeRenderer renderer;
    ExtendViewport viewport;

    @Override
    public void create() {

        // TODO: Initialize the ShapeRenderer and ExtendViewport
        renderer = new ShapeRenderer();
        viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT);
    }

    @Override
    public void dispose() {

        // TODO: Dispose of the ShapeRenderer
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {

        // TODO: Update the viewport
        viewport.update(width, height, true);

        // TODO: Move the viewport's camera to the center of the face
        viewport.getCamera().position.set(FACE_CENTER_X, FACE_CENTER_Y, 0);
    }

    /**
     * We'll often want to break up our drawing into separate functions, or different objects
     * entirely. This is easy to do, all we need to do is pass in our ShapeRenderer.
     */
    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Apply the viewport
        viewport.apply();

        // TODO: Set the ShapeRender's projection matrix
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        // TODO: Start a Filled batch
        renderer.begin(ShapeType.Filled);

        // TODO: Call drawSmileyFace()
        drawSmileyFace(renderer);

        // TODO: End the batch
        renderer.end();
    }

    private void drawSmileyFace(ShapeRenderer renderer) {

        // TODO: Set the color to yellow, and draw the face
        renderer.setColor(Color.YELLOW);
        renderer.circle(FACE_CENTER_X, FACE_CENTER_Y, FACE_RADIUS, FACE_SEGMENTS);

        // TODO: Set the color to black and draw the eyes
        renderer.setColor(Color.BLACK);
        renderer.circle(FACE_CENTER_X - EYE_OFFSET, FACE_CENTER_Y + EYE_OFFSET, EYE_RADIUS, EYE_SEGMENTS);
        renderer.circle(FACE_CENTER_X + EYE_OFFSET, FACE_CENTER_Y + EYE_OFFSET, EYE_RADIUS, EYE_SEGMENTS);

        // TODO: Draw a black arc for the mouth (Hint: MOUTH_OUTER_RADIUS)
        renderer.arc(FACE_CENTER_X, FACE_CENTER_Y, MOUTH_OUTER_RADIUS, MOUTH_START_ANGLE, MOUTH_DEGREES, MOUTH_SEGMENTS);

        // TODO: Draw a yellow arc to make the mouth actually look like a mouth (Hint: MOUTH_INNER_RADIUS)
        renderer.setColor(Color.YELLOW);
        renderer.arc(FACE_CENTER_X, FACE_CENTER_Y, MOUTH_INNER_RADIUS, MOUTH_START_ANGLE, MOUTH_DEGREES, MOUTH_SEGMENTS);
    }
}
