package com.udacity.gamedev.inputtestbed;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;


public class BouncingBall extends InputAdapter {

    private static final Color COLOR = Color.RED;
    private static final float DRAG = 1.0f;
    private static final float RADIUS_FACTOR = 1.0f / 20;
    private static final float RADIUS_GROWTH_RATE = 1.5f;
    private static final float MIN_RADIUS_MULTIPLIER = 0.1f;
    private static final float ACCELERATION = 500.0f;
    private static final float MAX_SPEED = 400.0f;

    private static final float KICK_INTERVAL = 3.0f;
    private static final float KICK_VELOCITY = 500.0f;

    long lastKick;

    float baseRadius;
    float radiusMultiplier;

    Vector2 position;
    Vector2 velocity;


    public BouncingBall(Viewport viewport) {
        init(viewport);
    }

    public void init(Viewport viewport) {
        position = new Vector2(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);
        velocity = new Vector2();
        baseRadius = RADIUS_FACTOR * Math.min(viewport.getWorldWidth(), viewport.getWorldHeight());
        radiusMultiplier = 1;
        randomKick();
    }

    private void randomKick() {
        Random random = new Random();
        float angle = MathUtils.PI2 * random.nextFloat();
        velocity.x += KICK_VELOCITY * MathUtils.cos(angle);
        velocity.y += KICK_VELOCITY * MathUtils.sin(angle);
    }



    public void update(float delta, Viewport viewport) {

        // Growing and shrinking
        if (Gdx.input.isKeyPressed(Keys.Z)){
            radiusMultiplier += delta * RADIUS_GROWTH_RATE;
        }
        if (Gdx.input.isKeyPressed(Keys.X)){
            radiusMultiplier -= delta * RADIUS_GROWTH_RATE;
            radiusMultiplier = Math.max(radiusMultiplier, MIN_RADIUS_MULTIPLIER);
        }

        // Movement
        if (Gdx.input.isKeyPressed(Keys.LEFT)){
            velocity.x -= delta * ACCELERATION;

        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)){
            velocity.x += delta * ACCELERATION;

        }
        if (Gdx.input.isKeyPressed(Keys.UP)){
            velocity.y += delta * ACCELERATION;

        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)){
            velocity.y -= delta * ACCELERATION;

        }

        velocity.clamp(0, MAX_SPEED);






        float secondsSinceLastKick = MathUtils.nanoToSec * (TimeUtils.nanoTime() - lastKick);

        if (secondsSinceLastKick > KICK_INTERVAL) {
            lastKick = TimeUtils.nanoTime();
//            randomKick();
        }

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

        if (keycode == Keys.SPACE){
            randomKick();
        }


        return true;
    }
}
