package com.github.MASTRIO.JAGAC;

import com.github.MASTRIO.JAGAC.commands.Compiler;

public class Tick {

  // Game Tick Method
  public static void gameTick() {

    // While Game Running
    while (true) {

      UI.outputPane.setText(Compiler.border + "\n" + UI.output + "\n" + Compiler.border);

    }

  }

}
