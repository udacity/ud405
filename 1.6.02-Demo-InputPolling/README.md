# Polling for Key presses

Let's add out first bit of interactivity to this demo. We can very easily check to see if a key is pressed by using Gdx.input.isKeyPressed() and passing in a constant from the Keys class, like Keys.Z. If we do this check every frame, we can make some change to the world based on that input. In this demo, we change the radius of the ball. Holding the "z" key causes the ball to grow, and holding the "x" key causes the ball to shrink.

Check out the TODOs to see how it's done!
