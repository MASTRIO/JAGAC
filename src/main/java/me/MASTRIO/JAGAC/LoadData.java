package me.MASTRIO.JAGAC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadData {

  public static void load() {

    // OUTPUT
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

      // If Debug Mode
      if (Main.isDebugMode) {

        // OUTPUT
        UI.outputText("Loading Game Data", "Loading Game Data:\n" + loadOutput);

        // If not Debug Mode
      } else {

        // OUTPUT
        UI.outputText("Loading Game Data", "Loading Game Data");

      }

      saveReader.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

}
