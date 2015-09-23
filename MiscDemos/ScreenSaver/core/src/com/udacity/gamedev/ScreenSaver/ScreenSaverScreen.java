package com.udacity.gamedev.ScreenSaver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * Created by silver on 8/19/15.
 */
public class ScreenSaverScreen extends InputAdapter implements Screen {

    ShapeRenderer shapeRenderer;
    BouncingBall bouncingBall;
    OrthographicCamera camera;

    private static final float WORLD_SMALLEST_DIMENSION = 10.0f;

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        bouncingBall = new BouncingBall();
        camera = new OrthographicCamera();
    }

    @Override
    public void render(float delta) {
        camera.update();
        bouncingBall.update(delta, camera.viewportWidth, camera.viewportHeight);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setProjectionMatrix(camera.combined);
        bouncingBall.render(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        if (width > height){
            camera.setToOrtho(false, WORLD_SMALLEST_DIMENSION * width/height, WORLD_SMALLEST_DIMENSION);
        } else {
            camera.setToOrtho(false, WORLD_SMALLEST_DIMENSION, WORLD_SMALLEST_DIMENSION * height / width);
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
