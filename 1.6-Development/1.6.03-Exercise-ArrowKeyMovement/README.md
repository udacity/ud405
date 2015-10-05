# Arrow Key Movement

In this exercise, we've taken out the random kicks the ball is receiving, so you can make the ball move around in response to the arrow keys!

We've added two new constants, ACCELERATION, and MAX_SPEED. If, say, the left arrow key is pressed, what we want to do is subtract from the velocity in the x direction the ACCELERATION times the frame delta. If the right arrow key is pressed, we want to add the ACCELERATION * delta to the x velocity. Similarly with the y velocity.

When we're done changing the velocity, we also want to cap how fast the ball is going with a call to the clamp() method on Vector2. While there's no physically inspired reason to do this (and the drag in the system does a good job of slowing the ball down anyway), allowing arbitrarily high velocities in your game often sets you up for some very strange behavior down the road.

Check out the TODOs to add arrow key movement!

