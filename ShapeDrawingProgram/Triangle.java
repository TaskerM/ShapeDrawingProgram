
/**
 * Name: Triangle.java 
 * Author: Mark Tasker 
 * Date: 2/9/20
 * Purpose: File contains the Cone shape class. Class is responsible for operation considering drawing Triangle.
 */
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Triangle implements Shape {

    /**
     * Lengths of the triangle.
     */
    int x, y, z;

    /**
     * Default constructor to instantiate a triangle.
     */
    public Triangle() {
    }

    /**
     * Function responsible for Sphere the Triangle in the context of the
     * graphics g2d.
     *
     * @param g2d The context to be drawn over.
     * @param size The frame windows size.
     */
    @Override
    public void drawSwing(Graphics2D g2d, Dimension size) {
        // Convert the lengths into 3 points a,b,c
        Point a = new Point(0, 0);
        Point b = new Point(z, 0);
        double cx = ((x * x) - (y * y) - (z * z)) / (-2 * z);
        Point c = new Point((int) cx, (int) Math.sqrt((y * y) - (cx * cx)));

        // create polygon with the 3 points
        Polygon tri = new Polygon();
        tri.addPoint(a.x, a.y);
        tri.addPoint(b.x, b.y);
        tri.addPoint(c.x, c.y);

        // get the center point of the triangle and translate the polygon to be
        // its center
        Point center = new Point((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3);
        tri.translate(size.width / 2 - center.x, size.height / 2 - center.y);

        // draw the polygon
        g2d.drawPolygon(tri);
    }

    /**
     * Return string array of the shape variables.
     *
     * @return string array of the shape variables.
     */
    @Override
    public String[] getVariables() {
        return new String[]{"1st side", "2nd side", "3rd side"};
    }

    /**
     * Get inputs from the GUI the user entered.
     *
     * @param textPanels Array of panels including the text fields the user
     * editing.
     */
    @Override
    public void getInputs(ArrayList<JPanel> textPanels) {
        x = Integer.parseInt(((JTextField) textPanels.get(0).getComponent(1)).getText());
        y = Integer.parseInt(((JTextField) textPanels.get(1).getComponent(1)).getText());
        z = Integer.parseInt(((JTextField) textPanels.get(2).getComponent(1)).getText());

    }
}
