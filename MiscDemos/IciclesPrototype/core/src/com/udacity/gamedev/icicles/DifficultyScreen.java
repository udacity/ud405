package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.udacity.gamedev.icicles.Constants.Difficulty;

/**
 * Created by silver on 10/8/15.
 */
public class DifficultyScreen extends InputAdapter implements Screen {

    public static final String TAG = DifficultyScreen.class.getName();

    IciclesGame game;

    ShapeRenderer renderer;
    SpriteBatch batch;
    FitViewport viewport;

    BitmapFont font;




    public DifficultyScreen(IciclesGame game){
        this.game = game;

    }

    @Override
    public void show() {

        renderer = new ShapeRenderer();
        batch = new SpriteBatch();

        viewport = new FitViewport(Constants.DIFFICULTY_WORLD_SIZE, Constants.DIFFICULTY_WORLD_SIZE);
        Gdx.input.setInputProcessor(this);

        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);

        renderer.setColor(Constants.EASY_COLOR);
        renderer.circle(Constants.DIFFICULTY_WORLD_SIZE / 2, Constants.DIFFICULTY_WORLD_SIZE / 2, 100);
        renderer.setColor(Constants.MEDIUM_COLOR);
        renderer.circle(Constants.DIFFICULTY_WORLD_SIZE / 2, Constants.DIFFICULTY_WORLD_SIZE / 2, 50);
        renderer.setColor(Constants.HARD_COLOR);
        renderer.circle(Constants.DIFFICULTY_WORLD_SIZE / 2, Constants.DIFFICULTY_WORLD_SIZE / 2, 25);


        renderer.end();





    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        batch.dispose();
        font.dispose();
        renderer.dispose();
    }

    @Override
    public void dispose() {

    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log(TAG, "Touch down" );
        game.showIciclesScreen(Difficulty.HARD);
        return true;
    }
}
