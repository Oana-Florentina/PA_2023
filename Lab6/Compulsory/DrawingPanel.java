package Compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
/**
*
*A JPanel class that creates and displays a graph with random edges and vertices on it.
*/
public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 1300, H = 750;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image;
    Graphics2D graphics;
   /**
 * Constructor of DrawingPanel class that initializes a new instance with specified MainFrame object.
 *
 * @param frame the MainFrame object
 */
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        this.setDoubleBuffered(true);
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);

        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.decode("#F5EBEB"));
        graphics.fillRect(0, 0, W, H);
    }

    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        if (frame.configPanel.linesCombo.getSelectedItem() != null) {
            edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        } else {
            edgeProbability = 1.0;
        }

        createOffscreenImage();
        createVertices();
        graphics.setColor(Color.BLACK);
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2;
        int radius = H / 2 - 10;
        double alpha = 2 * Math.PI / numVertices;
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }
    }
/**
 * Draws the vertices on the board.
 */
    private void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }
    }

    @Override
    public void update(Graphics graphics) {
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}
