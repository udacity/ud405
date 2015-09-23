package com.udacity.gamedev.checkerboardsetup;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class CheckerBoard {

    public static final String LOG_TAG = CheckerBoard.class.getName();

    public static void render(ShapeRenderer renderer, Vector2 bottomLeft, Vector2 topRight, float squareSize){
        int yIndex = 0;
        for (float yStart = bottomLeft.y; yStart < topRight.y; yStart += squareSize){
            yIndex++;
            int xIndex = 0;
            for (float xStart = bottomLeft.x; xStart < topRight.x; xStart += squareSize){
                xIndex++;
                if ((xIndex + yIndex) % 2 == 0){
                    renderer.rect(xStart, yStart, squareSize, squareSize);

                }
            }
        }
    }
}
