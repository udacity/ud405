package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Icicles {

    public static final String TAG = Icicles.class.getName();

    // TODO: Use a DelayedRemovalArray to hold our icicles
    DelayedRemovalArray<Icicle> icicleList;
    Viewport viewport;

    public Icicles(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        // TODO: Initialize the DelayedRemovalArray
        icicleList = new DelayedRemovalArray<Icicle>(false, 100);
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
        icicleList.begin();

        // TODO: Remove any icicle completely off the bottom of the screen
        for (int i = 0; i < icicleList.size; i++) {
            if (icicleList.get(i).position.y < -Constants.ICICLES_HEIGHT) {
                icicleList.removeIndex(i);
            }
        }
        // TODO: End removal session
        icicleList.end();
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.ICICLE_COLOR);
        for (Icicle icicle : icicleList) {
            icicle.render(renderer);
        }
    }
}
