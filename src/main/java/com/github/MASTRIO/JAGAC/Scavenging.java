package com.github.MASTRIO.JAGAC;

import javax.swing.*;

public class Scavenging {

  public static void addScavengingUI() {

    // Variables
    JTextArea scavengingLog;

    // * Create UI components
    scavengingLog = new JTextArea();
    scavengingLog.setBounds(525, 50, 210, 250);
    UI.panel.add(scavengingLog);

  }

}
