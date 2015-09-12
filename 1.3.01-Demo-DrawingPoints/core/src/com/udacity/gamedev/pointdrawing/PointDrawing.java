package com.udacity.gamedev.pointdrawing;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TODO: Start here
 *
 * In this demo we're exploring ApplicationListener and ShapeRenderer. ApplicationListener is the
 * entry point into your code. To get some insight into the lifecycle of this object, we've inserted log messages in each of the six required methods.
 *
 *
 * In this demo we're using LibGDX's ShapeRenderer class to draw. ShapeRenderer wraps calls to OpenGL, which is the API that graphics cards
 *
 * Aside: Sorry for the abuse of Javadoc comments. Android Studio does a nice job hard wrapping
 * them.
 */
public class PointDrawing implements ApplicationListener {

    public static final String TAG = PointDrawing.class.getName();
    private ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        Gdx.app.log(TAG, "Application Listener Created");
        // Never allocate anything in render, since that gets called 60 times a second
        shapeRenderer = new ShapeRenderer();
    }

    /**
     * resize gets called right after create, and any time the screen size changes. This can happen
     * when a mobile device rotates, or if you drag around the size of the desktop window. We'll be
     * responding to resize in more interesting ways in the next level.
     */
    @Override
    public void resize(int width, int height) {
        Gdx.app.log(TAG, "Resized to width = " + width + " height = " + height);
    }


    /**
     * Since an inopportune garbage collection can kill a ton of frames, we have to manage our own
     * memory in some places. Note that LibGDX also provides a bunch of memory managed collections
     * to help with this. In this case, we created an instance of shapeRenderer, so we have to clean
     * it up.
     */
    @Override
    public void dispose() {
        Gdx.app.log(TAG, "Application Listener Disposed of");
        shapeRenderer.dispose();
    }

    /**
     * Render is where the action happens. By default, render will get called 60 times a second, and
     * it's the cue that it's time for our game to update itself and draw a new frame. To draw a new
     * frame, the usual first step is to
     */
    @Override
    public void render() {
        // Set the background color to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // First we begin a
        shapeRenderer.begin(ShapeType.Point);
        shapeRenderer.point(100, 100, 0);
        shapeRenderer.end();
    }

    /**
     * Called when the game loses focus, or when it's about to be destroyed. This is the time to
     * save any state you want to persist.
     */
    @Override
    public void pause() {
        Gdx.app.log(TAG, "Paused");
    }

    /**
     * Called when the game regains focus after being paused. This is mostly relevant on Android,
     * where the game can be paused by pressing the home button, but dispose is not called. When the
     * game is relaunched, resume will be called.
     */
    @Override
    public void resume() {
        Gdx.app.log(TAG, "Resumed");
    }
}
