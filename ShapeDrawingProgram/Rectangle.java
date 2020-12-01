
/**
 * Name: Rectangle.java 
 * Author: Mark Tasker 
 * Date: 2/9/20
 * Purpose: File contains the rectangle shape class.
 */

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Rectangle implements Shape {

    /**
     * Width of the rectangle.
     */
    protected int width;
    /**
     * Height of the rectangle.
     */
    protected int height;

    /**
     * Constructor to instantiate the rectangle with width and height.
     *
     * @param width of the rectangle
     * @param height of the rectangle
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Function responsible for drawing the Rectangle in the context of the
     * graphics g2d.
     *
     * @param g2d The context to be drawn over.
     * @param size The frame windows size.
     */
    @Override
    public void drawSwing(Graphics2D g2d, Dimension size) {
        g2d.drawRect((size.width - width) / 2, (size.height - height) / 2, width, height);
    }

    /**
     * Default constructor to draw a Rectangle.
     */
    public Rectangle() {
    }

    /**
     * Return string array of the shape variables.
     *
     * @return string array of the shape variables.
     */
    @Override
    public String[] getVariables() {
        return new String[]{"Width", "Height"};
    }

    /**
     * Get inputs from the GUI the user entered.
     *
     * @param textPanels Array of panels including the text fields the user
     * editing.
     */
    @Override
    public void getInputs(ArrayList<JPanel> textPanels) {
        width = Integer.parseInt(((JTextField) textPanels.get(0).getComponent(1)).getText());
        height = Integer.parseInt(((JTextField) textPanels.get(1).getComponent(1)).getText());
    }
}
