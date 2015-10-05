package com.udacity.gamedev.textdemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * TODO: Start here
 *
 * Let's do the minimal text example! Note that we use a SpriteBatch to draw, instead of a
 * ShapeRenderer.
 *
 * One more concept we haven't yet covered is filtering. That's how we determine what to do when we
 * draw a bitmap at a larger size than it was intended. Our options are Linear, and Nearest. Nearest
 * is what you want for pixel art, where you want things to maintain their sharp individual pixels.
 * For everything else, you want the Linear filter, as that will smooth between adjacent pixels.
 */

public class TextDemo extends ApplicationAdapter {

    SpriteBatch batch;
    BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        // Create the default font
        font = new BitmapFont();
        // Scale it up
        font.getData().setScale(3);
        // Set the filter
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
    }

    /**
     * Remember to dispose of SpriteBatches and fonts!
     */
    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // We begin batches just like with a ShapeRenderer, though there's no mode
        batch.begin();
        font.draw(batch, "Text", 100, 100);
        // Remember to end the batch
        batch.end();
    }
}
