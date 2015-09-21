# Orthographic Cameras

In this demo, we'll explore how to use an `OrthographicCamera` to  

## Cameras and Lenses

When we talk about cameras in a computer graphics context, it's by way of an analogy. What we're really interested in is what part of our game world is visible, and how it should appear. That's basicially what we do with a camera in real life. The world stays stationary, but we can control the position and orientation of a camera within that world.

We can also control the way the camera sees the world though the use of lenses. We can choose to use a fish-eye lens with a very wide field of view, or a telephoto lens, which has a very narrow field of view. To put it another way, the part of the world that a fish-eye lens can see looks like a very wide cone, while a telephoto lens can see only a very tight cone, or even a cylinder. 

Ultimately, this means that with a fish-eye lens, objects that are close to the lens look much bigger than objects far away. With a telephoto lens, objects look the same size, regardless of how far away they are. That's why telephoto lenses are so great for long distance shots. It's not so much that the telephoto lens magnifies the face of a football player a hundred yards away, it's more that that the face of the footballer looks exactly the same size as if they were right in front of you.

In computer graphics, the behavior of cameras isn't set by lenses, but by some crazy linear algebra. You can actually package up everything there is to know about a camera in a 4 by 4 matrix. Actually the matrix is usually considered as the product of two matrices: the view matrix, which determines the camera's position and orientation; and the projection matrix, which determines the properties of the camera's "lens".

## Orthographic Cameras

All this camera business really gets going in 3D games, but there's a particular type of camera that is the life blood of 2D games. OpenGL doesn't actually draw a distinction between 2D and 3D. As far as it's concerned, what you're really doing when you're drawing in 2D is arranging pieces of paper on a desktop. Then you're setting up a camera pointing down at the desk. 

That camera doesn't have any sense of perspective. It's much more like a scanner than a camera; it can see only a rectangle of the desk, and things that are close do it don't appear any bigger than things far away.

# Cameras in LibGDX

It's easy to set up a camera in LibGDX
 
 
 
 It's like a perfect telephoto lens, capable of seeing only a rectangle of the world. 
