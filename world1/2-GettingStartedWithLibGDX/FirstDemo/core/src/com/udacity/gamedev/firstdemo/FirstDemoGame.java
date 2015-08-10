package com.udacity.gamedev.firstdemo;

import com.badlogic.gdx.Game;

public class FirstDemoGame extends Game {

	@Override
	public void create () {
		this.setScreen(new UdacityScreen());
	}
}
