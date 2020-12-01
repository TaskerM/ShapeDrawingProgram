
/**
 * Name: ShaperDrawer.java 
 * Author: Mark Tasker 
 * Date: 2/9/20
 * Purpose: File contains the shapedrawer class.
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class ShapeDrawer {

    private static JFXPanel fxContainer;
    private static JFrame frame2;
    private static Shape shape = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
            }

            // Initiate the drawing swing frame  
            frame2 = new JFrame("Swing Drawer");
            // use the inner class customPaintComponent as the main component of
            // this frame
            frame2.add(new CustomPaintComponent());
            frame2.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
            frame2.setVisible(true);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Intiate the controller frame for user interaction.
            // Use the inner class customPaintComponent as the main component of
            // this frame
            JFrame frame = new ShapeDrawerControllerJFrame();
            frame.setTitle("Drawing controller");
            frame.setLocation(0, 0);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setAlwaysOnTop(true);
            frame.pack();
            frame.setSize(300, 300);
            frame.setResizable(false);
            ((ShapeDrawerControllerJFrame) frame).init();
        });
    }

    /**
     * Internal class responsible for Drawing in the drawing frame.
     */
    static class CustomPaintComponent extends Component {

        /**
         * Function to draw the shape element specified by user in the GUI.
         *
         * @param g The specific context to paint over.
         */
        @Override
        public void paint(Graphics g) {
            // Retrieve the graphics context; this object is used to paint shapes
            Graphics2D g2d = (Graphics2D) g;

            // draw the shape
            if (shape != null) {
                shape.drawSwing(g2d, getSize());
            }
        }
    }

    /**
     * Internal class responsible for user interaction in the frame.
     */
    static class ShapeDrawerControllerJFrame extends JFrame {

        /**
         * Custom font used all over the frame.
         */
        Font customFont;
        /**
         * The panels including the labels and textFields for user.
         */
        ArrayList<JPanel> textPanels;

        /**
         * function to initialize the frame and the actionListeners.
         */
        public void init() {
            // initiate the custom font
            customFont = new Font("Arial", Font.PLAIN, 16);

            fxContainer = new JFXPanel();
            add(fxContainer, BorderLayout.CENTER);
            // create JavaFX scene
            Platform.runLater(this::createScene);
        }

        /**
         * Function to create the JavaFX scene.
         */
        private void createScene() {
            // initiate the text panels with 3 panels. Each one has label and
            // text field for 3 different variables (maximum number of 
            // variables)
            textPanels = new ArrayList<>();
            textPanels.add(getVariableControllerTempPanel());
            textPanels.add(getVariableControllerTempPanel());
            textPanels.add(getVariableControllerTempPanel());
            // by default we will hide all of them except the first one.
            for (JPanel panel : textPanels) {
                panel.setVisible(false);
            }
            textPanels.get(0).setVisible(true); // by default

            // Initiate the combobox
            String[] options = {"Circle", "Square", "Triangle", "Rectangle",
                "Sphere", "Cube", "Cone", "Cylinder", "Torus"};
            JComboBox<String> shapesCombo = new JComboBox<>(options);
            shapesCombo.setFont(customFont);
            // use the ShapeChange function to initiate the action listener 
            shapesCombo.addActionListener(this::shapeChange);
            shapesCombo.setSelectedIndex(0);

            // initiate the button "Draw !"
            JButton btn = new JButton();
            btn.setText("Draw !");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    // Order the shape to get inputs from user text fields in
                    // the panel.
                    shape.getInputs(textPanels);
                    // order the gui to take the changes.
                    frame2.repaint();
                }
            });
            btn.setFont(customFont);

            // add all the created componenets to the panel to be drawn 
            //(we stil in the init process.)
            JPanel jp = new JPanel();
            jp.add(shapesCombo);
            jp.add(btn);
            this.add(jp);
            for (JPanel panel : textPanels) {
                jp.add(panel);
            }
            this.setVisible(true);
        }

        /**
         * The action listeners of the ShapeCombo.
         *
         * @param e the action event
         */
        public void shapeChange(java.awt.event.ActionEvent e) {
            // as a start hide all the panels
            for (JPanel panel : textPanels) {
                panel.setVisible(false);
            }

            // check the selected index to set the shape to the corresponding 
            // right shape.
            switch (((JComboBox) e.getSource()).getSelectedIndex()) {
                case 0:
                    shape = new Circle();
                    break;
                case 1:
                    shape = new Square();
                    break;
                case 2:
                    shape = new Triangle();
                    break;
                case 3:
                    shape = new Rectangle();
                    break;
                case 4:
                    shape = new Sphere();
                    break;
                case 5:
                    shape = new Cube();
                    break;
                case 6:
                    shape = new Cone();
                    break;
                case 7:
                    shape = new Cylinder();
                    break;
                case 8:
                    shape = new Torus();
                    break;
            }
            // Now after knowing the shape we know the number of variables in 
            // that shape using the getVariables function. So we show the exact
            // number of panels.
            for (int i = 0; i < shape.getVariables().length; i++) {
                this.textPanels.get(i).setVisible(true);
                ((JLabel) (this.textPanels.get(i).getComponent(0)))
                        .setText(shape.getVariables()[i]);
            }
        }

        /**
         * Function responsible of creating one Panel containing label and text
         * field for one variable to be controlled by the user for a shape.
         *
         * @return A panel containing label and text field for one variable to
         * be controlled by the user for a shape
         */
        JPanel getVariableControllerTempPanel() {
            // create label
            JLabel a = new JLabel("temp:");
            a.setFont(customFont);

            // create textField
            JTextField b = new JTextField(5);
            b.setFont(customFont);
            b.setText("300");

            // create panel and add label and text field into it
            JPanel jp = new JPanel();
            jp.add(a);
            jp.add(b);
            return jp;
        }
    }
}
