package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;


public class Player extends InputAdapter {

    private static final Color PLAYER_COLOR = Color.WHITE;
    private static final int HEAD_SEGMENTS = 20;
    private static final float ARROW_VELOCITY = 6;

    public static final float HEAD_RADIUS = 0.5f;

    public static final float HEAD_HEIGHT = 1.0f;
    float headXPosition;
    Vector2 velocity;

    public Player(){
        init();
    }

    public void init(){
        headXPosition = Constants.WORLD_WIDTH / 2;
    }

    public void update(float delta){
        if (Gdx.input.isKeyPressed(Keys.LEFT)){
            headXPosition -= ARROW_VELOCITY * delta;
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)){
            headXPosition += ARROW_VELOCITY * delta;
        }



        if (headXPosition - HEAD_RADIUS < 0){
            headXPosition = HEAD_RADIUS;
        } else if (headXPosition + HEAD_RADIUS > Constants.WORLD_WIDTH) {
            headXPosition = Constants.WORLD_WIDTH - HEAD_RADIUS;

        }

    }

    public void render(ShapeRenderer renderer){
        renderer.set(ShapeType.Filled);
        renderer.setColor(PLAYER_COLOR);
        renderer.circle(headXPosition, HEAD_HEIGHT, HEAD_RADIUS, HEAD_SEGMENTS);

    }


}
