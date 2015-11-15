package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Icicles {

    public static final String TAG = Icicles.class.getName();

    // TODO: Use a DelayedRemovalArray to hold our icicles
    Array<Icicle> icicleList;
    Viewport viewport;

    public Icicles(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        // TODO: Initialize the DelayedRemovalArray
        icicleList = new Array<Icicle>(false, 100);
    }

    public void update(float delta) {
        if (MathUtils.random() < delta * Constants.ICICLE_SPAWNS_PER_SECOND) {

            Vector2 newIciclePosition = new Vector2(
                    MathUtils.random() * viewport.getWorldWidth(),
                    viewport.getWorldHeight()
            );
            Icicle newIcicle = new Icicle(newIciclePosition);
            icicleList.add(newIcicle);

        }

        for (Icicle icicle : icicleList) {
            icicle.update(delta);
        }

        // TODO: begin a removal session


        // TODO: Remove any icicle completely off the bottom of the screen


        // TODO: End removal session


    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.ICICLE_COLOR);
        for (Icicle icicle : icicleList) {
            icicle.render(renderer);
        }
    }
}
