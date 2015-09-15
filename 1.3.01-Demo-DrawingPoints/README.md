# Drawing Shapes with LibGDX

Welcome back! I hope you're refreshed after importing your first LibGDX project, and I'm sure you're dying to learn how to create those sweet particle effects! Before we get to that though, we should start out with some simpler drawing.

In this level, we're first going to learn a bit about how the computer drawing pipeline works, with a brief detour into color theory and your eyeballs. Next we'll learn about ShapeRenderer, the class you'll use for drawing simple shapes.

Then we'll talk about the main entry point into LibGDX games: the ApplicationListener interface. We will implement an ApplicationListener, and then use ShapeRenderer to draw some simple shapes, some modern art, and even some fancy fractals!

Let's get started!

## Computer Screens

Back in the day, using a computer monitor was dangerous business. It meant sitting without flinching while an electron gun fired charged particles at your face at near the speed of light, only to have them slam into a thin layer of glass covered in poison. Depending on where and how many electrons were shot at you, they would produce explosions of different colors and brightnesses, which your eyes would see as an adorable paperclip or whatever. This system is called a cathode ray tube, and it was the bane of LAN parties everywhere.

Since the screen is a big rectangle and the electron gun could only paint one dot of color at a time, the gun had to traverse the whole screen many times a second. While I'm sure you can think of all sorts of cool space filling curves that would get the job done, the chosen solution was to divide the screen into horizontal scan lines, much like the text in a book, and scan each line from top to bottom. This was called "raster scanning", from the latin "rastrum", or rake. It's like raking a zen garden, but instead of using a rake with many tines, you just have a stick, so you need to make each groove individually.

Ultimately, for a computer to draw, it constructs a two dimensional raster array of colors in memory, and then ships those colors to whatever device is going to be displaying the colors, be that a monitor, a projector, or some sweet VR device. The elements of a raster array are also called "picture elements" or pixels, for short.

## Human Color Vision

When we draw on a computer, all we're really doing is assembling an array of colors. if you've ever looked at your computer monitor under a magnifying glass, you've probably noticed that each pixel is actually three vertical rectangles, one red, one green, and one blue. And yet, when you take away the magnifying glass, the pixel can look like any color at all. Pretty weird right?

This works because the human eye isn't as good at distinguishing colors as you might think. Our eyes can't actually tell the exact energy of an incoming photon; all we've got are three types of cone cells, each of which collects photons of a particular range of wavelengths. If a photon falls in the range of the L, or long wavelength, cone cell, our brain sees it as red. If it falls into an M, or medium, cone cell, it looks green, and if it stimulates an S cone, it appears blue. All other colors are how our brain interprets photons that stimulate multiple types of cone cells at once. 

Since red, green, and blue light each directly stimulate one of the types of cone cells, this means we can simulate any other color by replicating how that color would stimulate the cone cells. For instance, yellow light is the result of the stimulating both the L and M cones, but it doesn't matter to our brain how that happened. It could be a yellow laser, where every photon has exactly the same wavelength, or it could be an even combination of red and green. The response of the L and M cones is the same either way, so, to our brain, it's the same color!

Human color vision is a fascinating topic, and we've left a lot out of our discussion here. If you want to learn more, start [here](https://en.wikipedia.org/wiki/Color_vision).

## LibGDX Documentation

