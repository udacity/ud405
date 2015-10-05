package com.udacity.gamedev.stickfigure;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TODO: Start here
 *
 * In this exercise you'll set up a ShapeRenderer, and use it to draw a stick figure. At minimum,
 * you'll need a circle for the head, and five lines for the torso, arms, and legs.
 *
 * Remember to set up a ShapeRenderer you'll need to declare it, initialize it, and dispose of it.
 * Then to actually use the ShapeRenderer you'll need to start a batch of the appropriate type, draw
 * your shapes, and end the batch.
 *
 * We don't have step-by-step TODOs for this one, since the aim is for you to remember the steps for
 * setting up a ShapeRenderer and be able to set one up on your own. Of course, the solution is
 * available if you run into anything confusing.
 */
public class StickFigure extends ApplicationAdapter {

    // Declare
    ShapeRenderer renderer;

    @Override
    public void create() {
        // Initialize
        renderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        // Dispose
        renderer.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeType.Filled);

        // Head
        renderer.circle(100, 100, 10);
        renderer.end();

        renderer.begin(ShapeType.Line);

        // Torso
        renderer.line(100, 50, 100, 100);

        // Legs
        renderer.line(85, 35, 100, 50);
        renderer.line(115, 35, 100, 50);

        // Arms
        renderer.line(85, 70, 100, 85);
        renderer.line(115, 70, 100, 85);
        renderer.end();
    }
}
