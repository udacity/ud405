package com.udacity.gamedev.screensaver;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

/**
 * This class represents a ball, bouncing around the screen. It maintains a position and velocity,
 * and it needs to knows how to update its position, based on how much time has passed.
 *
 * and has basic physics for colliding with the "walls" (the edges of the screen).
 */


public class BouncingBall {

    private static final Color COLOR = Color.RED;
    private static final float RADIUS_FACTOR = 1.0f / 20;
    private static final float KICK_VELOCITY = 500.0f;

    float radius;
    Vector2 position;
    Vector2 velocity;

    public BouncingBall(Viewport viewport) {
        init(viewport);
    }

    public void init(Viewport viewport) {
        position = new Vector2(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);
        velocity = new Vector2();
        radius = RADIUS_FACTOR * Math.min(viewport.getWorldWidth(), viewport.getWorldHeight());
        randomKick();
    }

    private void randomKick() {
        Random random = new Random();
        float angle = MathUtils.PI2 * random.nextFloat();
        velocity.x = KICK_VELOCITY * MathUtils.cos(angle);
        velocity.y = KICK_VELOCITY * MathUtils.sin(angle);
    }

    public void update(float delta, Viewport viewport) {

        // TODO: Update the ball's position using its velocity
        position.x += delta * velocity.x;
        position.y += delta * velocity.y;


        collideWithWalls(radius, viewport.getWorldWidth(), viewport.getWorldHeight());
    }

    private void collideWithWalls(float radius, float viewportWidth, float viewportHeight) {
        if (position.x - radius < 0) {
            position.x = radius;
            velocity.x = -velocity.x;
        }
        if (position.x + radius > viewportWidth) {
            position.x = viewportWidth - radius;
            velocity.x = -velocity.x;
        }

        // TODO: Make the ball bounce off the bottom of the screen
        if (position.y - radius < 0) {
            position.y = radius;
            velocity.y = -velocity.y;
        }

        // TODO: Make the ball bounce off the top of the screen
        if (position.y + radius > viewportHeight) {
            position.y = viewportHeight - radius;
            velocity.y = -velocity.y;
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.set(ShapeType.Filled);
        renderer.setColor(COLOR);
        renderer.circle(position.x, position.y, radius);
    }
}

