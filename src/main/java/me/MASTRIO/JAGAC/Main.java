// Package
package me.MASTRIO.JAGAC;

// Main Class
class Main {

  // Variables
  static int[] version = {
    0, // Major
    5, // Minor
    0 // Patch
  };
  static int maxRan = 10;
  static int minRan = 1;
  static int randomNumber;
  static String splashText;
  static String title;
  static boolean isDebugMode = false;

  // Main Method
  public static void main(String[] args) {

    // Debug Mode?
    try {

      // If debug mode enabled
      if (args[0].equals("debug")) {

        // OUTPUT
        isDebugMode = true;

        UI.outputText("Debug Mode enabled", "");

      }

    // If Debug mode is disabled
    } catch (Exception e) {

      // OUTPUT
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
    }

    title = "JAGAC v" + version[0] + "." + version[1] + "." + version[2] + " | " + splashText;

    // Call the 'makeUI' method
    UI gui = new UI();
    gui.makeUI();

    // Load game data
    LoadData.load();

    // Welcomes the user
    if (isDebugMode) {

      UI.outputText("Welcome back to the game", "Just Another Game About Cheese\nv" + version[0] + "." + version[1] + "." + version[2] + "\n\nDEBUG MODE");

    } else {

      UI.outputText("Welcome back to the game", "Just Another Game About Cheese\nv" + version[0] + "." + version[1] + "." + version[2]);

    }

    // Start Game Tick
    Tick.gameTick();

  }

}
