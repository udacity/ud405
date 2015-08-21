package com.udacity.gamedev.sierpinskitriangle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SierpinskiTriangle extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;
    private static final int RECURSIONS = 7;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render () {
        Rectangle largestSquare = findLargestSquare();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeType.Filled);
        inscribeSierpinskiTriangle(shapeRenderer, largestSquare, RECURSIONS);

        shapeRenderer.end();
    }

    private Rectangle findLargestSquare(){

        Rectangle largestSquare = new Rectangle();
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        if (screenWidth > screenHeight){
            largestSquare.x = (screenWidth - screenHeight)/2;
            largestSquare.y = 0;
            largestSquare.width = screenHeight;
            largestSquare.height = screenHeight;
        } else {
            largestSquare.x = 0;
            largestSquare.y = (screenHeight - screenWidth)/2;
            largestSquare.width = screenWidth;
            largestSquare.height = screenWidth;
        }
        return largestSquare;
    }

    private void inscribeSierpinskiTriangle(ShapeRenderer shapeRenderer, Rectangle bounds, int recursions ){
        Vector2 corner1 = new Vector2(bounds.x, bounds.y);
        Vector2 corner2 = new Vector2(bounds.x + bounds.width, bounds.y);
        Vector2 corner3 = new Vector2(bounds.x + bounds.width/2, bounds.y + bounds.height);
        drawSierpinskiTriangle(shapeRenderer, corner1, corner2, corner3, recursions);
    }

    private void drawSierpinskiTriangle(ShapeRenderer shapeRenderer, Vector2 corner1, Vector2 corner2, Vector2 corner3, int recursions){

        Vector2 midpoint12 = new Vector2((corner1.x + corner2.x)/2, (corner1.y + corner2.y)/2);
        Vector2 midpoint23 = new Vector2((corner2.x + corner3.x)/2, (corner2.y + corner3.y)/2);
        Vector2 midpoint31 = new Vector2((corner3.x + corner1.x)/2, (corner3.y + corner1.y)/2);

        if (recursions == 1){
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
