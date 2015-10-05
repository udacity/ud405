package com.udacity.gamedev.inputtestbed;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;


public class BouncingBall extends InputAdapter {

    private static final Color COLOR = Color.RED;
    private static final float DRAG = 1.0f;
    private static final float RADIUS_FACTOR = 1.0f / 20;
    private static final float RADIUS_GROWTH_RATE = 1.5f;
    private static final float MIN_RADIUS_MULTIPLIER = 0.1f;
    private static final float ACCELERATION = 500.0f;
    private static final float MAX_SPEED = 4000.0f;
    private static final float KICK_VELOCITY = 500.0f;
    private static final float FLICK_MULTIPLIER = 5.0f;


    Vector2 flickStart;
    boolean flicking = false;

    float baseRadius;
    float radiusMultiplier;

    Vector2 position;
    Vector2 velocity;

    Viewport viewport;


    public BouncingBall(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);
        velocity = new Vector2();
        baseRadius = RADIUS_FACTOR * Math.min(viewport.getWorldWidth(), viewport.getWorldHeight());
        radiusMultiplier = 1;
    }

    private void randomKick() {
        Random random = new Random();
        float angle = MathUtils.PI2 * random.nextFloat();
        velocity.x += KICK_VELOCITY * MathUtils.cos(angle);
        velocity.y += KICK_VELOCITY * MathUtils.sin(angle);
    }


    public void update(float delta) {

        // Growing and shrinking
        if (Gdx.input.isKeyPressed(Keys.Z)) {
            radiusMultiplier += delta * RADIUS_GROWTH_RATE;
        }
        if (Gdx.input.isKeyPressed(Keys.X)) {
            radiusMultiplier -= delta * RADIUS_GROWTH_RATE;
            radiusMultiplier = Math.max(radiusMultiplier, MIN_RADIUS_MULTIPLIER);
        }

        // Movement
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            velocity.x -= delta * ACCELERATION;

        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            velocity.x += delta * ACCELERATION;

        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            velocity.y += delta * ACCELERATION;

        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            velocity.y -= delta * ACCELERATION;

        }

        velocity.clamp(0, MAX_SPEED);

        velocity.x -= delta * DRAG * velocity.x;
        velocity.y -= delta * DRAG * velocity.y;

        position.x += delta * velocity.x;
        position.y += delta * velocity.y;


        collideWithWalls(baseRadius * radiusMultiplier, viewport.getWorldWidth(), viewport.getWorldHeight());
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
        renderer.circle(position.x, position.y, baseRadius * radiusMultiplier);
    }


    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Keys.SPACE) {
            randomKick();
        }

        if (keycode == Keys.R) {
            init();
        }

        return true;
    }

    /**
     * TODO: Check out what happens when a touch starts
     *
     * When a touch starts, we first need to translate the point that the user touched from screen
     * coordinates to world coordinates. Since the viewport handles the projection from world
     * coordinates to screen coordinates, it also has an unproject() method that does the opposite.
     *
     * Next we use the Vector2.dst() method to see if the distance between the touch and the
     * position of the ball is smaller than the ball's radius. If the touch is inside the radius,
     * then we start a flick, and save the world coordinates of the touch.
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 worldClick = viewport.unproject(new Vector2(screenX, screenY));
        if (worldClick.dst(position) < baseRadius * radiusMultiplier) {
            flicking = true;
            flickStart = worldClick;
        }
        return true;
    }

    /**
     * TODO: Check out what happens when a touch ends
     *
     * If we were in the process of flicking the ball, we calculate the vector between the start of
     * the flick and the end of the flick. Remember that the incoming position of the touch is in
     * screen coordinates, so we need to use the viewport to unproject that position into world
     * coordinates.
     *
     * Then we add that flick vector to the velocity of the ball, times some multiplier. Give it a
     * try!
     */

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (flicking) {
            flicking = false;
            Vector2 flickEnd = viewport.unproject(new Vector2(screenX, screenY));
            Vector2 flickVector = new Vector2(flickEnd.x - flickStart.x, flickEnd.y - flickStart.y);
            velocity.mulAdd(flickVector, FLICK_MULTIPLIER);

        }

        return true;
    }
}
