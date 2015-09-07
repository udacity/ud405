# Importing and Running Your First LibGDX Project

This directory contains a fun little LibGDX demo, and this document will explain how to get it loaded up in Android Studio.

## LibGDX App Architechure

A game wants to do a bunch of tasks that are generally very platform dependant. It wants to draw, it wants to play sounds, it wants to store information, and so on. Different platforms will have different APIs for doing these things, so i


LibGDX has a hard job: it needs to execute the same game logic on a bunch of different platforms. To do this, it creates a 

LibGDX apps share a similar structure, no matter where they're running. 


## What a LibGDX Project Looks Like

The whole point of LibGDX is that we can write a game once, and then build versions that work on a bunch of platforms, specificially: desktop computers, Android, iOS, and browsers. If we check out the contents of this directory, we see a sub-directory called `core`. This is where we write the 

## Gradle



## Installing Android Studio

First things first, we need to install Android Studio. Now I know what you're thinking, "Isn't this a cross-platform game development class? Why are we using ANDROID Studio?"  Well Android Studio is actually based on another integrated development environment called Intellij IDEA, which is a general purpose Java IDE. That means you can build all sorts of stuff in Android Studio that has nothing to do with Android. Like, for instance, the desktop backend of our games.

And of course Android Studio will make deploying the Android version of our game super easy, and it doesn't even blink at deploying the iOS and HTML versions as well.

For specific installation instructions, I'm going to hand you off to Lyla, who made an awesome lesson on Android Studio installation. You can check it out at udacity.com/ud808, or by following the link in the Instructor Notes below the video. When you've got Android Studio up and running, click the box below.

## Installing Required SDK Components

