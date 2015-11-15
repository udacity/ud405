package com.udacity.gamedev.dragoncurve;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/*

TODO: Start here

The Dragon Curve is a fractal made by a single line. It is formed of a series of turns, which can be constructed in the following way:

0: L
1: L + L + R
2: LLR + L + LRR
3: LLRLLRR + L + LLRRLRR

The nth dragon curve is the n-1th dragon curve plus L, plus the n-1th dragon curve reversed and reflected.

In this project we have split up the tasks of generating and drawing the dragon curve into separate classes.

 */

public class DragonCurve extends ApplicationAdapter {

    private float[] dragonCurve;
    // Any more than 10 and we'll need to break up the polyline into multiple lines
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
