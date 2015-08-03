package com.udacity.gamedev.icicles.world;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.udacity.gamedev.icicles.world.entities.Player;

/**
 * Created by silver on 8/2/15.
 */
public class World {

    private Player player;

    public World(){
        player = new Player();
    }

    public void render(ShapeRenderer shapeRenderer){
        player.render(shapeRenderer);
    }


}
