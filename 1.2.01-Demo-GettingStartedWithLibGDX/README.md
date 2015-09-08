# Importing and Running Your First LibGDX Project

This directory contains a fun little LibGDX demo. This document will explain the project structure, and will explain how to import this project in and this document will explain how to get it
loaded up
 in Android Studio.




### LibGDX App Architecture

A game wants to do a bunch of tasks that are generally very platform dependent. It wants to draw, it wants to play sounds, it wants to store information, and so on. Different platforms will have different APIs for doing these things, so naively, you'd need to write a different version of your game for every platform where you want to release your game.

Fortunately, there's a better solution. LibGDX is a framework that provides APIs for many of the common tasks necessary to write a game. Those APIs can then be implemented by one of a number of different backends. The result is that one can write a game once, targeting the virtual gaming platform defined by LibGDX, and LibGDX provides the infrastructure to run that game on a number of different platforms.

Specifically, LibGDX defines an `Application` interface, which exposes the capabilities of the virtual gaming platform. Each platform that LibGDX supports provides its own implementation of `Application`.


LibGDX apps share a similar structure, no matter where they're running.


## What a LibGDX Project Looks Like

LibGDX allows us to write a game once, then build versions that work on a bunch of platforms, specifically: desktop computers, Android, iOS, and browsers. If we check out the contents of this directory, we see a sub-directory called `core`. This is where we write the

## Gradle



## Installing Android Studio

First things first, we need to install Android Studio. Now I know what you're thinking, "Isn't this a cross-platform game development class? Why are we using ANDROID Studio?"  Well Android Studio is actually based on another integrated development environment called Intellij IDEA, which is a general purpose Java IDE. That means you can build all sorts of stuff in Android Studio that has nothing to do with Android. Like, for instance, the desktop backend of our games.

And of course Android Studio will make deploying the Android version of our game super easy, and it doesn't even blink at deploying the iOS and HTML versions as well.

For specific installation instructions, I'm going to hand you off to Lyla, who made an awesome lesson on Android Studio installation. You can check it out at udacity.com/ud808, or by following the link in the Instructor Notes below the video. When you've got Android Studio up and running, click the box below.

## Installing Required SDK Components

One of the functions of Gradle is to define what version of various tools and libraries your project needs before it can be built. Gradle can usually go download those libraries for you, but it's not able to do that with Android build tools and SDK platforms.

The version of the build tools and the SDK platform that LibGDX uses lags a bit behind the latest and greatest, and you might not have the slightly older version that LibGDX wants. So, the last thing to do before we import our first project is to install the correct build tools and SDK platform versions.

To open up the SDK manager, close any open projects until you get to the Android studio splash screen, then click Configure > SDK Manager.

If you're on the latest version of Android studio, you'll end up in the preferences screen, but let's open up the Standalone SDK Manager by clicking the link at the bottom.

The SDK manager will probably want to install a billion system images that you probably don't want, so first click Deselect All, then select Tools > Android SDK Build-tools Revision 20, and then scroll down and select Android 4.4W.2 (API 20) > SDK Platform. Now hit the Install 2 packages… button.

When the installation is complete, you're ready to run the Desktop backend!

## Running the Desktop Backend

The simplest way to run the desktop backend is to ask Gradle to execute the `run` task on the
`desktop` subproject:

```
    $ ./gradlew desktop:run
```

## Running the Android Backend

## Make a change!



