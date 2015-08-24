package com.udacity.gamedev.drawingrectangles;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DrawingRectangles extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;


    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(10, 10, 90, 90);
        shapeRenderer.rect(110, 10, 90, 90, Color.BLUE, Color.BLACK, Color.GREEN, Color.MAGENTA);
        shapeRenderer.rect(10, 110, 90, 90, Color.RED, Color.RED, Color.BLACK, Color.BLACK);
        shapeRenderer.rect(200,200,50,50,100,100,1,1,45);
        shapeRenderer.rect(200,200,50,50,100,100,1,1,45);


        shapeRenderer.rect(210, 10, 90, 90, Color.RED, Color.RED, Color.RED, Color.RED);
        shapeRenderer.rect(230, 30, 90, 90, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);

        shapeRenderer.setColor(Color.PURPLE);
        shapeRenderer.rectLine(0, 200, 200, 250, 10);

        final int steps = 25;
        Color rgbColor = new Color();
        for (int i = 0; i < steps; i++ ){

            Color.argb8888ToColor(rgbColor, java.awt.Color.HSBtoRGB(1.0f*i/steps, 1, 1));

            shapeRenderer.rect(300, 300, 50, 50, 100, 100, 1, 1, i * 90/steps, rgbColor, rgbColor, rgbColor, rgbColor);
        }

        shapeRenderer.end();

    }
}
