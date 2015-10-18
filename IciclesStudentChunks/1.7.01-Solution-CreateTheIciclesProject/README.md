# Create the Icicles Project

LibGDX provides a super convenient project setup utility for setting up a fresh project. We actually included it at the root of the course code (and in this folder), it's called gdx-setup.jar. You can download the setup app by navigating to https://libgdx.badlogicgames.com/, clicking the download tap, and clicking "Download Setup App".

The Setup App wants a Name, we'll use "Icicles". For the package, we've used "com.udacity.gamedev.icicles". For the Game class: "IciclesGame".

Next, the app needs the location where you've installed the Android SDK, or software development kit. You installed this when you installed Android Studio. If you don't remember where it is, you can open up Android Studio's preferences, and search for "SDK". Under Appearance & Behavior > System Settings > Android SDK, you'll find the Android SDK location.

Select the version of LibGDX you want to use, which is generally the latest version. Then you need to decide what subprojects you want to include. Unless you're using an extension that is incompatible with some of the subprojects, just include them all. It's easier to remove a subproject than to add one later.

Finally, you can include various extensions. Box2d is selected by default. It's an awesome 2D physics engine that we'll be using in a later course. Uncheck it for now, though.

Finally, hit Generate!

When the project Generator is done, we can open up our newly created project in Android Studio, and run it, just like we learned back in Level 1-2.

We've got a red screen, and the BadLogic logo! Awesome! Now you can create whatever new projects you want, and don't have to rely on the starter code in the course repository.
