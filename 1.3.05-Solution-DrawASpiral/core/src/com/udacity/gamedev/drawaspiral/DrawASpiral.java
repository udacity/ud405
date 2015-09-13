package com.udacity.gamedev.drawaspiral;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

/**
 * TODO: Start here
 *
 * In this exercise we have a project that draws a number of concentric rectangles as specified in
 * the COILS constant. The space between the rectangles is given by xStep and yStep.
 *
 * The rectangles are drawn using four lines between five points. Your task is to adjust the first
 * and last point such that each rectangle turns into a coil that meets up with the neighboring
 * coils inside and outside of it.
 */

public class DrawASpiral extends ApplicationAdapter {

        ShapeRenderer shapeRenderer;
    private static final int COILS = 20;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeType.Line);

        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        int xStep = screenWidth / 2 / COILS;
        int yStep = screenHeight / 2 / COILS;

        for (int i = 0; i < COILS; i++){

            int xOffset = xStep * i;
            int yOffset = yStep * i;

            // TODO: Make this coil reach back to the outer coil
            Vector2 point1 = new Vector2(xOffset - xStep, yOffset);
            Vector2 point2 = new Vector2(screenWidth - xOffset, yOffset);
            Vector2 point3 = new Vector2(screenWidth - xOffset, screenHeight - yOffset);
            Vector2 point4 = new Vector2(xOffset, screenHeight - yOffset);
            // TODO: Make this coil stop before connecting back to itself
            Vector2 point5 = new Vector2(xOffset, yOffset + yStep);

            shapeRenderer.line(point1, point2);
            shapeRenderer.line(point2, point3);
            shapeRenderer.line(point3, point4);
            shapeRenderer.line(point4, point5);

        }


        shapeRenderer.end();
    }
}

// TODO: Challenge - Add truncated corners to the spiral
