package com.udacity.gamedev.orthographicprojection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * TODO: Check this out second
 *
 * This class provides two cameras, a camera that draws pixel for pixel with the display, and a
 * closeup camera that can be moved around the screen and zoomed. When in overview mode, the field
 * of view of the closeup camera is drawn on the scene.
 *
 * Controls:
 *
 * Space: Switch between overview and closeup camera's
 *
 * Arrow keys: Move the closeup camera
 *
 * W/S: Grow and shrink the closeup camera's viewport height
 *
 * D/A: Grow and shrink the closeup camera's viewport width
 *
 * Z/X: Zoom in and out, respecting aspect ratio
 *
 * R: Reset
 *
 * F: Restore the proper aspect ratio
 */
public class DemoCamera extends InputAdapter {

    public static final String TAG = DemoCamera.class.getName();

    private static final float SCALE_RATE = 100;
    private static final float MOVE_RATE = 100;
    private static final float ROTATION_RATE = 45;
    private static final float INITIAL_ZOOM = 0.5f;

    private OrthographicCamera overviewCamera;
    private OrthographicCamera closeupCamera;
    private boolean inCloseupMode = true;

    public DemoCamera() {
        overviewCamera = new OrthographicCamera();
        closeupCamera = new OrthographicCamera();
        closeupCamera.setToOrtho(false, Gdx.graphics.getWidth() * INITIAL_ZOOM, Gdx.graphics.getHeight() * INITIAL_ZOOM);
        overviewCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void resize(float width, float height) {
        overviewCamera.setToOrtho(false, width, height);
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.SPACE) {
            inCloseupMode = !inCloseupMode;
        }
        // Reset
        if (keycode == Keys.R) {
            closeupCamera.setToOrtho(false, Gdx.graphics.getWidth() * INITIAL_ZOOM, Gdx.graphics.getHeight() * INITIAL_ZOOM);
        }
        if (keycode == Keys.F) {
            fixAspectRatio();
        }
        return super.keyUp(keycode);
    }

    public void update() {
        float delta = Gdx.graphics.getDeltaTime();

        // Movement
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            closeupCamera.translate(-MOVE_RATE * delta, 0);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            closeupCamera.translate(MOVE_RATE * delta, 0);
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            closeupCamera.translate(0, -MOVE_RATE * delta);
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            closeupCamera.translate(0, MOVE_RATE * delta);
        }

        // Rotation
        if (Gdx.input.isKeyPressed(Keys.Q)) {
            closeupCamera.rotate(-ROTATION_RATE * delta);
        }
        if (Gdx.input.isKeyPressed(Keys.E)) {
            closeupCamera.rotate(ROTATION_RATE * delta);
        }

        // Viewport size (ignoring aspect ratio)
        if (Gdx.input.isKeyPressed(Keys.W)) {
            closeupCamera.viewportHeight += SCALE_RATE * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            closeupCamera.viewportHeight -= SCALE_RATE * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.A)) {
            closeupCamera.viewportWidth -= SCALE_RATE * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            closeupCamera.viewportWidth += SCALE_RATE * delta;
        }

        // Zoom
        if (Gdx.input.isKeyPressed(Keys.Z)) {
            proportionalZoom(-delta);
        }

        if (Gdx.input.isKeyPressed(Keys.X)) {
            proportionalZoom(delta);
        }
        closeupCamera.update();
    }

    private void proportionalZoom(float delta) {
        float aspectRatio = overviewCamera.viewportWidth / overviewCamera.viewportHeight;
        closeupCamera.viewportWidth += SCALE_RATE * delta;
        closeupCamera.viewportHeight += SCALE_RATE / aspectRatio * delta;
    }

    private void fixAspectRatio() {
        float aspectRatio = overviewCamera.viewportWidth / overviewCamera.viewportHeight;
        closeupCamera.viewportHeight = closeupCamera.viewportWidth / aspectRatio;
        closeupCamera.update();
    }

    /**
     * Set's the ShapeRenderer's projection matrix depending on the mode of the demo camera.
     */
    public void setCamera(ShapeRenderer renderer) {
        if (inCloseupMode) {
            closeupCamera.update();
            renderer.setProjectionMatrix(closeupCamera.combined);
        } else {
            overviewCamera.update();
            renderer.setProjectionMatrix(overviewCamera.combined);
        }
    }

    /**
     * Renders a blue rectangle showing the field of view of the closeup camera
     */
    public void render(ShapeRenderer renderer) {
        if (!inCloseupMode) {
            // Figure out the location of the camera corners in the world
            Vector2 bottomLeft = myUnproject(closeupCamera, 0, closeupCamera.viewportHeight);
            Vector2 bottomRight = myUnproject(closeupCamera, closeupCamera.viewportWidth, closeupCamera.viewportHeight);
            Vector2 topRight = myUnproject(closeupCamera, closeupCamera.viewportWidth, 0);
            Vector2 topLeft = myUnproject(closeupCamera, 0, 0);

            // Draw a rectangle showing the closeup camera's field of view
            renderer.begin(ShapeType.Line);
            renderer.setColor(Color.BLUE);
            float[] poly = {bottomLeft.x, bottomLeft.y,
                    bottomRight.x, bottomRight.y,
                    topRight.x, topRight.y,
                    topLeft.x, topLeft.y
            };
            renderer.set(ShapeType.Line);
            renderer.polygon(poly);
            renderer.end();
        }
    }

    /**
     * Helper function to deal with the fact that unproject expects coordinates with positive y
     * pointing down.
     */
    private Vector2 myUnproject(OrthographicCamera camera, float x, float y) {
        Vector3 raw = camera.unproject(new Vector3(x, y + overviewCamera.viewportHeight - camera.viewportHeight, 0), 0, 0, camera.viewportWidth, camera.viewportHeight);
        return new Vector2(raw.x, raw.y);
    }

}
