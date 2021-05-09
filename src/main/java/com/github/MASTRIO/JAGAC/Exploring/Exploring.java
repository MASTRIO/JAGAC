package com.github.MASTRIO.JAGAC.Exploring;

import com.github.MASTRIO.JAGAC.Commands.Compiler;
import com.github.MASTRIO.JAGAC.UI;

public class Exploring {

  // Exploring Loop
  public static void loop() {

    if (ExploringUI.distanceToTravel > 0) {

      UI.outputText("Exploring", "Exploring " + Compiler.commandArgs[1] + "km for resources...\n\nTravelled Distance: " + ExploringUI.travelledDistance + "\n" + "Distance To Travel: " + ExploringUI.distanceToTravel);

      ExploringUI.travelledDistance++;
      ExploringUI.distanceToTravel--;

    }

  }

  // Add to the Exploring output box
  public static void output(String message) {

    ExploringUI.log.setText(ExploringUI.log.getText() + message + "\n");

  }

}
