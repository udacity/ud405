package com.udacity.gamedev.checkerboardsetup;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class CheckerboardGame extends ApplicationAdapter {

    ShapeRenderer renderer;
    SpriteBatch batch;

    @Override
    public void create () {
        renderer = new ShapeRenderer();
        batch = new SpriteBatch();
    }

    @Override
    public void dispose() {
        renderer.dispose();
        batch.dispose();
        super.dispose();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Vector2 bottomLeft = new Vector2(0, 0);
        Vector2 topRight = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        renderer.begin(ShapeType.Filled);
        batch.begin();
        CheckerBoard.render(renderer, batch, bottomLeft, topRight, 100);
        renderer.end();
        batch.end();
    }
}
