# Importing and Running Your First LibGDX Project

This directory contains a fun little LibGDX demo project. This document will explore the project structure, explain how to import this project into Android Studio, and show how to run the demo on a desktop, and on an Android device.

As an aside, every directory in this repository has either a Readme file like this one, or a set of TODOs that explain what's going on. If you learn best by reading docs and playing with code, you can definitely learn what this course has to offer just by exploring this repository.

### LibGDX App Architecture

A game wants to do a bunch of tasks that are generally very platform dependent. It wants to draw, it wants to play sounds, it wants to store information, and so on. Different platforms will have different APIs for doing these things, so naively, you'd need to write a different version of your game for every platform where you want to release your game.

Fortunately, there's a better solution. LibGDX is a framework that provides APIs for many of the common tasks necessary to write a game. Those APIs can then be implemented by one of a number of different backends. The result is that one can write a game once, targeting the virtual gaming platform defined by LibGDX, and LibGDX provides the infrastructure to run that game on a number of different platforms.

Specifically, LibGDX defines an `Application` interface, which exposes the capabilities of the virtual gaming platform. Each platform that LibGDX supports provides its own implementation of `Application`. Each concrete instance of `Application` is created with two objects, a configuration object, that controls things like window size and device orientation, and an implementation of the `ApplicationListener` interface, which is where your code goes. Your `ApplicationListener` has access to the capabilities provided by its host `Application`, and receives callbacks when it's time to do game specific tasks, chief among them, rendering the game.

## LibGDX Project Directory Structure

LibGDX allows us to write a game once, then build versions that work on a bunch of platforms, specifically: desktop computers, Android, iOS, and browsers. Looking at the contents of this directory, we see sub-directories called `android`, `desktop`, `html`, and `ios`. That's where the code lives that will be used to build those particular backends of our game. There's also a sub-directory called `core`. This is where we write the `ApplicationListener`, and all the code that supports it.

Then there are a bunch of extra files that have to do with something called "Gradle". Gradle is the build tool that handles all the complexities of compiling and packaging all the different versions of your game. Gradle maintains a model of all the source files and resources that belong to your game, and defines tasks that it can perform on your project, stuff like compiling and running different versions of the project. We won't need to interact directly with Gradle, but it's good to know a bit about what's going on under the hood.

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

It's nice to be able to run the project using Ctrl-r, and to do that we can set up a run
configuration.  Navigate to Run > Edit Configurations...

Then click the plus button at the upper right, and select Gradle in the dropdown. We'll call this run configuration "Desktop". The only other field you need fill out is "Task", which should be "desktop:run". Hit OK, and we're good to go. Unfortunately you'll have to do this with every project you import, as these run configurations are stored in the same place as user-specific stuff like the theme you're use, which it doesn't make sense to check into Git.

Anyway, now check the drop down in the toolbar says Desktop, and hit the green arrow, or just press Ctrl-r. Beautiful Udacity Orange, and, as a bonus, if you click and drag around, you get some awesome particle effects!

## Running the Android Backend

Runnin the Android backend is acually easier than running the Desktop backend, assuming you've already [set up your Android device](https://www.udacity.com/course/viewer#!/c-ud808/l-4216368924/m-4291353613). Click on the run configuration
dropdown in the toolbar, and swtich back to "Android", then hit the green button, or press Ctrl-r.

For completeness's sake, if you want to launch the Android backend from the command line, the tasks you need are:

```
    $ ./gradlew android:installDebug android:run
```

## Make a change!

It's hard to feel like you've really set up a project until you make a change, and see your change reflected in the running code. Let's make a simple change to this project. The background seems a little too, well, orange. Let's swap that out for a nice blue color. If you open up the TODO pane at the bottom of Android Studio, you can jump to the spot where you can make that change. Go ahead and swap out the colors, and make sure the project still runs both on your desktop, and on your Android device.
