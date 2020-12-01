
/**
 * Name: Cone.java 
 * Author: Mark Tasker 
 * Date: 2/9/20
 * Purpose: File contains the Cone shape class.
 */

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Cone implements Shape {

    /**
     * The radius, height, axe of Cone
     */
    int r, h, a;

    /**
     * Cone to instantiate cone with r,h,s.
     *
     * @param r the radius of the cone.
     * @param h the height of the cone.
     * @param a the axis of the cone.
     */
    public Cone(int r, int h, int a) {
        this.r = r;
        this.h = h;
        this.a = a;
    }

    /**
     * Default constructor to instantiate the cone.
     */
    public Cone() {
    }

    /**
     * Function responsible for drawing the Cone in the context of the graphics
     * g2d.
     *
     * @param g2d The context to be drawn over.
     * @param size The frame windows size.
     */
    @Override
    public void drawSwing(Graphics2D g2d, Dimension size) {
        try {
            BufferedImage image = ImageIO.read(new File("imgs/cone.jpg"));
            int px = (size.width - image.getWidth(null)) / 2;
            int py = (size.height - image.getHeight(null)) / 2;
            g2d.drawImage(image, px, py, null);
        } catch (IOException ex) {
            Logger.getLogger(Cone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Return string array of the shape variables.
     *
     * @return string array of the shape variables.
     */
    @Override
    public String[] getVariables() {
        return new String[]{"R", "H", "A"};
    }

    /**
     * Get inputs from the GUI the user entered.
     *
     * @param textPanels Array of panels including the text fields the user
     * editing.
     */
    @Override
    public void getInputs(ArrayList<JPanel> textPanels) {
        r = Integer.parseInt(((JTextField) textPanels.get(0).getComponent(1)).getText());
        h = Integer.parseInt(((JTextField) textPanels.get(1).getComponent(1)).getText());
        a = Integer.parseInt(((JTextField) textPanels.get(2).getComponent(1)).getText());
    }

}
