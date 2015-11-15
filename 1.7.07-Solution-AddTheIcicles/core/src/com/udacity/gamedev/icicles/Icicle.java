package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Icicle {

    public static final String TAG = Icicle.class.getName();

    Vector2 position;

    // TODO: Add Vector2 for velocity
    Vector2 velocity;

    public Icicle(Vector2 position) {
        this.position = position;
        // TODO: Initialize velocity
        this.velocity = new Vector2();
    }

    public void update(float delta) {
        // TODO: Update velocity using icicle accelration constant
        velocity.mulAdd(Constants.ICICLES_ACCELERATION, delta);

        // TODO: Update position using velocity
        position.mulAdd(velocity, delta);
    }

    public void render(ShapeRenderer renderer) {
        renderer.triangle(
                position.x, position.y,
                position.x - Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT,
                position.x + Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT
        );
    }
}
