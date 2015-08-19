package com.udacity.gamedev.ScreenSaver;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by silver on 8/19/15.
 */
public class BouncingBall {

    Vector2 position;
    Vector2 velocity;
    float radius;

    public BouncingBall(){
        init();
    }

    private void init(){
        position = new Vector2(5,5);
        velocity = new Vector2(5, 5);
        radius = .5f;
    }

    public void update(float delta, float viewportWidth, float viewportHeight){
        position.x += delta * velocity.x;
        position.y += delta * velocity.y;
        collideWithWalls(viewportWidth, viewportHeight);
    }

    private void collideWithWalls(float viewportWidth, float viewportHeight){
        if (position.x - radius < 0){
            position.x = radius;
            velocity.x = -velocity.x;
        }
        if (position.x + radius > viewportWidth){
            position.x = viewportWidth - radius;
            velocity.x = -velocity.x;
        }
        if (position.y - radius < 0){
            position.y = radius;
            velocity.y = -velocity.y;
        }
        if (position.y + radius > viewportHeight){
            position.y = viewportHeight - radius;
            velocity.y = -velocity.y;
        }
    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.set(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(position.x, position.y, radius, 20);
    }
}
