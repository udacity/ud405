package com.udacity.gamedev.pointdrawing;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/*
TODO: Note that we're using ApplicationAdapter instead of ApplicationListener

In this demo we're using ShapeRenderer to draw a single point


*/
public class PointDrawing extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        // TODO: Never allocate anything in render, since that gets called 60 times a second
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        //TODO: 2. Since an inopportune garbage collection can kill a ton of frames, we have to manage our own memory in some places. Note that LibGDX also provides a bunch of memory managed collections to help with this.
        shapeRenderer.dispose();
        super.dispose();
    }

    @Override
    public void render() {
        // TODO:  Set the background color to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeType.Point);
        shapeRenderer.point(100, 100, 0);
        shapeRenderer.end();
    }
}
