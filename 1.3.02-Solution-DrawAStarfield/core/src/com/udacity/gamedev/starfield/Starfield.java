package com.udacity.gamedev.starfield;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * TODO: Start here!
 *
 * In this exercise we'll draw a star field of white points on a black
 * background. The number of points will be defined by a density parameter that states what
 * proportion of the pixels should be white.
 *
 * TODO: Run what you've got before making any changes
 *
 * One thing to note is we're using two new LibGDX classes, Array, and Vector2. We're using a custom
 * Array type so LibGDX can control the memory, and avoid unfortunate garbage collection events.
 * Vector2 is a super simple class for holding a 2D position. You can find more information in the
 * LibGDX Javadocs, or just by right clicking on the class name, and selecting Go To > Declaration.
 *
 * One new utility class we'll be using in this exercise is com.badlogic.gdx.math.Vector2. You can
 * find more information in the LibGDX Javadocs.
 *
 * Remember you can set up a Desktop run configuration using the dropdown in the toolbar, or you can
 * open the terminal at the bottom of the screen and run
 *
 * $ ./gradlew desktop:run
 */

public class Starfield extends ApplicationAdapter {

    private static final float STAR_DENSITY = 0.1f;
    ShapeRenderer shapeRenderer;
    Array<Vector2> stars;

    @Override
    public void create () {
        // TODO: Create a ShapeRenderer
        shapeRenderer = new ShapeRenderer();
        // TODO: Call initStars
        initStars(STAR_DENSITY);
    }

    public void initStars(float density){
        // TODO: Figure out how many stars to draw. You'll need the screen dimensions, which you can get using Gdx.graphics.getWidth() and Gdx.graphics.getHeight().
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        int starCount = (int)(screenHeight * screenWidth * density);
        // TODO: Create a new array of Vector2's to hold the star positions
        stars = new Array<Vector2>(starCount);
        // TODO: Use java.util.Random to fill the array of star positions
        Random random = new Random();
        for (int i = 0; i < starCount; i++){
            int x = random.nextInt(screenWidth);
            int y = random.nextInt(screenHeight);
            stars.add(new Vector2(x, y));
        }
    }

    @Override
    public void resize(int width, int height) {
        initStars(STAR_DENSITY);
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render () {
        // Wanna see what happens when we accidentally generate the stars every frame?
        // initStars(STAR_DENSITY);
        // TODO: Make the night sky black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Begin a shapeRenderer batch using ShapeType.Point
        shapeRenderer.begin(ShapeType.Point);
        // TODO: Loop through the star positions and use shapeRenderer to draw points
        for (Vector2 star : stars){
            shapeRenderer.point(star.x, star.y, 0);
        }
        // TODO: End the shapeRenderer batch
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        // TODO: Dispose of our ShapeRenderer
        shapeRenderer.dispose();
        super.dispose();
    }
}

// TODO: Challenge - Make technicolor stars using shapeRenderer.setColor();
// TODO: Challenge - Draw the Milky Way using a band of denser stars
