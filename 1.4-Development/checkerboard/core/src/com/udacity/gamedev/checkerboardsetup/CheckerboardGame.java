package com.udacity.gamedev.checkerboardsetup;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;






public class CheckerboardGame extends ApplicationAdapter {

    ShapeRenderer renderer;

    static final float WORLD_WIDTH = 20;
    static final float WORLD_HEIGHT = 15;

    @Override
    public void create () {
        renderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        renderer.dispose();
        super.dispose();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Vector2 bottomLeft = new Vector2(0, 0);
        Vector2 topRight = new Vector2(WORLD_WIDTH, WORLD_HEIGHT);

        renderer.begin(ShapeType.Filled);
        CheckerBoard.render(renderer, bottomLeft, topRight, 1);
        renderer.end();
    }
}
