package com.udacity.gamedev.smileyface;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class SmileyFace extends ApplicationAdapter {

    static final float WORLD_WIDTH = 10.0f;
    static final float WORLD_HEIGHT = 10.0f;
    static final float FACE_RADIUS = 0.8f * WORLD_WIDTH / 2;
    static final float EYE_OFFSET = 0.5f * FACE_RADIUS;
    static final float EYE_RADIUS = 0.2f * FACE_RADIUS;
    static final float MOUTH_OUTER_RADIUS = 0.8f * FACE_RADIUS;
    static final float MOUTH_INNER_RADIUS = 0.6f * FACE_RADIUS;
    static final int FACE_SEGMENTS = 20;
    static final int EYE_SEGMENTS = 20;
    static final int MOUTH_SEGMENTS = 20;
    ShapeRenderer renderer;
    OrthographicCamera camera;
    Viewport viewport;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.update();

    }

    /**
     * We'll often want to break up our drawing into separate functions, or different objects
     * entirely. This is easy to do, all we need to do is pass in our shaperenderer. All we need to do here is
     */

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeType.Filled);
        drawSmileyFace(renderer);
        renderer.end();


    }

    private void drawSmileyFace(ShapeRenderer renderer) {
        renderer.setColor(Color.YELLOW);
        renderer.circle(0, 0, FACE_RADIUS, FACE_SEGMENTS);
        renderer.setColor(Color.BLACK);
        renderer.circle(-EYE_OFFSET, EYE_OFFSET, EYE_RADIUS, EYE_SEGMENTS);
        renderer.circle(EYE_OFFSET, EYE_OFFSET, EYE_RADIUS, EYE_SEGMENTS);
        renderer.arc(0, 0, MOUTH_OUTER_RADIUS, 180, 180, MOUTH_SEGMENTS);
        renderer.setColor(Color.YELLOW);
        renderer.arc(0, 0, MOUTH_INNER_RADIUS, 180, 180, MOUTH_SEGMENTS);
    }


}
