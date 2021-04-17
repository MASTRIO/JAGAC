// Package
package me.MASTRIO.JAGAC;

// Class
public class ItemAPI {

  // Variables
  static String inventoryOutput = "Here is your inventory:\n";
  static String sellOutput;

  // Define Items
  public static void defineItems(String accessType) {

    // TODO: Remove Icons because gradle doesn't like unicode i guess

    newItem(accessType, "shiny_gems", "Shiny Gems", 0, "✨💎", 10, 15);
    newItem(accessType, "cheese_jumpers", "Cheese Jumpers", 1, "🧀🥋", 40, 45);
    newItem(accessType, "blue_cheese", "Blue Cheese", 2, "Ƀ🧀", 95, 100);
    newItem(accessType, "pebbles", "Pebbles", 3, "⭖", 5, 10);
    newItem(accessType, "sticks", "Sticks", 4, "/", 5, 10);
    newItem(accessType, "logs", "Logs", 5, "⍃", 15, 20);
    newItem(accessType, "rubys", "Rubys", 6, "я💎", 25, 30);
    newItem(accessType, "leaves", "Leaves", 7, "🍁", 5, 10);
    newItem(accessType, "carrots", "Carrots", 8, "🥕", 10, 15);
    newItem(accessType, "potatoes", "Potatoes", 9, "🥔", 10, 15);
    newItem(accessType, "bread", "Bread", 10, "🍞", 15, 20);
    newItem(accessType, "bricks", "Bricks", 11, "🧱", 10, 15);
    newItem(accessType, "mouldy_potatoes", "Mouldy Potatoes", 12, "☠🥔", 15, 20);
    newItem(accessType, "child", "Child", 13, "🚼", 35, 40);
    newItem(accessType, "toy_bears", "Toy Bears", 14, "🧸", 15, 20);
    newItem(accessType, "moose", "Moose", 15, "🐎", 25, 30);


  }

  // New Item Method
  public static void newItem(String accessType, String code_name, String name, int id, String icon, int sellPrice, int buyPrice) {

    // Inventory
    if (accessType.equals("inventory")) {

      // OUTPUT
      if (Resources.items[id] > 0) {

        inventoryOutput = inventoryOutput + "> [ " + icon + " ] " + Resources.items[id] + " | " + name + "\n";

      }

    }
    // Sell
    if (accessType.equals("sell")) {

      // OUTPUT
      if (CommandCompiler.commandArgs[1].equals(code_name) && (Resources.items[id]) > (Integer.parseInt(CommandCompiler.commandArgs[2]))) {

        // OUTPUT
        // How much you sold
        sellOutput = "You sold " + CommandCompiler.commandArgs[2] + " " + icon + " For " + (Integer.parseInt(CommandCompiler.commandArgs[2]) * sellPrice + " 🧀\n");

        // Sell Stuff
        Resources.items[id] = Resources.items[id] - Integer.parseInt(CommandCompiler.commandArgs[2]);
        Resources.currency[0] = Resources.currency[0] + (Integer.parseInt(CommandCompiler.commandArgs[2]) * sellPrice);

        // Sellage result
        sellOutput = sellOutput + "You now have " + Resources.items[id] + " " + icon + " and " + Resources.currency[0] + " 🧀";

      }


    }
    // Buy
    if (accessType.equals("buy")) {

      // OUTPUT
      if (CommandCompiler.commandArgs[1].equals(code_name) && (Integer.parseInt(CommandCompiler.commandArgs[2])) < (Resources.currency[0])) {

        // OUTPUT
        // How much you sold
        sellOutput = "You bought " + CommandCompiler.commandArgs[2] + " 🧀 For " + (Integer.parseInt(CommandCompiler.commandArgs[2]) * buyPrice + " " + icon + "\n");

        // Sell Stuff
        Resources.items[id] = Resources.items[id] + Integer.parseInt(CommandCompiler.commandArgs[2]);
        Resources.currency[0] = Resources.currency[0] - (Integer.parseInt(CommandCompiler.commandArgs[2]) * buyPrice);

        // Sellage result
        sellOutput = sellOutput + "You now have " + Resources.currency[0] + " 🧀 and " + Resources.items[id] + " " + icon;

      }

    }
    // Save
    if (accessType.equals("save")) {

      // OUTPUT
      CommandList.saveInfo = CommandList.saveInfo + Resources.items[id] + "\n";

    }

  }

}
