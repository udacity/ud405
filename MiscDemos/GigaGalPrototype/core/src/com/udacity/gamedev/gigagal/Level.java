package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.entities.GigaGal;

public class Level {


    GigaGal gigaGal;


    public Level(){
        gigaGal = new GigaGal();
    }

    public void update(float delta){
        gigaGal.update(delta);

    }


    public void render(SpriteBatch batch, ShapeRenderer renderer, Viewport viewport){

        gigaGal.render(batch);


    }
}
