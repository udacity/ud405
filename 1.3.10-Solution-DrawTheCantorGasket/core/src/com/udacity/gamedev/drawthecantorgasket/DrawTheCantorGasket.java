package com.udacity.gamedev.drawthecantorgasket;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DrawTheCantorGasket extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;
    private final static int RECURSIONS = 5;


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
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        float x = screenWidth/2 - screenHeight/2;
        shapeRenderer.rect(x, 0, screenHeight, screenHeight);
        shapeRenderer.setColor(Color.BLACK);
        punchCantorGasket(x, 0, screenHeight, RECURSIONS);
        shapeRenderer.end();
    }


    private void punchCantorGasket(float x, float y, float size, int recursions){
        if (recursions == 0) {
            return;
        }
        Color color = new Color();
        Color.argb8888ToColor(color, java.awt.Color.HSBtoRGB(1.0f*recursions/RECURSIONS, 1, 1));
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x + size / 3, y + size / 3, size / 3, size / 3);
        float newSize = size/3;
        punchCantorGasket(x, y, newSize, recursions-1);
        punchCantorGasket(x + newSize, y, newSize, recursions-1);
        punchCantorGasket(x + 2 * newSize, y, newSize, recursions-1);
        punchCantorGasket(x, y + newSize, newSize, recursions-1);
        punchCantorGasket(x + 2 * newSize, y + newSize, newSize, recursions-1);
        punchCantorGasket(x, y + 2 * newSize, newSize, recursions-1);
        punchCantorGasket(x + newSize, y + 2 * newSize, newSize, recursions-1);
        punchCantorGasket(x + 2 * newSize, y + 2 * newSize, newSize, recursions-1);
    }
}
