//Gary Yue 100194085

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Creates the hair color and hair shape of the person.
 */
public class Hair {

    private int xLeft;
    private int yTop;
    private int hairWidth;
    private int hairHeight;
    private Color hairColor;

    public Hair(int xLeft, int yTop) {

        this.xLeft = xLeft;
        this.yTop = yTop;
        this.hairColor = new Color(0, 0, 0);
        this.hairWidth = 100;
        this.hairHeight = 100;

    }

    /**
     * Draws and colors the hair either gray or black depending on the age.
     *
     * @param g2
     * @param age age determines whether the colour is black or gray
     */
    public void draw(Graphics2D g2, int age) {

        //Puffy hair was made in this case but can be replaced later

        if (age >= 50) {
            this.hairColor = new Color(211, 211, 211);
        }

        //hair was separated into 4 different curls

        int curl1Width = 40;
        int curl1Height = 0;

        int curl2Width = 120;
        int curl2Height = -30;

        int curl3Width = 200;
        int curl3Height = -30;

        int curl4Width = 280;
        int curl4Height = 0;

        int frameHeight = HeadComponent.frameHeight;
        int frameWidth = HeadComponent.frameWidth;

        //determines sizes of the drawing depending on the size of the frame.
        if (frameHeight < 1000) {

            curl2Height = (int) (-0.03 * frameHeight);
            curl3Height = (int) (-0.03 * frameHeight);
            this.hairHeight = (int) (0.1 * frameHeight);

        }

        if (frameWidth < 1000) {

            curl1Width = (int) (0.04 * frameWidth);
            curl2Width = (int) (0.12 * frameWidth);
            curl3Width = (int) (0.2 * frameWidth);
            curl4Width = (int) (0.28 * frameWidth);
            this.hairWidth = (int) (0.1 * frameWidth);

        }

        Ellipse2D.Double curl1 = new Ellipse2D.Double(this.xLeft + curl1Width, this.yTop + curl1Height, this.hairWidth, this.hairHeight);
        Ellipse2D.Double curl2 = new Ellipse2D.Double(this.xLeft + curl2Width, this.yTop + curl2Height, this.hairWidth, this.hairHeight);
        Ellipse2D.Double curl3 = new Ellipse2D.Double(this.xLeft + curl3Width, this.yTop + curl3Height, this.hairWidth, this.hairHeight);
        Ellipse2D.Double curl4 = new Ellipse2D.Double(this.xLeft + curl4Width, this.yTop + curl4Height, this.hairWidth, this.hairHeight);


        g2.setColor(this.hairColor);
        g2.fill(curl1);
        g2.fill(curl2);
        g2.fill(curl3);
        g2.fill(curl4);


    }
}