We'll be using a Color class provided by LibGDX. To find out how it works, lets check out the LibGDX documentation. You can find the LibGDX website at https://libgdx.badlogicgames.com/. There's a link to the documentation in the top nav bar. Then, scrolling down, you see a ton of useful resources, but the one we want is number 8, the [Javadocs](https://libgdx.badlogicgames.com/nightlies/docs/api/).

Now if we want to find information on the Color class, we can just search the page for "Color" (using Command-f on Macs, or Ctrl-f elsewhere). There we find a [page](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/Color.html) detailing everything there is to know about `Color`. There's even a ton of pre-defined colors. Up at the top it says It says:

> A color class, holding the r, g, b and alpha component as floats in the range [0,1]. All methods perform clamping on the internal values after execution.

## Alpha

From our discussion of human color vision, we know what's going on with the `r`, `g`, and `b` components. But what's this `alpha` thing? [Alpha](https://en.wikipedia.org/wiki/Alpha_compositing) is another component of a color that computers use for compositing, which is a fancy way of saying "What happens when you draw stuff on top of other stuff". 

If you draw a shape with `alpha = 1`, then it's totally opaque. Whatever the background color was, it's totally gone. If you draw a shape with `alpha = 0`, you haven't actually changed anything. The new color is totally transparent. If `alpha = 0.5`, then the new color is half the background color, half your new color, so your drawing looks transparent.

For now we're going to be drawing everything fully opaque, so any time you see an `alpha` field, just set it to 1.

## Rasterization

Everything you see on your computer screen is a rectangular grid of colors. This makes perfect sense for some things. For instance, a digital photo is captured using a rectangular sensor grid, so the color samples you see on your screen are the same samples that were captured by the camera. But what about a line drawing, like a smiley face? A smiley face is made of circles and arcs. It's not made of a rectangular grid of colors, so how do we draw it to the screen? It seems impossible, right?

To draw shapes like lines, triangles, circles, and other polyhedra, they have to be rasterized. That is, to draw a black arc on a white background, we have to determine for each sample in the raster, whether that sample is inside the arc, or outside, and then color it appropriately. Only then can our shape be drawn to the screen. This process is also called rendering.

This presents a huge challenge though. Let's say our raster is 1080 pixels by 1920 pixels, we're drawing 20 simple shapes to the screen. Let's then say that for each pixel and each shape, it takes 10 processor cycles to determine if the shape changes the color of the pixel. Finally since we want a silky smooth frame rate, we need to do all this 60 times a second. So, here's the question, how many processor cores running at 3 gigahertz would we need to render this scene?

```
    1920*1080*60*20*10/3e9 = 8.2944
```

That's right, even if you have the latest crazy octa-core rig, you still couldn't even render 20 shapes. Well, not using your CPU, anyway. There's gotta be something more interesting going on.

## The CPU, GPU, and OpenGL

The central processing unit on your computer can do just about anything, but even the craziest consumer CPUs only have eight cores these days, which isn't nearly enough to render a complex scene in real time.

Fortunately, your computer (and phone) also has a Graphics Processing Unit, or GPU. GPUs are chips purpose-built to pump out pixels, and some can have thousands of cores. Each of those cores is pretty limited in what it can do, though, and groups of those cores have to work together in lock step, each executing the exact same instructions each clock cycle.

So, while the GPU is less flexible than the CPU, it can spew out pixels at some absurd rate. In the code we write for the CPU the, _what_ we want to draw, and then send those instructions over to the GPU, which will then figure out the actual pixel colors. To do this, we need a language for communicating between the CPU and GPU.

The most common language for this purpose is called the Open Graphics Language, or OpenGL. Smartphones use a slightly scaled down version of this language called OpenGL ES, or OpenGL for embedded systems. If in the Microsoft universe you've heard of DirectX, that's a language that serves essentially the same purpose.

To sum up, the CPU uses OpenGL to tell the GPU what to draw. The GPU builds up the actual array of colors, and ships it to electronics that runs the actual screen.

Brief aside, I'd be failing as a nerd if I didn't mention the fact that you actually do far more with GPUs than color pixels. There's a whole field of General Purpose GPU computing, or GPGPU computing. Algorithms that run on GPUs need to be very clever about how they get those lock-stepping cores to work together, but when they do, they can be extremely fast and, as is often even more important these days, extremely energy efficient.

## ShapeRenderer

The first thing we're going to do is draw some very simple shapes on the screen, like points, triangles, rectangles, and circles. However, we don't have to interact with OpenGL directly. Instead, we're going to use a LibGDX abstraction called ShapeRenderer. We can ask ShapeRenderer to draw shapes for us, and it  figures out all the complicated OpenGL stuff that has to happen under the hood.

ShapeRenderer works in batches. It's slow to ask OpenGL to draw shapes one at a time, but it's much faster to bundle up all our drawing instructions into a batch, and send that to OpenGL all at once. Further, ShapeRenderer has three modes, point, line, and filled, and a batch can only contain shapes of one of those types.

I could keep going, but honestly, the official documentation does a lot better job than I could. You can check out the documentation of ShapeRenderer [here](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/glutils/ShapeRenderer.html), or just by searching for "LibGDX ShapeRenderer".

## Coordinates and Cameras

So, LibGDX provides us with a way to talk to the GPU without needing to actually use OpenGL. LibGDX also provides us with a rectangular area of the screen we can draw to. On a mobile device, that's generally the entire screen. Now we need to think about how we're going to position stuff on that screen. We clearly need an X Y pair, and the the easiest way to position stuff is by having the X value be the number of pixels from the left edge of the screen, and have the Y value be the number of pixels from the bottom of the screen.

That's the approach we're going to stick with for the rest of this level, but next level we'll start using a much more flexible system called an orthographic camera.

## ApplicationListener

One last thing to understand before we start drawing, where we actually put our code.  I highly recommend reading the [documentation](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/ApplicationListener.html) of ApplicationListener, but the best way to learn how it works is to see it in action! To jump to the appropriate file, just open the TODO pane at the bottom left, and click on the entry that says "Start here to learn more about ApplicationListener and ShapeRenderer". 
