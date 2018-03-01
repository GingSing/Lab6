//Gary Yue 100194085

import java.awt.*;
import java.awt.geom.Arc2D;

/**Draws and colors the line of the nose black.
 */
public class Nose {

    private int xLeft;
    private int yTop;
    private int noseWidth;
    private int noseHeight;
    private Color noseColor;

    public Nose(int xLeft, int yTop) {

        this.xLeft = xLeft;
        this.yTop = yTop;
        this.noseColor = new Color(0, 0, 0);
        this.noseWidth = 75;
        this.noseHeight = 100;

    }

    /**Draws and colors the line of the nose. Slightly smaller when the age is over 50.
     *
     * @param g2
     * @param age age determines the size of the nose
     */
    public void draw(Graphics2D g2, int age) {

        int noseY = 150;
        int noseX = 165;

        // to not repeat code
        int frameHeight = HeadComponent.frameHeight;
        int frameWidth = HeadComponent.frameWidth;

        if (age >= 50) {
            this.noseWidth -= 25;
            this.noseHeight-= 25;
            noseX += 17;
        }

        //
        if (frameWidth < 1000) {

            if (age < 50) {
                this.noseWidth= (int) (0.075 * frameWidth);
            } else {
                this.noseWidth = (int) (0.05 * frameWidth);
            }

            if (age < 50) {
                noseX = (int) (0.165 * frameWidth);
            } else {
                noseX = (int) (0.182 * frameWidth);
            }

        }

        if (frameHeight < 1000) {

            if (age < 50) {
                this.noseHeight = (int) (0.1 * frameHeight);
            } else {
                this.noseHeight = (int) (0.075 * frameHeight);
            }

            noseY = (int) (0.15 * frameHeight);

        }

        Arc2D.Double mouth = new Arc2D.Double(this.xLeft + noseX, this.yTop + noseY, this.noseWidth, this.noseHeight, -180, 180, Arc2D.OPEN);

        g2.setColor(noseColor);
        g2.draw(mouth);

    }

}
