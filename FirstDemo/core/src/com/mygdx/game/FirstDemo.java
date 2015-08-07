package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class FirstDemo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

    private static final Color UDACITY_ORANGE = new Color(228.0f/225.0f, 127.0f/225.0f, 57.0f/225.0f, 1.0f);

    private static final float LOGO_WIDTH = 200.0f;
    private float logoHeight;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("udacity_logo_white.png");
        logoHeight = img.getHeight() * LOGO_WIDTH/img.getWidth();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(UDACITY_ORANGE.r, UDACITY_ORANGE.g, UDACITY_ORANGE.b, UDACITY_ORANGE.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.enableBlending();
		batch.begin();

		batch.draw(img,
                (Gdx.graphics.getWidth() - LOGO_WIDTH)/2,
                (Gdx.graphics.getHeight() - logoHeight)/2,
                LOGO_WIDTH,
                logoHeight);
		batch.end();
	}
}
