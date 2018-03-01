
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**Draws and colors the eyebrows depending on the age.
 */
public class Eyebrows {

    private int xLeft;
    private int yTop;
    private int eyebrowWidth;
    private int eyebrowHeight;
    private Color eyebrowColor;
    private int count;
    private boolean moveUp;

    public Eyebrows(int xLeft, int yTop) {

        this.xLeft = xLeft;
        this.yTop = yTop;
        this.eyebrowColor = new Color(0, 0, 0);
        this.eyebrowWidth = 75;
        this.eyebrowHeight = 25;
        this.count = 0;
        this.moveUp = true;

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

            this.yTop++;

        }else if(this.moveUp == false){

            this.yTop--;

        }

        this.count++;

    }


    /** Draws and colors the eybrows depending on the age. People above the age of 50 get grey eyebrows.
     * People under the age of 50 have black eyebrows.
     *
     * @param g2
     * @param age determines the color of eyebrows
     */
    public void draw(Graphics2D g2, int age) {

        int eyebrowY = 73; // hardcoded to have the values at specific points
        int eyebrowX = 115; // could also divide up the width into parts and then take percentage but I did this way first
        int eyeDistance = 100;

        //to not repeat code
        int frameHeight = HeadComponent.frameHeight;
        int frameWidth = HeadComponent.frameWidth;

        if (age >= 50) {

            this.eyebrowColor = new Color(211, 211, 211);
            eyebrowY += 30;
            eyebrowX += 7;

        }
        // updates the values of the class depending on the frame sizes
        if (frameHeight < 1000) {

            this.eyebrowHeight = (int) (0.025 * frameHeight);
            if (age < 50) {
                eyebrowY = (int) (0.073 * frameHeight);
            } else {
                eyebrowY = (int) (0.103 * frameHeight);
            }

        }

        if (frameWidth < 1000) {

            this.eyebrowWidth = (int) (0.075 * frameWidth);
            if (age < 50) {
                eyebrowX = (int) (0.115 * frameWidth);
            } else {
                eyebrowX = (int) (0.122 * frameWidth);
            }
            eyeDistance = (int) (0.1 * frameWidth);

        }

        Ellipse2D.Double eyebrow1 = new Ellipse2D.Double(this.xLeft + eyebrowX, this.yTop + eyebrowY, this.eyebrowWidth, this.eyebrowHeight);
        Ellipse2D.Double eyebrow2 = new Ellipse2D.Double(this.xLeft + eyebrowX + eyeDistance, this.yTop + eyebrowY, this.eyebrowWidth, this.eyebrowHeight);

        g2.setColor(this.eyebrowColor);
        g2.fill(eyebrow1);
        g2.fill(eyebrow2);

    }

}
