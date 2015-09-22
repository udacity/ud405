# Viewports!

Handling your own OrthographicCamera is often necessary, but there's quite a lot of fuss involved in getting the aspect ratio right, and in positioning your world in the screen. If you don't need to move the camera around in your game world, it's often easier to use a Viewport to manage your camera.

To use a viewport, you tell it the size of the world you want to display, the portion of the screen you want to draw it to (usually the whole screen), and pass it a camera. It then handles the viewport and position of the camera.
 
There are five types of viewports:
 
`ScreenViewport` doesn't care about the size of the world. It just sets the camera up for pixel-for-pixel drawing. We won't use this for much.

`StretchViewport` makes the world exactly fill the screen, but doesn't respect the aspect ratio of the world, so things might look streched either horizontally or verticially.

`FillViewport` also makes sure the screen is filled, but will clip the world to maintain the aspect ratio. Can be useful in cases where you don't mind that the user might not be able to see the whole world, depending on the aspect ratio of the device.

`FitViewport` makes sure the entire world is visible, filling the screen with black bars to maintain aspect ratio. This is also called letterboxing. It's what happens when you watch widescreen movies on old TVs. This is a great choice when the exact size of the game world is essential, but it can look bad when used on devices with very different aspect ratios than you intended.

`Extend` makes sure the entire world is visible, then extends the world along the short dimension to fill the screen. This is the best option, when you can make it work. It means that the aspect ratio is always right, and the game world always fills the screen. The downside is you need to ensure your game can handle different size game worlds.

Let's see these in action! Check out the TODOs.
