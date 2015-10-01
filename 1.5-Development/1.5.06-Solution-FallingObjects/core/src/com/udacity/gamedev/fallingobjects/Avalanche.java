package com.udacity.gamedev.fallingobjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class Avalanche {

    private static final float SPAWNS_PER_SECOND = 10;

    Array<Boulder> boulders;

    public Avalanche(){
        boulders = new Array<Boulder>();
    }

    public void update(float delta, Viewport viewport){
        Random random = new Random();
        if (random.nextFloat() < delta * SPAWNS_PER_SECOND){
            boulders.add(new Boulder(viewport));
        }

        for (int i = 0; i < boulders.size; i++){
            Boulder boulder = boulders.get(i);
            boulder.update(delta);
            if (boulder.isBelowScreen()){
                boulders.removeIndex(i);
            }
        }
    }

    public void render(ShapeRenderer renderer){
        for (Boulder boulder : boulders){
            boulder.render(renderer);
        }
    }
}
