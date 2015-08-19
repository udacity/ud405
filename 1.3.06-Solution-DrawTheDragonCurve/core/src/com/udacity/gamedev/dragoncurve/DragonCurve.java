package com.udacity.gamedev.dragoncurve;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DragonCurve extends ApplicationAdapter {

    private float[] dragonCurve;
    private static final int RECURSIONS = 10;

    private ShapeRenderer shapeRenderer;

    @Override
    public void create () {
        dragonCurve = DragonCurveGenerator.generateDragonCurve(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), RECURSIONS);
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.polyline(dragonCurve);

        shapeRenderer.end();
    }
}
