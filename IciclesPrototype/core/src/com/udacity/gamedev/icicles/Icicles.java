package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by silver on 8/26/15.
 */
public class Icicles {

    float spawnsPerSecond = 5;
    Random random;

    ArrayList<Icicle> icicleList;

    public Icicles(){
        icicleList = new ArrayList<Icicle>();
        random = new Random();
    }

    public void update(float delta){
        for (Icicle icicle : icicleList){
            icicle.update(delta);
        }

        if (random.nextFloat() < delta * spawnsPerSecond){
            icicleList.add(new Icicle(new Vector2(Constants.WORLD_WIDTH * random.nextFloat(), Constants.WORLD_HEIGHT)));
        }

    }

    public void render(ShapeRenderer renderer){
        for (Icicle icicle : icicleList){
            icicle.render(renderer);
        }
    }




}
