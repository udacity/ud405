package com.udacity.gamedev.fallingobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class Boulder {

    private static final float RADIUS_RATIO = 0.01f;
    private static final Color COLOR = Color.RED;

    // TODO: Declare a constant holding the acceleration due to gravity. -20 works well
    private static final float GRAVITY = -20.0f;

    Vector2 position;
    Vector2 velocity;
    float radius;

    public Boulder(Viewport viewport){
        init(viewport);

    }

    public void init(Viewport viewport){
        position = new Vector2();

        // TODO: Set the initial velocity to zero in both directions
        velocity = new Vector2(0, 0);

        radius = viewport.getWorldWidth() * RADIUS_RATIO;
        position.y = viewport.getWorldHeight() + radius;
        Random random = new Random();
        position.x = random.nextFloat() * (viewport.getWorldWidth() - 2 * radius) + radius;
    }


    public void update(float delta){
        // TODO: Apply gravitational acceleration to the vertical velocity
        velocity.y += delta * GRAVITY;

        position.x += delta * velocity.x;
        position.y += delta * velocity.y;
    }

    public boolean isBelowScreen(){
        return position.y < -radius;
    }

    public void render(ShapeRenderer renderer){
        renderer.set(ShapeType.Filled);
        renderer.setColor(COLOR);
        renderer.circle(position.x, position.y, radius);
    }

    // TODO: Challenge - Add wind blowing from the side
}
