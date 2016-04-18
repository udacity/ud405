package com.udacity.gamedev.wordcloud;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;


/**
 * TODO: Start here
 *
 * In this exercise, we'll create a word cloud. We've created all the infrastructure like the
 * SpriteBatch and BitmapFont. Now all you need to do is actually draw the random collection of
 * words we've generated.
 *
 * You can find the Word class at the bottom of this file. It contains 5 fields:
 *
 * x, y - Normalized position (meaning in the range 0-1), you'll want to multiply by
 * Gdx.graphics.getWidth() and Gdx.graphics.getHeight() as appropriate.
 *
 * scale - The size of the text.
 *
 * color - The color of the word.
 *
 * letters - The actual letters in the world.
 *
 * Jump to the TODOs below to see what you'll need to do.
 */

public class WordCloud extends ApplicationAdapter {


    private static final int WORD_COUNT = 20;
    private static final float MIN_SCALE = 0.5f;
    private static final float MAX_SCALE = 5.0f;

    SpriteBatch batch;
    BitmapFont font;

    Array<Word> words;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        words = generateWords(WORD_COUNT);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void resize(int width, int height) {
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        for (Word word : words) {

            // TODO: Set the font's scale using font.getData().setScale()
            font.getData().setScale(word.scale);

            // TODO: Set the font's tint using font.setColor()
            font.setColor(word.color);

            // TODO: Actually draw the word using font.draw()
            font.draw(batch, word.letters, word.x * Gdx.graphics.getWidth(), word.y * Gdx.graphics.getHeight());
        }
        batch.end();
    }

    private Array<Word> generateWords(int count) {
        Array<Word> newWords = new Array<Word>(count);
        for (int i = 0; i < count; i++) {
            newWords.add(Word.randomWord(MIN_SCALE, MAX_SCALE));
        }
        return newWords;
    }

    static class Word {

        private static final String[] WORDS =
                {"render-farm", "refrigerator", "tiger-team", "weathered", "camera", "tattoo", "boat", "soul-delay", "nodal point", "motion augmented", "reality neon", "nano-construct", "garage", "bicycle", "rebar tanto", "modem", "concrete RAF", "industrial grade media", "realism", "drone", "post-franchise shoes", "render-farm-ware", "DIY San Francisco", "rain lights", "numinous tank-traps", "pen drone", "cyber-cardboard", "denim monofilament", "order-flow", "smart-hotdog"};
        float x;
        float y;
        float scale;
        Color color;
        String letters;

        public Word(float x, float y, float scale, Color color, String letters) {
            this.x = x;
            this.y = y;
            this.scale = scale;
            this.color = color;
            this.letters = letters;
        }

        static Word randomWord(float minScale, float maxScale) {
            float x = MathUtils.random(-.25f, .75f);
            float y = MathUtils.random();
            float scale = minScale + (maxScale - minScale) * MathUtils.random();
            Color color = new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1);
            String letters = WORDS[MathUtils.random(WORDS.length - 1)];
            return new Word(x, y, scale, color, letters);
        }
    }
}
