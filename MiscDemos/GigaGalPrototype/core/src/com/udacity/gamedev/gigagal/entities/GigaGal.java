package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Constants;

public class GigaGal {

    public final static String TAG = GigaGal.class.getName();

    Vector2 position;
    Vector2 velocity;
    Texture texture;

    JumpState jumpState;
    long jumpStartTime;

    public GigaGal(){
        position = new Vector2();
        velocity = new Vector2();
        texture = new Texture("GigaGalPlaceholder.png");
        jumpState = JumpState.GROUNDED;
    }

    public void update(float delta){
        if (Gdx.input.isKeyPressed(Keys.LEFT)){
            moveLeft(delta);
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT)){
            moveRight(delta);
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
            endJump();
        }

        if (jumpState == JumpState.FALLING){
//            Gdx.app.log(TAG, "Falling");
            velocity.y -= Constants.GRAVITY;
        }

        position.mulAdd(velocity, delta);

        if (position.y < 0){
            jumpState = JumpState.GROUNDED;
            position.y = 0;

        }

    }

    private void moveLeft(float delta){
        position.x -= delta * Constants.GIGA_GAL_MOVE_SPEED;
    }


    private void moveRight(float delta){
        position.x += delta * Constants.GIGA_GAL_MOVE_SPEED;
    }



    private void startJump(){
        jumpState = JumpState.JUMPING;
        velocity.y = Constants.JUMP_SPEED;
        jumpStartTime = TimeUtils.nanoTime();
    }

    private void continueJump(){
        if (jumpState == JumpState.JUMPING) {
            float jumpDuration = MathUtils.nanoToSec * (TimeUtils.nanoTime() - jumpStartTime);
            if (jumpDuration < Constants.MAX_JUMP_DURATION) {
                velocity.y = Constants.JUMP_SPEED;
            } else {
                endJump();
            }
        }
    }

    private void endJump(){
        if (jumpState == JumpState.JUMPING){
            jumpState = JumpState.FALLING;
        }
    }

    private void fall(){

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
