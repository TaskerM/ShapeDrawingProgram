
/**
 * Name: Square.java 
 * Author: Mark Tasker 
 * Date: 2/9/20
 * Purpose: File contains the square class.
 */

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Square extends Rectangle implements Shape {

    /**
     * Initiate a square with length
     *
     * @param length Length of square
     */
    public Square(int length) {
        super(length, length);
    }

    /**
     * Default constructor to instantiate a square.
     */
    public Square() {
    }

    /**
     * Return string array of the shape variables.
     *
     * @return string array of the shape variables.
     */
    @Override
    public String[] getVariables() {
        return new String[]{"Length"};
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
        height = width;
    }
}
