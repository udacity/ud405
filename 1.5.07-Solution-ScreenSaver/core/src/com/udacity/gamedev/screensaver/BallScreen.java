package com.udacity.gamedev.screensaver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class BallScreen extends ScreenAdapter implements InputProcessor {

    public static final float WORLD_SIZE = 480.0f;
    // TODO: When a single ball is working try a bunch of balls.
    // TODO: See how many balls you can add before your computer starts slowing down.
    private static final int BALL_COUNT = 10000;
    ShapeRenderer renderer;
    ExtendViewport viewport;
    BouncingBall ball;
    Array<BouncingBall> balls;

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);
        ball = new BouncingBall(viewport);
        balls = new Array<BouncingBall>();
        for (int i = 0; i < BALL_COUNT; i++) {
            balls.add(new BouncingBall(viewport));
        }
        Gdx.input.setInputProcessor(this);
    }

    private void initBalls() {
        ball.init(viewport);
        for (BouncingBall ball : balls) {
            ball.init(viewport);
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        initBalls();
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
        renderer.begin(ShapeType.Filled);
        ball.update(delta, viewport);
        ball.render(renderer);


        for (BouncingBall ball : balls) {
            ball.update(delta, viewport);
            ball.render(renderer);
        }

        renderer.end();
    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.SPACE) {
            initBalls();
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
