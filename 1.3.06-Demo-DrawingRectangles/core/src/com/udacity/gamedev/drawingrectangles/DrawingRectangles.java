package com.udacity.gamedev.drawingrectangles;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TODO: Start here!
 *
 * In this demo, we're going to use ShapeRenderer to draw some rectangles! The API for drawing
 * rectangles gets a little complicated, just because there are so many options. As always, the
 * Javadocs are super useful.
 *
 * Also, if you want to figure out what the arguments are for a particular invocation of a function,
 * hold Command and mouse over it!
 *
 * One tricky argument to figure out is the origin. That's only relevant when we're using one of the
 * versions of rect that can be rotated and scaled, and it determined about which point the rotation
 * and scaling is going to happen.
 *
 * In addition to ShapeRenderer.rect(), we're also going to explore ShapeRenderer.rectLine(). One of
 * the quirks of OpenGL is that it knows how to draw filled shapes, and it knows how to draw lines
 * that are a single pixel wide, but it doesn't know how to draw thick lines. To get around this
 * restriction, we can make a thick line out of a skinny filled in rectangle.
 */


public class DrawingRectangles extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;


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
        // As I'm sure you're used to by now, we always have to clear the screen first
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Rectangles can be drawn with either ShapeType.Filled or ShapeType.Line
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);

        // Let's just draw a simple square to start
        shapeRenderer.rect(10, 10, 90, 90);

        // We can do even more interesting things with colors, like specifying a color for each corner!
        shapeRenderer.rect(110, 10, 90, 90, Color.BLUE, Color.BLACK, Color.GREEN, Color.MAGENTA);
        shapeRenderer.rect(10, 110, 90, 90, Color.RED, Color.RED, Color.BLACK, Color.BLACK);

        // What happens when we draw two filled in shapes where they overlap?
        shapeRenderer.rect(210, 10, 90, 90, Color.RED, Color.RED, Color.RED, Color.RED);
        shapeRenderer.rect(230, 30, 90, 90, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);

        // We can also rotate and scale rectangles!
        // We can put the rotation origin on the corner
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(10, 300, 50, 50, 100, 100, 0.5f, 1, 45);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(10, 300, 50, 50, 100, 100, 0.5f, 1, 135);

        // Or we can put the rotation origin in the center
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(200, 300, 0, 0, 100, 100, 0.5f, 1, 45);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(200, 300, 0, 0, 100, 100, 0.5f, 1, 225);

        // Let's try making a thick line
        shapeRenderer.setColor(Color.PURPLE);
        shapeRenderer.rectLine(0, 200, 200, 250, 10);

        // Alright, time for some silliness. Let's make a rainbow flower
        final int steps = 25;
        Color rgbColor = new Color();
        for (int i = 0; i < steps; i++) {
            // This mess converts from a position on the rainbow to an RGB color
            Color.argb8888ToColor(rgbColor, java.awt.Color.HSBtoRGB(1.0f * i / steps, 1, 1));

            // Each rectangle is a little bit rotated from the previous one
            shapeRenderer.rect(300, 300, 50, 50, 100, 100, 1, 1, i * 90 / steps, rgbColor, rgbColor, rgbColor, rgbColor);
        }

        // Always remember to end your batches!
        shapeRenderer.end();
    }
}
