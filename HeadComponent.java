import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Creates two Head classes and separates them into two different sections.
 * This class links the head and label classes together to form a face.
 * Class also extends JComponent so that it can override the paintComponent method
 * and draw on the frame.
 */

public class HeadComponent extends JComponent {

    // these two methods allow the other classes to know how big the frame size is
    public static int frameWidth;
    public static int frameHeight;
    private int HEAD1_X = 400;
    private int HEAD1_Y = 400;
    private Head head = new Head(HEAD1_X, HEAD1_Y, 0);


    public void moveEars(){

        head.moveEars();
        repaint();

    }

    public void moveEyebrows(){

        head.moveEyebrows();
        repaint();

    }

    public void moveMouth(){

        head.moveMouth();
        repaint();

    }

    public void moveEyes(double mouseX, double mouseY){

        head.moveEyes(mouseX, mouseY);
        repaint();

    }

    /**
     * Links the head and the label classes and initializes them when the method is called.
     * Also, constantly updates the frameWidth and frameHeight function when called so the other
     * classes can get the proper data necessary.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {

        //updates values for frame width and frame height for other classes
        // had to be done in here because it doesn't work outside of the function
        this.frameWidth = getWidth();
        this.frameHeight = getHeight();

        //changes the graphic type
        Graphics2D g2 = (Graphics2D) g;

        this.head.draw(g2);


    }


}
