# Drawing Shapes with LibGDX

## Computer Screens

Back in the day, using a computer monitor was dangerous business. It meant sitting without flinching while an electron gun fired charged particles at at your face at near the speed of light, only to have them slam into a thin layer of glass covered in poison. Depending on where and how many electrons were shot at you, they would produce explosions of different colors and brightnesses, which your eyes would see as an adorable paperclip or whatever. This system is called a cathode ray tube, and it was the bane of LAN parties everywhere.

Since the screen is a big rectangle and the electron gun could only paint one dot of color at a time, the gun had to traverse the whole screen many times a second. While I'm sure you can think of all sorts of cool space filling curves that would get the job done, the chosen solution was to divide the screen into horizontal scan lines, much like the text in a book, and scan each line from top to bottom. This was called "raster scanning", from the latin "rastrum", or rake. It's like raking a zen garden, but instead of using a rake with many tines, you just have a stick, so you need to make each groove individually.

The raster scan implies that the colors in the screen have to be laid out in a rectangular grid. While this might seem obvious, it didn't necessarily have to be so. You can certainly imagine a hexagonal grid of colors, and that might well have been better from a human perception point of view. Turns out though that the math of drawing to a hex grid is super frustrating, so maybe it's best that we're stuck with rectangular grids.

So ultimately, for a computer to draw, it constructs a two dimensional array of colors in memory, and then ships those colors to whatever device is going to be displaying the colors, be that a monitor, a projector, or some sweet VR device. Note that these raster samples are also referred to as "picture elements" or pixels, for short.

## Colors

When we draw on a computer, all we're really doing is assembling an array of colors. if you've ever looked at your computer monitor under a magnifying glass, you've probably noticed that each pixel is actually three vertical rectangles, one red, one green, and one blue. And yet, when you take away the magnifying glass, the pixel can look like any color at all. Pretty weird right?

This works because the human eye isn't as good at distinguishing colors as you might think. Visible light is made of packets of energy called photons, and each photon has a wavelength, depending on how much energy it contains. If that wavelength is between 300 nanometers (1e-9 meters, so real small) and 700 nanometers, the eye can pick it up. The eye can't tell what wavelength the incoming photon is, though. All the eye can call is which of three wavelength ranges the photon falls in. The ranges overlap a bit, but

Computers represent colors using



We'll explain why this works in the next couple videos, but the upshot is that we specify colors using four numbers, Red, Green, Blue, and Alpha, or RGBA.  If you want to find the RGB values of a color on your screen, you can use a tool called a digital color meter. If you're on Mac, you actually have one pre-installed. If you're on windows, just search for "digital color meter" and you'll find what you're looking for. If we just mouse around the screen here, we can find the RGB values for various colors. Note that the values are integers, with a max of 255. That's because colors are often represented using one byte for each of the three primary colors.

Why red green and blue? Well human eyes don't see color by measuring the entire visible spectrum of light. Instead they have three types of light sensitive cone cells, each of which responds to different frequencies.  One cone type is most sensitive to high frequencies, which we see as blue, one cone is sensitive to intermediate frequencies, which we see as green, and one that's sensitive to low frequencies, which we see as red. The entirety of our color perception is based on the response of these three types of cells. The red, green, and blue light produced by a monitor each stimulates one type of cone cell, so the monitor can dial in any naturally occurring color using just red, green, and blue.

So that's RGB, but what's the A in RGBA? The A stands for alpha, and it's basically transparency. If you want your drawing to be opaque (which is generally the case), you want an Alpha value of 1. If you have an Alpha value of 0, you won't see anything at all. An alpha value of .5 means that the color of your drawing will be 50% the color you specify, and 50% whatever color was there before.

## ShapeRenderer

LibGDX provides APIs for doing useful stuff that abstracts away the underlying system that is actually providing the service. ShapeRenderer is the


The first class

Of all the useful APIs offered by LibGDX, the first one we're going to use is called for drawing simple shapes: points, lines, rectangles, and more complex polyhedra.

