package com.github.MASTRIO.JAGAC.Exploring;

import com.github.MASTRIO.JAGAC.UI;

import javax.swing.*;

public class ExploringUI {

  // Variables
  static JTextArea log;
  private static JLabel title;

  public static int distanceToTravel = 0;
  public static int travelledDistance = 0;
  public static int resourcesCollected = 0;

  public static void addScavengingUI() {

    // * Create UI components
    // Exploring Log
    log = new JTextArea();
    log.setBounds(505, 50, 250, 440);
    UI.panel.add(log);

    // Title
    title = new JLabel();
    title.setText("Exploring");
    title.setFont (title.getFont ().deriveFont (20.0f));
    title.setBounds(580, 5, 200, 50);
    UI.panel.add(title);

    Exploring.loop();

  }

}
