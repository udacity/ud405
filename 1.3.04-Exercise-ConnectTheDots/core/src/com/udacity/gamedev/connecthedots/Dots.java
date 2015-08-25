package com.udacity.gamedev.connecthedots;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by silver on 8/17/15.
 */
public class Dots {
    private static final float[] FLOAT_DOTS = {411.0f, 237.0f, 388.0f, 272.0f, 355.0f, 296.0f, 314.0f, 312.0f, 278.0f, 318.0f, 247.0f, 319.0f, 209.0f, 317.0f, 195.0f, 306.0f, 163.0f, 271.0f, 159.0f, 243.0f, 159.0f, 200.0f, 174.0f, 178.0f, 202.0f, 169.0f, 224.0f, 169.0f, 226.0f, 187.0f, 211.0f, 188.0f, 189.0f, 197.0f, 188.0f, 207.0f, 191.0f, 233.0f, 212.0f, 234.0f, 216.0f, 212.0f, 216.0f, 191.0f, 219.0f, 145.0f, 255.0f, 140.0f, 274.0f, 158.0f, 272.0f, 171.0f, 277.0f, 186.0f, 309.0f, 188.0f, 323.0f, 176.0f, 323.0f, 158.0f, 333.0f, 147.0f, 368.0f, 141.0f, 389.0f, 144.0f, 395.0f, 167.0f, 395.0f, 195.0f, 397.0f, 215.0f, 390.0f, 235.0f};

    static Array<Vector2> dots(){
        int dotCount = FLOAT_DOTS.length/2;
        Array<Vector2> dots = new Array<Vector2>(dotCount);
        for (int i = 0; i < dotCount; i++){
            Vector2 dot = new Vector2();
            dot.x = FLOAT_DOTS[2*i];
            dot.y = FLOAT_DOTS[2*i+1];
            dots.add(dot);
        }
        return dots;
    }
}
