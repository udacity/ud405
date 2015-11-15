package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Icicles {

    public static final String TAG = Icicles.class.getName();

    // TODO: Add an array of icicles and a viewport

    Viewport viewport;

    public Icicles(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        // TODO: Initialize the array of icicles

    }

    public void update(float delta) {
        // TODO: Replace hard-coded spawn rate with a constant
        if (MathUtils.random() < delta * 5) {
            // TODO: Add a new icicle at the top of the viewport at a random x position
        }

        // TODO: Update each icicle

    }

    public void render(ShapeRenderer renderer) {
        // TODO: Set ShapeRenderer Color


        // TODO: Render each icicle

    }
}
