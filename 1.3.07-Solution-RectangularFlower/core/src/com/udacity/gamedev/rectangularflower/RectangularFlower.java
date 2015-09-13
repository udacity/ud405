package com.udacity.gamedev.rectangularflower;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TODO: Start Here
 *
 * In this exercise, we're going to draw a flower using only rectangles! We've already started off
 * with a green rectline for the stem. First you'll draw a couple leaves using rotated rectangles.
 *
 * Then you'll draw the head of the flower by drawing a a bunch of rotated squares!
 */

public class RectangularFlower extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        super.dispose();
        shapeRenderer.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        // Draw the stem
        shapeRenderer.rectLine(100, 0, 100, 300, 20);

        // TODO: Draw two leaves on the stem using rotated rectangles
        shapeRenderer.rect(100, 100, 0, 0, 40, 40, 1, 1, 135);
        shapeRenderer.rect(100, 150, 0, 0, 30, 30, 1, 1, 315);

        // TODO: Set the active color to yellow
        shapeRenderer.setColor(Color.YELLOW);

        // TODO: Use a loop to draw 20 of these petals in a circle
        final int petals = 20;
        for (int petal = 0; petal < petals; petal++) {
            shapeRenderer.rect(100, 300, 0, 0, 40, 40, 1, 1, 360.0f * petal / petals);
        }

        shapeRenderer.end();
    }
}
