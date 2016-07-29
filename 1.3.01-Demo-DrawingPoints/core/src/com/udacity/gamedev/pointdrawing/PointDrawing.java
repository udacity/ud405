package com.udacity.gamedev.pointdrawing;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TODO: Start here to learn more about ApplicationListener and ShapeRenderer
 *
 * In this demo we're exploring ApplicationListener and ShapeRenderer. ApplicationListener is the
 * entry point into your code. To get some insight into the lifecycle of this object, we've inserted
 * log messages in each of the six required methods.
 *
 * Logging is provided by the host application, and will appear in whatever output stream makes
 * sense for that application. For the desktop version, it'll be console output, for the Android
 * version, it'll go through the usual Android LogCat system.
 *
 * After browsing through this file, try running the game! You can run the desktop version by
 * opening up the terminal at the bottom of the window, and running:
 *
 * $ ./gradlew desktop:run
 *
 * There's a point on screen! And log messages showing the lifecycle of the ApplicationListener.
 *
 * Aside: Sorry for the abuse of Javadoc comments. Android Studio does a nice job hard wrapping
 * them.
 */
public class PointDrawing implements ApplicationListener {

    // Always tag your log messages!
    public static final String TAG = PointDrawing.class.getName();
    private ShapeRenderer shapeRenderer;

    /**
     * This is called when the application is ready for us to start up. Anything you'd do in a
     * constructor, do in create instead.
     */
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
     * When Java finds that it's running out of memory, it performs a garbage collection to free up
     * memory held by objects that are no longer in use. Unfortunately, garbage collection is slow,
     * and nothing else can happen while the collection is in process. In a game, this can mean a
     * momentary freeze, which players hate with a burning passion. LibGDX does two things to avoid
     * this. First, there are a number of places where we need to manage our own memory. Since we
     * created a ShapeRenderer, we also need to dispose of it, as shown below.
     *
     * The other way LibGDX avoids garbage collection hangs is by providing a ton of custom
     * collections that cleverly manage memory. We'll be using some of those soon.
     *
     */
    @Override
    public void dispose() {
        Gdx.app.log(TAG, "Application Listener Disposed of");
        shapeRenderer.dispose();
    }

    /**
     * Render is where the action happens. By default, render will get called 60 times a second, and
     * it's the cue that it's time for our game to update itself and draw a new frame.
     */
    @Override
    public void render() {
        // Set the background color to opaque black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        // Actually tell OpenGL to clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // First we begin a batch of points
        shapeRenderer.begin(ShapeType.Point);
        // Then we draw a point
        shapeRenderer.point(100, 100, 0);
        // And make sure we end the batch
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
