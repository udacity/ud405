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
 * The goal of this exercise is just to draw a simily face. Feel free to get that done however you
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

    // TODO: Declare
    ShapeRenderer renderer;
    ExtendViewport viewport;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        viewport.getCamera().position.set(FACE_CENTER_X, FACE_CENTER_Y,0);
    }

    /**
     * We'll often want to break up our drawing into separate functions, or different objects
     * entirely. This is easy to do, all we need to do is pass in our ShapeRenderer. All we need to do here is
     */

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);
        drawSmileyFace(renderer);
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
        renderer.arc(FACE_CENTER_X, FACE_CENTER_Y, MOUTH_OUTER_RADIUS, MOUTH_START_ANGLE, MOUTH_DEGREES, MOUTH_SEGMENTS);
        renderer.setColor(Color.YELLOW);
        renderer.arc(FACE_CENTER_X, FACE_CENTER_Y, MOUTH_INNER_RADIUS, MOUTH_START_ANGLE, MOUTH_DEGREES, MOUTH_SEGMENTS);
    }


}
