# Drawing Shapes with LibGDX

## Computer Screens

Back in the day, using a computer monitor was dangerous business. It meant sitting without flinching while an electron gun fired charged particles at at your face at near the speed of light, only to have them slam into a thin layer of glass covered in poison. Depending on where and how many electrons were shot at you, they would produce explosions of different colors and brightnesses, which your eyes would see as an adorable paperclip or whatever. This system is called a cathode ray tube, and it was the bane of LAN parties everywhere.

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

From our discussion of human color vision, we know what's going on with the `r`, `g`, and `b` components. But what's this `alpha` thing? [Alpha](https://en.wikipedia.org/wiki/Alpha_compositing) is basicially transparency.

## Rasterization

Everything you see on your computer screen is a rectangular grid of colors. This makes perfect sense for some things. For instance, a digital photo is captured using a rectangular sensor grid, so the color samples you see on your screen are the same samples that were captured by the camera. But what about a line drawing, like a smiley face? A smiley face is made of circles and arcs. It's not made of a rectangular grid of colors, so how do we draw it to the screen? It seems impossible, right?

To draw shapes like lines, triangles, circles, and other polyhedra, they have to be rasterized. That is, to draw a black arc on a white background, we have to determine for each sample in the raster, whether that sample is inside the arc, or outside, and then color it appropriately. Only then can our shape be drawn to the screen. This process is also called rendering.

This presents a huge challenge though. Which we'll explore by way of a quiz.

Let's say our raster is 1080 pixels by 1920 pixels, we're drawing 20 simple shapes to the screen. Let's then say that for each pixel and each shape, it takes 10 processor cycles to determine if the shape changes the color of the pixel. Finally since we want a silky smooth frame rate, we need to do all this 60 times a second. So, here's the question, how many processor cores running at 3 gigahertz would we need to render this scene?



## ShapeRenderer




LibGDX provides APIs for doing useful stuff that abstracts away the underlying system that is actually providing the service. ShapeRenderer is the


The first class

Of all the useful APIs offered by LibGDX, the first one we're going to use is called for drawing simple shapes: points, lines, rectangles, and more complex polyhedra.

## ApplicationListener

Before we start drawing, we need to know a bit about the lifecycle of a LibGDX game, or at least the part of a LibGDX game you're responsible for. The entry point into your code is a class that implements ApplicationListener. 

<dl>
  <dt><strong>Create</strong></dt>
  <dd>The new version of this product costs significantly less than the
      previous one!</dd>
  <dt><strong>Easier to use</strong></dt>
  <dd>We've changed the product so that it's much easier to use!</dd>
  <dt><strong>Safe for kids</strong></dt>
  <dd>You can leave your kids alone in a room with this product and they
      won't get hurt (not a guarantee).</dd>
</dl>
