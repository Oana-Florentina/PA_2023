package Compulsory;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox<Object> linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    ChangeListener changeListenerDotsSpinner = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            frame.drawingPanel.createBoard();
        }
    };
    ActionListener actionListenerLinesCombo = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.drawingPanel.createBoard();
        }
    };
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        createButton = new JButton();
        linesLabel = new JLabel("Line probability:");
        linesCombo = new JComboBox<>();
        double[] probabilitiesArray = {0.0,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0};
        for(var probability : probabilitiesArray){
            linesCombo.addItem(probability);
        }
        dotsSpinner.addChangeListener(changeListenerDotsSpinner);
        linesCombo.addActionListener(actionListenerLinesCombo);

        Color buttonText = Color.BLACK;


        dotsLabel.setForeground(buttonText);
        linesLabel.setForeground(buttonText);

        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
    }
}
