package com.udacity.gamedev.inputtestbed;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * TODO: Check this out second
 *
 * The behavior of this ball should be familiar from the screensaver example. The two new things are
 * drag, and the periodic kicks the ball relieves to show off that drag.
 *
 * If we run this project, we see a little red ball that occasionally gets kicked in a random
 * direction, the slowly comes to a stop. It kinda looks like an air-hockey table. However, it's not
 * interactive yet. Let's fix that.
 */

public class BouncingBall {

    private static final Color COLOR = Color.RED;
    private static final float DRAG = 1.0f;

    // This constant defines how big the ball should be relative to the world size
    private static final float RADIUS_FACTOR = 1.0f / 20;

    private static final float KICK_INTERVAL = 3.0f;
    private static final float KICK_VELOCITY = 500.0f;

    long lastKick;

    float radius;
    Vector2 position;
    Vector2 velocity;


    public BouncingBall(Viewport viewport) {
        init(viewport);
    }

    public void init(Viewport viewport) {
        position = new Vector2(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);
        velocity = new Vector2();
        randomKick();
    }

    private void randomKick() {
        float angle = MathUtils.PI2 * MathUtils.random();
        velocity.x = KICK_VELOCITY * MathUtils.cos(angle);
        velocity.y = KICK_VELOCITY * MathUtils.sin(angle);
    }

    public void update(float delta, Viewport viewport) {

        float secondsSinceLastKick = MathUtils.nanoToSec * (TimeUtils.nanoTime() - lastKick);

        if (secondsSinceLastKick > KICK_INTERVAL) {
            lastKick = TimeUtils.nanoTime();
            randomKick();
        }

        // Drag is proportional to the current velocity
        velocity.x -= delta * DRAG * velocity.x;
        velocity.y -= delta * DRAG * velocity.y;

        position.x += delta * velocity.x;
        position.y += delta * velocity.y;
        radius = RADIUS_FACTOR * Math.min(viewport.getWorldWidth(), viewport.getWorldHeight());

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
        if (position.y - radius < 0) {
            position.y = radius;
            velocity.y = -velocity.y;
        }
        if (position.y + radius > viewportHeight) {
            position.y = viewportHeight - radius;
            velocity.y = -velocity.y;
        }
    }

    public void render(ShapeRenderer renderer) {
        // This takes advantage of AutoShapeType
        renderer.set(ShapeType.Filled);
        renderer.setColor(COLOR);
        renderer.circle(position.x, position.y, radius);
    }
}
