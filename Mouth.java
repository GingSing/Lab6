
import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Draws the mouth in dark pink with differences if older than 50.
 */
public class Mouth {

    private int xLeft;
    private int yTop;
    private int mouthWidth;
    private int mouthHeight;
    private Color lipColor;
    private int count;
    private boolean moveUp;
    private int arcStart;
    private int arcEnd;

    public Mouth(int xLeft, int yTop) {

        this.xLeft = xLeft;
        this.yTop = yTop;
        this.lipColor = new Color(227, 93, 106);
        this.mouthWidth = 120;
        this.mouthHeight = 100;
        this.count = 0;
        this.moveUp = true;
        this.arcStart = -160;
        this.arcEnd = 140;

    }

    public void move(){

        if(this.count == 3 && this.moveUp == true){
            this.moveUp = false;
            this.count = 0;
        }else if(count == 3 && this.moveUp == false){
            this.moveUp = true;
            this.count = 0;
        }

        if(this.moveUp == true) {

            this.arcEnd += 20;
            this.arcStart -= 10;

        }else if(this.moveUp == false){

            this.arcStart += 10;
            this.arcEnd -= 20;
        }

        this.count++;

    }


    /**
     * Draws the mouth in dark pink and is slightly less happy when the age is above 50.
     *
     * @param g2
     * @param age determines whether the smile is big or small
     */
    public void draw(Graphics2D g2, int age) {

        int mouthY = 250;
        int mouthX = 145;

        //to not repeat code
        int frameWidth = HeadComponent.frameWidth;
        int frameHeight = HeadComponent.frameHeight;


        if (age >= 50) {
            this.mouthWidth -= 25;
            this.mouthHeight -= 55;
            mouthX += 17;
        }

        //changes the values of the class depending on the frame sizes
        if (frameWidth < 1000) {

            if (age < 50) {
                this.mouthWidth = (int) (0.12 * frameWidth);
            } else {
                this.mouthWidth = (int) (0.095 * frameWidth);
            }

            if (age < 50) {
                mouthX = (int) (0.145 * frameWidth);
            } else {
                mouthX = (int) (0.162 * frameWidth);
            }

        }

        if (frameHeight < 1000) {

            if (age < 50) {
                this.mouthHeight = (int) (0.1 * frameHeight);
            } else {
                this.mouthHeight = (int) (0.045 * frameHeight);
            }

            mouthY = (int) (0.25 * frameHeight);

        }

        // can change the starting point of the arc to make the same effect as the professor but chose not to
        Arc2D.Double mouth = new Arc2D.Double(this.xLeft + mouthX, this.yTop + mouthY, this.mouthWidth, this.mouthHeight, this.arcStart, this.arcEnd, Arc2D.OPEN);

        g2.setColor(lipColor);
        g2.draw(mouth);

    }
}
