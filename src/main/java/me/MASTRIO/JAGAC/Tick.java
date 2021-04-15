// Package
package me.MASTRIO.JAGAC;

// Class
public class Tick {

  // Game Tick Method
  public static void gameTick() {

    // While Game Running
    while (true) {

      // Update the output pane
      UI.outputPane.setText(CommandCompiler.border + "\n" + UI.output + "\n" + CommandCompiler.border);

      // Re-Draw the UI
      new UI();

    }

  }

}
