package com.udacity.gamedev.drawinglines;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TODO: Start Here!
 *
 * In this demo, we'll use ShapeRenderer to draw some lines! We'll use most of the line drawing
 * methods offered by ShapeRenderer, but remember to check out the Javadocs for the full story. If
 * you're lazy, you can just Google "LibGDX ShapeRenderer", and you'll find what you're looking
 * for!
 */

public class DrawingLines extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        // Remember we want to create our ShapeRenderer outside of our render callback
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        // Also remember to clean up
        shapeRenderer.dispose();
        super.dispose();
    }

    @Override
    public void render() {
        // As always, first we clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Then we start our shapeRenderer batch, this time with ShapeType.Line
        shapeRenderer.begin(ShapeType.Line);
        // A Simple white line
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.line(0, 0, 100, 100);
        // We can set different colors using two methods. We can use constants like so.
        shapeRenderer.setColor(Color.MAGENTA);
        shapeRenderer.line(10, 0, 110, 100);
        // We can also set a color using RGBA values
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.line(20, 0, 120, 100);
        // We can also do fancy things like gradients
        shapeRenderer.line(30, 0, 130, 100, Color.BLUE, Color.RED);
        // The last interesting thing we can do is draw a bunch of connected line segments using polyline
        // First we set up the list of vertices, where the even positions are x coordinates, and the odd positions are the y coordinates
        float[] verticies = {100, 200, 300, 300, 200, 300, 300, 200};
        shapeRenderer.polyline(verticies);
        // Finally, as always, we end the batch
        shapeRenderer.end();
    }
}
