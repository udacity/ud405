package com.udacity.gamedev.connecthedotsgenerator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Arrays;

public class ConnectTheDotsGenerator extends ApplicationAdapter implements InputProcessor {

    public static final String LOG_TAG = ConnectTheDotsGenerator.class.getName();
    private static final float DOT_RADIUS = 3.0f;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private BitmapFont bitmapFont;
    Array<Vector2> dots;


    @Override
    public void create () {
        Gdx.input.setInputProcessor(this);
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        bitmapFont = new BitmapFont();
        resetDots();
    }

    private void resetDots(){
        dots = new Array<Vector2>();
    }

    private float[] dotsAsFloatArray(){

        float[] floatDots = new float[dots.size * 2];
        int i = 0;

        for (Vector2 dot : dots){
            floatDots[i++] = dot.x;
            floatDots[i++] = dot.y;
        }

        return floatDots;
    }

    private void logDotsAsFloatArray(){
        Gdx.app.log(LOG_TAG, Arrays.toString(dotsAsFloatArray()));
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        shapeRenderer.begin(ShapeType.Filled);
        for (Vector2 dot : dots){
            shapeRenderer.circle(dot.x, dot.y, DOT_RADIUS);
        }
        shapeRenderer.end();

        shapeRenderer.begin(ShapeType.Line);
        float[] floatDots = dotsAsFloatArray();
        if (floatDots.length > 3) {
            shapeRenderer.polyline(floatDots);
        }
        shapeRenderer.end();

        spriteBatch.begin();
        Integer i = 1;
        for (Vector2 dot : dots){
            bitmapFont.draw(spriteBatch,i.toString(),dot.x+DOT_RADIUS, dot.y-DOT_RADIUS);
            i++;
        }
        spriteBatch.end();


//        batch.begin();
//        batch.draw(img, 0, 0);
//        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Keys.R){
            resetDots();
        } else if (keycode == Keys.F){
            logDotsAsFloatArray();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        dots.add(new Vector2(screenX,Gdx.graphics.getHeight() - screenY));
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
