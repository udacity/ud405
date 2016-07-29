package com.udacity.gamedev.inputtestbed;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;


public class BouncingBall {

    private static final Color COLOR = Color.RED;
    private static final float DRAG = 1.0f;
    private static final float BASE_RADIUS = 20.0f;
    private static final float RADIUS_GROWTH_RATE = 2.5f;
    private static final float MIN_RADIUS_MULTIPLIER = 0.1f;

    private static final float KICK_INTERVAL = 3.0f;
    private static final float KICK_VELOCITY = 500.0f;

    long lastKick;


    float radiusMultiplier;
    float radius;

    Vector2 position;
    Vector2 velocity;


    public BouncingBall(Viewport viewport) {
        init(viewport);
    }

    public void init(Viewport viewport) {
        position = new Vector2(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);
        velocity = new Vector2();
        radiusMultiplier = 1;
        radius = BASE_RADIUS * radiusMultiplier;
        randomKick();
    }

    private void randomKick() {
        Random random = new Random();
        float angle = MathUtils.PI2 * random.nextFloat();
        velocity.x = KICK_VELOCITY * MathUtils.cos(angle);
        velocity.y = KICK_VELOCITY * MathUtils.sin(angle);
    }

    /**
     * TODO: Here's the polling action
     *
     * We've defined a base radius for the ball, and we determine the actual radius by multiplying
     * the base radius by the radius multiplier. We start the radius multiplier at 1.0, and then we
     * adjust it up or down each frame based on whether or not the Z or X keys are pressed. We also
     * have a radius growth rate constant that determines how fast the radius multiplier changes.
     *
     * Note that we also make sure the radius multiplier can't fall below a certain minimum. That
     * way we don't end up with an invisible ball with a negative radius.
     */
    public void update(float delta, Viewport viewport) {

        if (Gdx.input.isKeyPressed(Keys.Z)) {
            radiusMultiplier += delta * RADIUS_GROWTH_RATE;
        }
        if (Gdx.input.isKeyPressed(Keys.X)) {
            radiusMultiplier -= delta * RADIUS_GROWTH_RATE;
            radiusMultiplier = Math.max(radiusMultiplier, MIN_RADIUS_MULTIPLIER);
        }
        radius = radiusMultiplier * BASE_RADIUS;

        float secondsSinceLastKick = MathUtils.nanoToSec * (TimeUtils.nanoTime() - lastKick);

        if (secondsSinceLastKick > KICK_INTERVAL) {
            lastKick = TimeUtils.nanoTime();
            randomKick();
        }

        velocity.x -= delta * DRAG * velocity.x;
        velocity.y -= delta * DRAG * velocity.y;

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
        renderer.set(ShapeType.Filled);
        renderer.setColor(COLOR);
        renderer.circle(position.x, position.y, radius);
    }


}
