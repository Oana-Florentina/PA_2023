package Homework;
import java.awt.*;
/**
*
*Class that represents a line connecting two dots.
*/
public class Line {
    private Dot dot1;
    private Dot dot2;
    private Color color;

/**
 * Constructs a line object that connects two dots.
 * @param dot1 the first dot in the line
 * @param dot2 the second dot in the line
 */
    public Line(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.color = Color.GRAY;
    }
    public Dot getDot1() {
        return dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean contains(Dot dot) {
        return dot == dot1 || dot == dot2;
    }
}
