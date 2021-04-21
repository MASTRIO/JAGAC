package com.github.MASTRIO.JAGAC;

import com.github.MASTRIO.JAGAC.commands.Compiler;
import com.github.MASTRIO.JAGAC.data.Save;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UI extends Component implements ActionListener {

  // Variables
  public static String command;
  static DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
  static LocalDateTime localTime = LocalDateTime.now();
  static DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH");
  static DateTimeFormatter minute = DateTimeFormatter.ofPattern("mm");
  static DateTimeFormatter second = DateTimeFormatter.ofPattern("ss");
  static String output;

  // UI variables
  static JFrame frame;
  static JPanel panel;
  static JTextArea outputPane;
  static JTextField commandInputBox;
  static JButton runCommandButton;
  static JButton saveButton;
  static JButton previousCommandButton;

  // Actions
  private enum Actions {
    Run,
    Save,
    VVV
  }

  // UI sizes
  public static int[] windowFrame = {
    500, // width
    600 // height
  };
  public static int[] outputBox = {
    5, // x
    5, // y
    475, // width
    485 // height
  };
  public static int[] inputBox = {
    5, // x
    517, // y
    410, // width
    40 // height
  };
  public static int[] commandButton = {
    417, // x
    517, // y
    63, // width
    39 // height
  };
  public static int[] saveDataButton = {
    5, // x
    493, // y
    63, // width
    22 // height
  };
  public static int[] previousButton = {
    417, // x
    493, // y
    63, // width
    22 // height
  };

  // Make UI Method
  public static void makeUI() {

    // Create base UI
    panel = new JPanel();
    frame = new JFrame(Main.title);
    frame.setSize(windowFrame[0], windowFrame[1]);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    panel.setLayout(null);

    // * Make UI Objects
    // Command Output box
    outputPane = new JTextArea();
    outputPane.setBounds(outputBox[0], outputBox[1], outputBox[2], outputBox[3]);
    panel.add(outputPane);

    // Command Input box
    commandInputBox = new JTextField();
    commandInputBox.setBounds(inputBox[0], inputBox[1], inputBox[2], inputBox[3]);
    panel.add(commandInputBox);

    // Execute Command Button
    runCommandButton = new JButton("Run");
    runCommandButton.setBounds(commandButton[0], commandButton[1], commandButton[2], commandButton[3]);
    runCommandButton.addActionListener(new UI());
    panel.add(runCommandButton);

    // Save Button
    saveButton = new JButton("Save");
    saveButton.setBounds(saveDataButton[0], saveDataButton[1], saveDataButton[2], saveDataButton[3]);
    saveButton.addActionListener(new UI());
    panel.add(saveButton);

    // Previous Command Button
    previousCommandButton = new JButton("VVV");
    previousCommandButton.setBounds(previousButton[0], previousButton[1], previousButton[2], previousButton[3]);
    previousCommandButton.addActionListener(new UI());
    panel.add(previousCommandButton);

    // Make UI Visible
    frame.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equals(Actions.Run.name())) {

      command = commandInputBox.getText();
      Compiler.compileCommand();
      commandInputBox.setText("");

    } else if (e.getActionCommand().equals(Actions.Save.name())) {

      Save.saveData();

    } else if (e.getActionCommand().equals(Actions.VVV.name())) {

      command = Compiler.preCommand;
      Compiler.compileCommand();

    }

  }

  // Redraws the UI
  public static void reDraw() {

    UI.frame.setVisible(false);
    UI.makeUI();

  }

  // Output Text Method
  public static void outputText(String consoleMessage, String UIoutput) {

    output = UIoutput;

    if (Main.isDebugMode) {

      System.out.println("[" + (time.format(localTime)) + " | CommandOutput]@>>> " + consoleMessage);

    }


  }

}
