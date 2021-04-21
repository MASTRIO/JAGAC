package com.github.MASTRIO.JAGAC;

import com.github.MASTRIO.JAGAC.data.Load;

public class Main {

  // Variables
  static int[] version = {
    0, // Major
    5, // Minor
    0 // Patch
  };
  static int maxRan = 11;
  static int minRan = 1;
  static int randomNumber;
  static String splashText;
  static String title;
  public static boolean isDebugMode = false;

  // Events
  static boolean[] events = {
    false // TODO: Give this a use lol
  };

  // Main Method
  public static void main(String[] args) {

    // Debug Mode
    try {

      if (args[0].equals("debug")) {

        isDebugMode = true;
        UI.outputText("Debug Mode enabled", "doogboog mode nabled");

      }

    } catch (Exception e) {

      UI.outputText("Debug Mode disabled", "Debug mode disbled");

    }

    // Splash Text
    randomNumber = (int) ((Math.random() * ((maxRan - minRan) + 1)) + minRan);
    if (randomNumber == 1) {
      splashText = "Now with a UI!";
    } else if (randomNumber == 2) {
      splashText = "Python, C++, Java, what's next?";
    } else if (randomNumber == 3) {
      splashText = "Why is a Child an item?";
    } else if (randomNumber == 4) {
      splashText = "moose...";
    } else if (randomNumber == 5) {
      splashText = "Interesting splash text goes here";
    } else if (randomNumber == 6) {
      splashText = "Steve in mash bros?";
    } else if (randomNumber == 7) {
      splashText = "splashText";
    } else if (randomNumber == 8) {
      splashText = "MrBeast6000";
    } else if (randomNumber == 9) {
      splashText = "You know what would be cool? cuz I don't";
    } else if (randomNumber == 10) {
      splashText = "Yo you got splash text 10!";
    } else if (randomNumber == 11) {
      splashText = "I am NOT short";
    }

    title = "JAGAC v" + version[0] + "." + version[1] + "." + version[2] + " | " + splashText;

    // Make the UI
    UI.makeUI();

    // Load game me.MASTRIO.JAGAC.data
    Load.load();

    if (isDebugMode) {

      UI.outputText("Welcome back to the game", "Just Another Game About Cheese\nv" + version[0] + "." + version[1] + "." + version[2] + "\n\nDEBUG MODE");

    } else {

      UI.outputText("Welcome back to the game", "Just Another Game About Cheese\nv" + version[0] + "." + version[1] + "." + version[2]);

    }

    // Start Game Tick
    Tick.gameTick();

  }

}
