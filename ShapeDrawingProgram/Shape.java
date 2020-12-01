
/**
 * Name: Shape.java 
 * Author: Mark Tasker 
 * Date: 2/9/20
 * Purpose: File contains the Shape shape class.
 */

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public interface Shape {

    /**
     * Function responsible for drawing a shape in the context of the graphics
     * g2d.
     *
     * @param g2d The context to be drawn over.
     * @param size The frame windows size.
     */
    public void drawSwing(Graphics2D g2d, Dimension size);

    /**
     * Return string array of the shape variables.
     *
     * @return string array of the shape variables.
     */
    public String[] getVariables();

    /**
     * Get inputs from the GUI the user entered.
     *
     * @param textPanels Array of panels including the text fields the user
     * editing.
     */
    public void getInputs(ArrayList<JPanel> textPanels);
}
