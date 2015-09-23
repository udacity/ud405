package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Icicle {

    public static final float DROP_SPEED = 5.0f;

    private static final float HEIGHT = 1.0f;
    private static final float BASE = 0.5f;

    Vector2 position;

    public Icicle(Vector2 position){
        this.position = position;
    }

    public void update(float delta){
        position.y -= DROP_SPEED * delta;
    }

    public void render(ShapeRenderer renderer){
        renderer.translate(position.x, position.y, 0);
        renderer.triangle(0, 0, -BASE/2, HEIGHT, BASE/2, HEIGHT);
        renderer.identity();
    }


}
