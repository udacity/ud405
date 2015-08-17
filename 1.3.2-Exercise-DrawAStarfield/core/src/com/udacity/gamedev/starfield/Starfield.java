package com.udacity.gamedev.starfield;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/*
    TODO: Read description

    In this exercise we'll draw a star field of white points on a black background. The number of points will be defined by a density parameter that states what proportion of the pixels should be on.

    TODO: Run what you've got before making any changes

 */


public class Starfield extends ApplicationAdapter {

    private static final float STAR_DENSITY = 0.01f;
    ShapeRenderer shapeRenderer;
    Array<Vector2> stars;

    @Override
    public void create () {
        // TODO: Create a ShapeRenderer

        // TODO: Call initStars

    }

    public void initStars(float density){
        // TODO: Figure out how many stars to draw. You'll need the screen dimensions, which you can get using Gdx.graphics.getWidth() and Gdx.graphics.getHeight().

        // TODO: Create a new array of Vector2's to hold the star positions

        // TODO: Use Random to fill the array of star positions

    }

    @Override
    public void render () {
        // TODO: Make the night sky black
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Begin a shapeRenderer batch using ShapeType.Point

        // TODO: Loop through the star positions and use shapeRenderer to draw points

        // TODO: End the shapeRenderer batch

    }

    @Override
    public void dispose() {
        // TODO: Dispose of our ShapeRenderer

        super.dispose();
    }
}
