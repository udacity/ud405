# User Input

Now that we know how to make stuff move, let's make it interactive! There are a ton of different ways to interact with LibGDX games: key presses, your mouse, touches, and even device orientation and acceleration!

The simplest form of input is just key presses. They offer the user the tightest control, and even if you're building a mobile only game where keypresses aren't relevant, they're still incredibly  convenient for debugging.

There are a couple different things you might want to know about a keypress. Say you're building a platformer and you want to control the left/right movement of the character using the arrow keys. Each frame you're interested in knowing whether those buttons are pressed.

On the other hand, say you want the character to fire a grappling hook when the spacebar is pressed. In this case you don't actually want to check every frame to see if the spacebar is pressed, since it's only relevant the moment the key is pressed. Subsequent frames, you don't care that the spacebar is down. 

We have two different approaches. One where we want to know the state of the inputs every frame, and one where we want to be notified when certain things happen. The former approach is called polling, and the latter approach is known as event-based input.

We'll start with polling, as it's a bit simpler, and will get to event based input later in the level.

# Input Testbed

To explore these various input methods, we'll use the same testbed throughout this lesson, which is based on the screensaver we built last level. Now, instead of the ball just moving in a straight line forever, we'll control it's movement with key presses, touches, and the accelerometer.

Follow the TODOs to see some of its features.
