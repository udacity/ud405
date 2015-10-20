package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Icicle {

    public static final String TAG = Icicle.class.getName();

    // TODO: Add a Vector2 position
    Vector2 position;

    // TODO: Add a constructor that sets the position
    public Icicle(Vector2 position) {
        this.position = position;
    }

    // TODO: Add a render function that takes a ShapeRenderer

    public void render(ShapeRenderer renderer) {

        // TODO: Set the ShapeRenderer's color
        renderer.setColor(Constants.ICICLE_COLOR);

        // TODO: Set the ShapeType
        renderer.set(ShapeType.Filled);

        // TODO: Draw the icicle using the size constants
        renderer.triangle(
                position.x, position.y,
                position.x - Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT,
                position.x + Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT
        );
    }
}
