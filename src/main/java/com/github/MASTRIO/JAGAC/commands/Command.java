package com.github.MASTRIO.JAGAC.commands;

import com.github.MASTRIO.JAGAC.ItemAPI;
import com.github.MASTRIO.JAGAC.Resources;
import com.github.MASTRIO.JAGAC.Scavenging;
import com.github.MASTRIO.JAGAC.UI;

public class Command {

  // Variables
  static String saveOutput = "Attempting to save the game:";
  static String saveInfo = "";

  // * COMMANDS
  // Inventory Command
  public static void cInventory() {

    if (Compiler.commandArgs[0].equals("inventory")) {

      ItemAPI.defineItems("inventory");
      UI.outputText("Viewing Inventory", ItemAPI.inventoryOutput);
      ItemAPI.inventoryOutput = "Here is your inventory:\n";

    }

  }

  // Balance Command
  public static void cBalance() {

    if (Compiler.commandArgs[0].equals("balance")) {

      UI.outputText("Viewing Balance", "Here is your balance:\n> You have " + Resources.currency[0] + " [🧀] Cheese");

    }

  }

  // Sell Command
  public static void cSell() {

    if (Compiler.commandArgs[0].equals("sell")) {

      ItemAPI.defineItems("sell");
      UI.outputText("Selling " + Compiler.commandArgs[2] + " " + Compiler.commandArgs[1], ItemAPI.sellOutput);

    }

  }

  // Buy Command
  public static void cBuy() {

    if (Compiler.commandArgs[0].equals("buy")) {

      ItemAPI.defineItems("buy");
      UI.outputText("Buying " + Compiler.commandArgs[2] + " " + Compiler.commandArgs[1], ItemAPI.sellOutput);

    }

  }

  // Help Command
  public static void cHelp() {

    if (Compiler.commandArgs[0].equals("help")) {

      UI.outputText("Showing the user the command options", "> help    (Shows this list)\n> balance   (Shows your money)\n> inventory    (Shows your inventory)\n> sell <item> <amount>   (Sell your items)\n> buy <item> <amount>   (Buy items)\n> save   (Saves the game, duh)\n> bank <add/stats> <amount to add>  (Bank related stuff)\n> scavenge (Scavenge for resources)");

    }

  }

  // Scavenge Command
  public static void cScavenge() {

    if (Compiler.commandArgs[0].equals("scavenge")) {

      UI.windowFrame[0] = 800;
      UI.reDraw();
      Scavenging.addScavengingUI();

    }

  }




  // * Testing Commands

  public static void cWidth() {
    if (Compiler.commandArgs[0].equals("width")) {
      UI.windowFrame[0] = 1000;
      UI.outputBox[2] = 975;
      UI.outputBox[3] = 100;
      UI.outputBox[1] = 50;
      UI.inputBox[1] = 168;
      UI.inputBox[0] = 700;
      UI.inputBox[2] = 300;

      UI.reDraw();
    }
  }

}
