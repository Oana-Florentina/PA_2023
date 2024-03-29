package Compulsory;

import javax.swing.*;

import java.awt.*;

import static java.awt.BorderLayout.*;
/**
The MainFrame class that  is responsible for initializing the drawing application and its components.
*/

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;
/**
 * Constructor for the MainFrame class.
 * Initializes the drawing application.
 */
    public MainFrame() {
        super("My Drawing Application");
        init();
    }
/**
 * Initializes the drawing application components.
 */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        configPanel = new ConfigPanel(this);
        configPanel.setBackground(Color.decode("#DBA39A"));
        add(configPanel, NORTH);

        controlPanel = new ControlPanel(this);
        add(controlPanel, SOUTH);
        controlPanel.setBackground(Color.decode("#DBA39A"));

        drawingPanel = new DrawingPanel(this);
        add(drawingPanel, CENTER);

        pack();
    }
}
