package com.udacity.gamedev.viewportsdemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


/**
 * TODO: Start Here!
 *
 * In this demo we'll explore the effect of using a Viewport to manage a camera.
 *
 * We start with a world containing a 16x9 checkerboard, with an apron of neon green.
 */



public class ViewportsDemo extends ApplicationAdapter {

    public static final String TAG = ViewportsDemo.class.getName();

    private static final float WORLD_WIDTH = 16;
    private static final float WORLD_HEIGHT = 9;

    OrthographicCamera camera;
    Viewport viewport;

    ShapeRenderer renderer;

    /**
     * Uncomment the following viewports one at a time, and check out the effect when you resize the desktop window.
     */
    @Override
    public void create() {
        camera = new OrthographicCamera();

        // Makes the size of the world match the size of the screen
        viewport = new ScreenViewport(camera);

        // Make the world fill the screen, regardless of aspect ratio
//        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        // Make the world fill the screen, maintaining aspect ratio, but bits of the world may be cut off
//        viewport = new FillViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        // Fit the world inside the screen, adding black bars to pad out the extra space, maintaining aspect ratio
//        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        // Make the short axis of the world larger to fill the screen, maintaining aspect ratio
//        viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);


        viewport.setScreenBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        renderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    /**
     * When the screen is resized, we need to inform the viewport. Note that when using an
     * ExtendViewport, the world size might change as well.
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        Gdx.app.log(TAG, "Viewport world dimensions: (" + viewport.getWorldHeight() + ", " + viewport.getWorldWidth() + ")");
    }

    /**
     * When using a viewport, instead of calling camera.update(), we just call viewport.apply()
     */
    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.GREEN);
        renderer.rect(-10, -10, WORLD_WIDTH + 20, WORLD_HEIGHT + 20);
        renderWorld();
        renderer.end();
    }

    void renderWorld() {
        for (int yStart = 0; yStart < WORLD_HEIGHT; yStart += 1) {
            for (int xStart = 0; xStart < WORLD_WIDTH; xStart += 1) {
                if ((yStart + xStart) % 2 == 0) {
                    renderer.setColor(Color.WHITE);
                } else {
                    renderer.setColor(Color.BLACK);
                }
                renderer.rect(xStart, yStart, 1, 1);
            }
        }
    }
}
