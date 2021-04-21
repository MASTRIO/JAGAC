package com.github.MASTRIO.JAGAC.data;

import com.github.MASTRIO.JAGAC.ItemAPI;
import com.github.MASTRIO.JAGAC.Resources;
import com.github.MASTRIO.JAGAC.UI;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

  // Variables
  public static String saveInfo = "";

  // Save Data Method
  public static void saveData() {

    // Variables
    String saveOutput = "";

    // Create save file
    try {

      File saveFiles = new File("jagac.save");

      if (saveFiles.createNewFile()) {

        saveOutput = saveOutput + "Creating new save file\n";

      } else {

        saveOutput = saveOutput + "Rewriting existing save file\n";

      }

    } catch (IOException e) {

      System.out.println("uh oh error go brrrrrrrrrrrrrrrrrrr");
      e.printStackTrace();

    }

    // Save Data
    try {

      ItemAPI.defineItems("save");
      FileWriter saveData = new FileWriter("jagac.save");

      saveData.write(Resources.bank[0] + "\n");
      saveData.write(Resources.bank[1] + "\n");
      saveData.write(Resources.currency[0] + "\n");
      ItemAPI.defineItems("save");
      saveData.write(saveInfo);

      saveData.close();
      saveOutput = saveOutput + ">>> Saved the Game <<<";

    } catch (IOException e) {

      System.out.println("uh oh an error occured");
      e.printStackTrace();

    }

    UI.outputText("Saved Game Data", saveOutput);

  }

}
