package com.udacity.gamedev.rectangularflower;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class RectangularFlower extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rectLine(100, 0, 100, 300, 20);

        // TODO: Draw two leaves on the stem
        shapeRenderer.rect(100, 100, 0, 0, 40, 40, 1, 1, 135);
        shapeRenderer.rect(100, 150, 0, 0, 30, 30, 1, 1, 315);

        // TODO: Set the active color to yellow
        shapeRenderer.setColor(Color.YELLOW);

        // TODO: Draw the head of the flower using a loop
        for (int petal = 0; petal < 20; petal ++){
            shapeRenderer.rect(100, 300, 0, 0, 40, 40, 1, 1, 360*petal/20.0f);
        }

        shapeRenderer.end();
    }
}
