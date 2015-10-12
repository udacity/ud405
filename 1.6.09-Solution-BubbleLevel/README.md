# Bubble Level

In this demo you'll use accelerometer readings to create a bubble level, like the kind you use in carpentry to make sure a board is flat.

This exercise is very similar to the previous demo, where we drew lines representing the magnitude of the acceleration in the direction of the various axes. In this case, however, we'll combine those magnitudes into a single vector, and draw a "bubble" there.

First, draw a circle in the middle of the world, with a radius equal to a quarter of the world size. When the bubble is on this circle, that means the phone is vertical. Next, draw a small circle in the center of the world. When the bubble is inside this circle, it means the phone is flat. Finally, draw a filled circle that shows the value of the accelerometer readings in the X and Y directions.

Figuring out where to draw this last circle is the real challenge. If both X and Y accelerometer readings are zero, we want the ball to hang out in the middle of the world. If the phone is held vertically, the bubble should lie on the outer circle. Note that when the phone is vertical, the length of the `(x, y)` vector will be 9.8m/s^2, which is the acceleration due to gravity at the earth's surface.

To give some points of reference, we'll also draw a circle at 9.8m/s^2, to indicate when the phone is vertical, and a small circle that 
Check out the TODOs to get started!
