package com.udacity.gamedev.icicles.world.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by silver on 8/2/15.
 */
public class Player {

    public static final String LOG_TAG = Player.class.getName();
    private static final Color PLAYER_COLOR = new Color(Color.RED);

    public Player(){

    }

    private void init(){

    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(PLAYER_COLOR);
        shapeRenderer.circle(0,0,100);
    }
}
