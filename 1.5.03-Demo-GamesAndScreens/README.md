# Games and Screens

So far we've been making "games" that only display one logical thing to the user, but real games have lots of different sorts of stuff to display. There's the game world itself, but you might also have menus, settings, inventory screens, and so on. You could accomplish that by putting switch statements everywhere, but there's a better way.

LibGDX provides a Screen protocol, and an implementation of ApplicationListener called Game, which delegates all the ApplicationListener callbacks to an implementation of Screen. Then, to change from the a game world to a menu, you just have to call setScreen on your Game.

# Screens in Action

In this project, we have a game where that can switch between two different screens by pressing space bar (we'll explore how to handle input in the next level).
