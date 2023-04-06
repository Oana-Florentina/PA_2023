package Compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        saveButton.addActionListener(this::saveImage);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    private void saveImage(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            BufferedImage image = frame.drawingPanel.image;
            try {
                ImageIO.write(image, "PNG", fileToSave);
                JOptionPane.showMessageDialog(frame, "Image saved successfully!");
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(frame, "Error saving image: " + exception.getMessage());
            }
        }
    }
}