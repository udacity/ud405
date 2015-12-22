package com.udacity.gamedev.sierpinskitriangle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * TODO: Start here
 *
 * Your challenge, should you choose to accept it, is to draw a Serpinski Triangle. I offer no hints
 * beyond the fact that ShapeRenderer has a very convenient triangle() function, and that using a
 * FitViewport can simplify matters considerably. Good luck!
 */


public class SierpinskiTriangle extends ApplicationAdapter {

    static final float SIZE = 10;
    private static final int RECURSIONS = 7;
    ShapeRenderer renderer;
    FitViewport viewport;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        viewport = new FitViewport(SIZE, SIZE);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);
        inscribeSierpinskiTriangle(renderer, SIZE, RECURSIONS);
        renderer.end();
    }

    private void inscribeSierpinskiTriangle(ShapeRenderer shapeRenderer, float size, int recursions) {
        Vector2 corner1 = new Vector2(0, 0);
        Vector2 corner2 = new Vector2(size, 0);
        Vector2 corner3 = new Vector2(size / 2, size * MathUtils.sin(MathUtils.PI/3f));
        drawSierpinskiTriangle(shapeRenderer, corner1, corner2, corner3, recursions);
    }

    private void drawSierpinskiTriangle(ShapeRenderer shapeRenderer, Vector2 corner1, Vector2 corner2, Vector2 corner3, int recursions) {

        Vector2 midpoint12 = new Vector2((corner1.x + corner2.x) / 2, (corner1.y + corner2.y) / 2);
        Vector2 midpoint23 = new Vector2((corner2.x + corner3.x) / 2, (corner2.y + corner3.y) / 2);
        Vector2 midpoint31 = new Vector2((corner3.x + corner1.x) / 2, (corner3.y + corner1.y) / 2);

        if (recursions == 1) {
            shapeRenderer.triangle(corner1.x, corner1.y, midpoint12.x, midpoint12.y, midpoint31.x, midpoint31.y);
            shapeRenderer.triangle(corner2.x, corner2.y, midpoint23.x, midpoint23.y, midpoint12.x, midpoint12.y);
            shapeRenderer.triangle(corner3.x, corner3.y, midpoint31.x, midpoint31.y, midpoint23.x, midpoint23.y);
        } else {
            drawSierpinskiTriangle(shapeRenderer, corner1, midpoint12, midpoint31, recursions - 1);
            drawSierpinskiTriangle(shapeRenderer, corner2, midpoint23, midpoint12, recursions - 1);
            drawSierpinskiTriangle(shapeRenderer, corner3, midpoint31, midpoint23, recursions - 1);
        }

    }


}
