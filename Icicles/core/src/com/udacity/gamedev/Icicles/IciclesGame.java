package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Game;
import com.udacity.gamedev.icicles.screens.IciclesGameScreen;

public class IciclesGame extends Game {
	@Override
	public void create () {
		setScreen(new IciclesGameScreen());
	}
}
