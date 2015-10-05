# Input Adapter

So far we've been using user input by polling for it each frame. The other approach to user input is an event based approach, where we ask to be notified when certain things happen. To do this in LibGDX, we need to create an implementation of the InputProcessor interface, and tell LibGDX to send events our way.
 
Let's reuse that randomKick() method, but this time fire a random kick when the space bar is pressed. 
 
InputProcessor has seven required methods: keyDown, keyUp, keyTyped, touchDown, touchUp, mouseMoved, and scrolled. However, just like ApplicationListener and ApplicationAdapter, there's also a convenience implementation (InputAdapter) that provides blank implementations for all the methods. 

So, we need to do three things: make our BouncingBall class a subclass of InputAdapter, override keyDown and provide the logic to handle the space bar being pressed, in BallScreen, tell LibGDX that we would like input events to be routed to BouncingBall.

Check out the TODOs to see how it's done!
