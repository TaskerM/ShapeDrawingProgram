
/**
 * Name: Circle.java 
 * Author: Mark Tasker 
 * Date: 2/9/20
 * Purpose: File contains the circle shape class. Class responsible for operation considering drawing circle in a swing frame
 */
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Circle implements Shape {

    /**
     * Radius of the circle.
     */
    private int radius;

    /**
     * Default constructor of the circle class.
     */
    public Circle() {
    }

    /**
     * Construct a circle with Radius equal to radius.
     *
     * @param radius the instantiated circle radius.
     */
    public Circle(int radius) {
        this.radius = radius;
    }

    /**
     * Function responsible for drawing the circle in the context of the
     * graphics g2d.
     *
     * @param g2d The context to be drawn over.
     * @param size The frame windows size.
     */
    @Override
    public void drawSwing(Graphics2D g2d, Dimension size) {
        g2d.drawOval(size.width / 2 - radius, size.height / 2 - radius, radius * 2, radius * 2);
    }

    /**
     * Return string array of the shape variables.
     *
     * @return string array of the shape variables.
     */
    @Override
    public String[] getVariables() {
        return new String[]{"Radius"};
    }

    /**
     * Get inputs from the GUI the user entered.
     *
     * @param textPanels Array of panels including the text fields the user
     * editing.
     */
    @Override
    public void getInputs(ArrayList<JPanel> textPanels) {
        radius = Integer.parseInt(((JTextField) textPanels.get(0).getComponent(1)).getText());
    }

}
