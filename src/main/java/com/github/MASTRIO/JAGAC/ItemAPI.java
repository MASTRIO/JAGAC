package com.github.MASTRIO.JAGAC;

import com.github.MASTRIO.JAGAC.commands.Compiler;
import com.github.MASTRIO.JAGAC.data.Save;

public class ItemAPI {

  // Variables
  public static String inventoryOutput = "Here is your inventory:\n";
  public static String sellOutput;

  // Define Items
  public static void defineItems(String accessType) {

    newItem(accessType, "shiny_gems", "Shiny Gems", 0, 10, 15);
    newItem(accessType, "cheese_jumpers", "Cheese Jumpers", 1, 40, 45);
    newItem(accessType, "blue_cheese", "Blue Cheese", 2, 95, 100);
    newItem(accessType, "pebbles", "Pebbles", 3, 5, 10);
    newItem(accessType, "sticks", "Sticks", 4, 5, 10);
    newItem(accessType, "logs", "Logs", 5, 15, 20);
    newItem(accessType, "rubys", "Rubys", 6, 25, 30);
    newItem(accessType, "leaves", "Leaves", 7, 5, 10);
    newItem(accessType, "carrots", "Carrots", 8, 10, 15);
    newItem(accessType, "potatoes", "Potatoes", 9, 10, 15);
    newItem(accessType, "bread", "Bread", 10, 15, 20);
    newItem(accessType, "bricks", "Bricks", 11, 10, 15);
    newItem(accessType, "mouldy_potatoes", "Mouldy Potatoes", 12, 15, 20);
    newItem(accessType, "child", "Child", 13, 35, 40);
    newItem(accessType, "toy_bears", "Toy Bears", 14, 15, 20);
    newItem(accessType, "moose", "Moose", 15, 25, 30);


  }

  // New Item Method
  public static void newItem(String accessType, String code_name, String name, int id, int sellPrice, int buyPrice) {

    // Inventory
    if (accessType.equals("inventory")) {

      if (Resources.items[id] > 0) {

        inventoryOutput = inventoryOutput + "> [ " + Resources.items[id] + " ] " + name + "\n";

      }

    }
    // Sell
    if (accessType.equals("sell")) {

      if (Compiler.commandArgs[1].equals(code_name) && (Resources.items[id]) > (Integer.parseInt(Compiler.commandArgs[2]))) {

        sellOutput = "You sold " + Compiler.commandArgs[2] + " " + name + " For " + (Integer.parseInt(Compiler.commandArgs[2]) * sellPrice + " 🧀\n");
        Resources.items[id] = Resources.items[id] - Integer.parseInt(Compiler.commandArgs[2]);
        Resources.currency[0] = Resources.currency[0] + (Integer.parseInt(Compiler.commandArgs[2]) * sellPrice);
        sellOutput = sellOutput + "You now have " + Resources.items[id] + " " + name + " and " + Resources.currency[0] + " Cheese";

      }


    }
    // Buy
    if (accessType.equals("buy")) {

      if (Compiler.commandArgs[1].equals(code_name) && (Integer.parseInt(Compiler.commandArgs[2])) < (Resources.currency[0])) {

        sellOutput = "You bought " + Compiler.commandArgs[2] + " Cheese For " + (Integer.parseInt(Compiler.commandArgs[2]) * buyPrice + " " + name + "\n");
        Resources.items[id] = Resources.items[id] + Integer.parseInt(Compiler.commandArgs[2]);
        Resources.currency[0] = Resources.currency[0] - (Integer.parseInt(Compiler.commandArgs[2]) * buyPrice);
        sellOutput = sellOutput + "You now have " + Resources.currency[0] + " Cheese and " + Resources.items[id] + " " + name;

      }

    }
    // Save
    if (accessType.equals("save")) {

      Save.saveInfo = Save.saveInfo + Resources.items[id] + "\n";

    }

  }

}
