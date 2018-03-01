import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Creates the skin color and the structure of the face.
 */
public class Face {

    private int xLeft;
    private int yTop;
    public static int headWidth;
    public static int headHeight;
    private Color faceColor;

    public Face(int xLeft, int yTop) {

        this.xLeft = xLeft;
        this.yTop = yTop;
        this.faceColor = new Color(255, 239, 213);
        this.headHeight = 400;
        this.headWidth = 350;

    }

    public int getHeadWidth(){

        return this.headWidth;

    }

    /**
     * Draws the face of the person. Face structure and skin is generally the same for any age, so no age is required.
     *
     * @param g2
     */
    public void draw(Graphics2D g2) {

        int faceX = 35; // this is a value used to fix the distance between the face and the left side of the screen
        int frameHeight = HeadComponent.frameHeight;
        int frameWidth = HeadComponent.frameWidth;

        //if the frame is less than 1000 in width or height then scaling will apply
        if (frameWidth < 1000) {
            faceX = (int) (0.035 * frameWidth);
            this.headWidth = (int) (0.35 * frameWidth); // this is the alternative to doing framewidth/1000 * 35
        }
        if (frameHeight < 1000) {
            this.headHeight = (int) (0.4 * frameHeight);
        }

        Ellipse2D.Double face = new Ellipse2D.Double(this.xLeft + faceX, this.yTop, this.headWidth, this.headHeight);

        g2.setColor(this.faceColor);
        g2.fill(face);

    }

}
