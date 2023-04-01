package Compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitButton = new JButton("Exit");
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton resetButton = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        setLayout(new GridLayout(1, 4));
        Color buttonBackground = Color.decode("#D5B4B4");
        Color buttonText = Color.BLACK;

        loadButton.setBackground(buttonBackground);
        loadButton.setForeground(buttonText);

        saveButton.setBackground(buttonBackground);
        saveButton.setForeground(buttonText);

        resetButton.setBackground(buttonBackground);
        resetButton.setForeground(buttonText);

        exitButton.setBackground(buttonBackground);
        exitButton.setForeground(buttonText);

        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);
        exitButton.addActionListener(this::exitGame);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}