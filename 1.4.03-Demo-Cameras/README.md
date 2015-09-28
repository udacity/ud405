# Camera Demo

Before we dive into what an OrthographicCamera is and how to work with it, let's just see one in action!

This demo creates a simple scene, which you can view through two different cameras. The first camera just displays an overview of the scene, but the second camera, the closeup camera, you can move and zoom.

Give it a try! Run the project, then use the arrow keys to move around the camera! Now here's the interesting bit. Hit Space to see the view from the overview camera, along with a blue rectangle showing the portion of the scene visible to the closeup camera.

You can zoom the scene using Z and X, note how when we zoom in, what we're really doing is reducing the portion of the scene that's visible to our closeup camera. You can also change the viewport width and height using A/D and W/S. When the viewport is wide and short, the world looks super vertically stretched. When the viewport is tall and skinny, the world looks horizontally stretched.

You can hit F to set the aspect ratio of the camera back to the aspect ratio of the screen. You can rotate the camera using Q and E. Note that very weird things happen when you rotate a camera that has a distorted aspect ratio! Finally, note that you can easily make the "closeup" camera zoom out so far that you can see the entire scene.

No matter how deep we get into matrices and whatnot, remember that this is what cameras do: determine what portion of the world you can see.

## The code

The code for this demo contains a lot of concepts we haven't talked about yet, but feel free to check it out by following the TODOs!
