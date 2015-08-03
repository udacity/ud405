package com.udacity.gamedev.icicles.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by silver on 8/2/15.
 */
public class WorldRenderer implements Disposable {

    public static final String LOG_TAG = WorldRenderer.class.getName();

    private static final Color backgroundColor = new Color(Color.BLUE);

    private ShapeRenderer shapeRenderer;
    private WorldController worldController;

    public WorldRenderer(WorldController worldController){
        this.worldController = worldController;
        shapeRenderer = new ShapeRenderer();
    }

    public void render(){
        Gdx.gl20.glClearColor(backgroundColor.r, backgroundColor.g, backgroundColor.b, backgroundColor.a);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        worldController.world.render(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
