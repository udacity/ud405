package com.udacity.gamedev.smileyface;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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



    @Override
    public void create() {

        // TODO: Initialize the ShapeRenderer and ExtendViewport


    }

    @Override
    public void dispose() {

        // TODO: Dispose of the ShapeRenderer

    }

    @Override
    public void resize(int width, int height) {

        // TODO: Update the viewport


        // TODO: Move the viewport's camera to the center of the face

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


        // TODO: Set the ShapeRender's projection matrix


        // TODO: Start a Filled batch


        // TODO: Call drawSmileyFace()


        // TODO: End the batch

    }

    private void drawSmileyFace(ShapeRenderer renderer) {

        // TODO: Set the color to yellow, and draw the face



        // TODO: Set the color to black and draw the eyes




        // TODO: Draw a black arc for the mouth (Hint: MOUTH_OUTER_RADIUS)


        // TODO: Draw a yellow arc to make the mouth actually look like a mouth (Hint: MOUTH_INNER_RADIUS)


    }
}
