// Package
package me.MASTRIO.JAGAC;

// Class
public class Tick {

  // Game Tick Method
  public static void gameTick() {

    // Variables
    int preHour = 00;

    // While Game Running
    while (true) {

      // Update the output pane
      UI.outputPane.setText(CommandCompiler.border + "\n" + UI.output + "\n" + CommandCompiler.border);

      // Do 'big brain math' to calculate bank thing
      Resources.bank[1] = Resources.bank[0] * 0.37;

      // Give player cheese from bank
      if (Integer.parseInt(UI.minute.format(UI.localTime)) > preHour) {

        for (int i = Integer.parseInt(UI.minute.format(UI.localTime)); i > preHour;) {

          Resources.currency[0] = Resources.currency[0] * (int) Resources.bank[1];

          i--;

        }

      }

      preHour = Integer.parseInt(UI.minute.format(UI.localTime));

      // Re-Draw the UI
      new UI();

    }

  }

}
