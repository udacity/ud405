package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Icicles {

    public static final String TAG = Icicles.class.getName();

    // TODO: Add counter for how many icicles have been dodged
    int iciclesDodged;
    DelayedRemovalArray<Icicle> icicleList;
    Viewport viewport;

    public Icicles(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        icicleList = new DelayedRemovalArray<Icicle>(false, 100);

        // TODO: Set icicles dodged count to zero
        iciclesDodged = 0;
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

        icicleList.begin();
        for (int i = 0; i < icicleList.size; i++) {
            if (icicleList.get(i).position.y < -Constants.ICICLES_HEIGHT) {
                // TODO: Increment count of icicles dodged
                iciclesDodged += 1;
                icicleList.removeIndex(i);
            }
        }
        icicleList.end();
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.ICICLE_COLOR);
        for (Icicle icicle : icicleList) {
            icicle.render(renderer);
        }
    }
}
