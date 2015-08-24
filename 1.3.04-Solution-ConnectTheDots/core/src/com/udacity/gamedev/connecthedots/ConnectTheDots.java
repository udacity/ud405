package com.udacity.gamedev.connecthedots;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


/*
TODO: Start here

In this exercise we're going to connect the dots, but instead of drawing by hand, we're going to use ShapeRenderer and polyline.

 */

public class ConnectTheDots extends ApplicationAdapter {


    private static final float DOT_RADIUS = 3.0f;
    private SpriteBatch spriteBatch;
    private BitmapFont bitmapFont;
    private final Array<Vector2> dots = Dots.dots();
    private float[] floatDots;
    // TODO: Add a private ShapeRenderer
    private ShapeRenderer shapeRenderer;


    @Override
    public void create () {
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();
        floatDots = vector2ArrayToFloatArray(dots);
        // TODO: Initialize the shaperenderer
        shapeRenderer = new ShapeRenderer();
    }


    private float[] vector2ArrayToFloatArray(Array<Vector2> dots){
        // TODO: Complete this function to translate Array<Vector> to float[]

        float[] floatDots = new float[dots.size * 2];
        int i = 0;

        for (Vector2 dot : dots){
            floatDots[i++] = dot.x;
            floatDots[i++] = dot.y;
        }

        return floatDots;
    }

    @Override
    public void render () {
        // Make the background black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the dots
        shapeRenderer.begin(ShapeType.Filled);
        for (Vector2 dot : dots){
            shapeRenderer.circle(dot.x, dot.y, DOT_RADIUS);
        }
        shapeRenderer.end();

        // Draw the numbers
        spriteBatch.begin();
        Integer i = 1;
        for (Vector2 dot : dots){
            bitmapFont.draw(spriteBatch,i.toString(),dot.x+DOT_RADIUS, dot.y-DOT_RADIUS);
            i++;
        }
        spriteBatch.end();

        // TODO: Start a batch with Shapetype.Line
        shapeRenderer.begin(ShapeType.Line);

        // TODO: Draw a polyline using the dot positions as a float array
        if (floatDots.length > 3) {
            shapeRenderer.polyline(floatDots);
        }

        // TODO: End the batch
        shapeRenderer.end();


    }
}
