# Position, Velocity, and Acceleration

Previously, we've just set the position of objects based on how much time has elapsed. More interesting, however, is to set the position of objects based on their position the previous frame, and their velocity. Doing that, however, we just get motion at a constant speed in a straight line. To get really interesting motion, we need to take into account acceleration as well. Acceleration is the change in velocity over time.

Take the simple case of a falling object. Last frame its position was `x`, `y`, and it's velocity was `v_x`, `v_y`. To figure out where it's at this frame, first we need to update its velocity. Its `v_x` is unchanged, but its `v_y` (which was already negative, since it's falling) is now even less (it's falling faster). To find its new vertical velocity, we need to subtract from `v_y` the elapsed time multiplied by the acceleration due to gravity `g` (where `g` is negative). 

```
    v_y += delta * g
```

Then we can use the new velocity to update the position:

```
    x += v_x
    y += v_y
```


# Falling Objects

This project has a more complex game, where boulders fall from the top of the screen. Right now the boulders don't fall very realistically. They just move down from the top of the screen at a constant speed. It's up to you to make them fall as if pulled by gravity!

Check out the TODOs to get started.
