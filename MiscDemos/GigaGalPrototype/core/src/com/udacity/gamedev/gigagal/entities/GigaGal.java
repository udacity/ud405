package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Constants;

/**
 * Created by silver on 10/14/15.
 */
public class GigaGal {

    Vector2 position;
    Vector2 velocity;
    Texture texture;

    JumpState jumpState;
    long jumpStartTime;

    public GigaGal(){
        position = new Vector2();
        texture = new Texture("GigaGalPlaceholder.png");
        jumpState = JumpState.GROUNDED;
    }

    public void update(float delta){


        if (Gdx.input.isKeyPressed(Keys.LEFT)){
            position.x -= delta * Constants.GIGA_GAL_MOVE_SPEED;
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT)){
            position.x += delta * Constants.GIGA_GAL_MOVE_SPEED;
        }

        if (Gdx.input.isKeyPressed(Keys.Z)){
            switch (jumpState){
                case GROUNDED:
                    startJump();
                    break;
                case JUMPING:
                    continueJump();
            }
        } else {
            if (jumpState == JumpState.JUMPING){
                jumpState = JumpState.FALLING;
            }
        }





    }

    private void startJump(){
        jumpState = JumpState.JUMPING;
        velocity.y = Constants.JUMP_SPEED;
    }

    private void continueJump(){
        if (jumpState == JumpState.JUMPING) {
            float jumpDuration = MathUtils.nanoToSec * (TimeUtils.nanoTime() - jumpStartTime);
            if (jumpDuration < Constants.MAX_JUMP_DURATION) {
                velocity.y = Constants.JUMP_SPEED;
            } else {
                jumpState = JumpState.FALLING;
            }
        }
    }




    public void render(SpriteBatch batch){

        batch.draw(texture, position.x, position.y);

    }





    enum JumpState {
        JUMPING,
        FALLING,
        GROUNDED
    }

}
