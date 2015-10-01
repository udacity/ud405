package com.udacity.gamedev.inputtestbed;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * Created by silver on 9/28/15.
 */
public class BallScreen extends ScreenAdapter {

    public static final float WORLD_SIZE = 480.0f;

    ShapeRenderer renderer;
    ExtendViewport viewport;
    BouncingBall ball;

    private static final int BALL_COUNT = 20;
    Array<BouncingBall> balls;

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);
        ball = new BouncingBall(viewport);
        balls = new Array<BouncingBall>();
        for (int i = 0; i < BALL_COUNT; i++){
            balls.add(new BouncingBall(viewport));
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void render(float delta) {
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);


        renderer.setProjectionMatrix(viewport.getCamera().combined);
        ball.update(delta, viewport);
        ball.render(renderer);

        for (BouncingBall ball : balls){
            ball.update(delta, viewport);
            ball.render(renderer);
        }




    }
}
