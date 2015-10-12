package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final float WORLD_SIZE = 10.0f;
    public static final Color BACKGROUND_COLOR = Color.BLUE;

    public static final float PLAYER_HEAD_RADIUS = 0.5f;
    public static final int PLAYER_HEAD_SEGMENTS = 20;
    public static final Color PLAYER_COLOR = Color.BLACK;
    public static final float PLAYER_MOVEMENT_SPEED = 10.0f;

    public static final float ACCELEROMETER_SENSITIVITY = 5.0f;
    public static final float GRAVITATIONAL_ACCELERATION = 9.8f;

    public static final float ICICLES_HEIGHT = 1.0f;
    public static final float ICICLES_WIDTH = 0.5f;
    public static final Vector2 ICICLES_ACCELERATION = new Vector2(0, -5.0f);
    public static final float ICICLE_SPAWNS_PER_SECOND = 15;
    public static final Color ICICLE_COLOR = Color.WHITE;


    public static final float HUD_FONT_SCALE = 1.0f;
    public static final float HUD_MARGIN = 20.0f;



    public static final float DIFFICULTY_WORLD_SIZE = 480.0f;
    public static final float DIFFICULTY_CIRCLE_RADIUS = 50.0f;
    public static final Color EASY_COLOR = Color.GREEN;
    public static final Color MEDIUM_COLOR = Color.YELLOW;
    public static final Color HARD_COLOR = Color.RED;

    public static final float EASY_SPAWNS_PER_SECOND = 5;
    public static final float MEDIUM_SPAWNS_PER_SECOND = 15;
    public static final float HARD_SPAWNS_PER_SECOND = 25;


    public enum Difficulty {
        EASY(EASY_SPAWNS_PER_SECOND),
        MEDIUM(MEDIUM_SPAWNS_PER_SECOND),
        HARD(HARD_SPAWNS_PER_SECOND);

        float spawnRate;

        Difficulty(float spawnRate){
            this.spawnRate = spawnRate;
        }
    }

}
