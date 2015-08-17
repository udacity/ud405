package com.udacity.gamedev.firstdemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class UdacityScreen extends InputAdapter implements Screen {

    SpriteBatch batch;
    Texture logo;
    ParticleEffectPool touchEffectPool;
    Array<PooledEffect> effects = new Array<PooledEffect>();

    private static final Color UDACITY_ORANGE = new Color(228.0f/225.0f, 127.0f/225.0f, 57.0f/225.0f, 1.0f);
    private static final Color UDACITY_BLUE = new Color(36.0f/225.0f, 73.0f/225.0f, 96.0f/225.0f, 1.0f);
    private static final float LOGO_WIDTH = 200.0f;
    private float logoHeight;

    @Override
    public void show() {
        batch = new SpriteBatch();
        logo = new Texture("udacity_logo_white.png");
        logoHeight = logo.getHeight() * LOGO_WIDTH/ logo.getWidth();

        ParticleEffect touchEffect = new ParticleEffect();
        touchEffect.load(Gdx.files.internal("UdacityEmitter.p"), Gdx.files.internal(""));
        touchEffect.setEmittersCleanUpBlendFunction(false);
        touchEffectPool = new ParticleEffectPool(touchEffect, 1, 2);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        // TODO: Make this UDACITY_BLUE instead
        clearScreen(UDACITY_ORANGE);
        batch.begin();
        batch.draw(logo,
                (Gdx.graphics.getWidth() - LOGO_WIDTH)/2,
                (Gdx.graphics.getHeight() - logoHeight)/2,
                LOGO_WIDTH,
                logoHeight);
        for (int i = effects.size - 1; i >= 0; i--) {
            PooledEffect effect = effects.get(i);
            effect.draw(batch, delta);
            if (effect.isComplete()) {
                effect.free();
                effects.removeIndex(i);
            }
        }
        batch.end();
    }

    private void clearScreen(Color color){
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void spawnParticleEffect(int x, int y){
        PooledEffect effect = touchEffectPool.obtain();
        effect.setPosition(x, Gdx.graphics.getHeight() - y);
        effects.add(effect);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        spawnParticleEffect(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        spawnParticleEffect(screenX, screenY);
        return false;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        logo.dispose();
        for (int i = effects.size - 1; i >= 0; i--)
            effects.get(i).free();
        effects.clear();

    }
}
