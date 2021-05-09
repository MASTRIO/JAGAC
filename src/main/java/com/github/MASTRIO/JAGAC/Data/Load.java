package com.github.MASTRIO.JAGAC.Data;

import com.github.MASTRIO.JAGAC.Main;
import com.github.MASTRIO.JAGAC.Resources;
import com.github.MASTRIO.JAGAC.UI;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Load {

  public static void load() {

    // Variables
    int idLoad = -3;

    try {

      File saveFiles = new File("jagac.save");
      Scanner saveReader = new Scanner(saveFiles);

      String loadOutput = "";
      while (saveReader.hasNextLine()) {

        if (idLoad == 16) {

          return;

        }

        if (idLoad == -3) {

          Resources.bank[0] = Double.parseDouble(saveReader.nextLine());

        } else if (idLoad == -2) {

          Resources.bank[1] = Double.parseDouble(saveReader.nextLine());

        } else if (idLoad == -1) {

          Resources.currency[0] = Integer.parseInt(saveReader.nextLine());

        } else {

          Resources.items[idLoad] = Integer.parseInt(saveReader.nextLine());
          loadOutput = loadOutput + Resources.items[idLoad] + "\n";

        }

        idLoad++;

      }

      if (Main.isDebugMode) {

        UI.outputText("Loading Game Data", "Loading Game Data:\n" + loadOutput);

      } else {

        UI.outputText("Loading Game Data", "Loading Game Data");

      }

      saveReader.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

}
