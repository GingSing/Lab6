
import java.awt.*;
import java.awt.geom.Ellipse2D;

import static java.awt.Color.black;

/**Draws and colors ears with a peach color.
 *
 */
public class Ears {

    private int xLeft;
    private int yTop;
    private int earWidth;
    private int earHeight;
    private Color earColor;
    private int count;
    private boolean moveUp;

    public Ears(int xLeft, int yTop) {

        this.xLeft = xLeft;
        this.yTop = yTop;
        this.earColor = new Color(255, 239, 213);
        this.earWidth = 75;
        this.earHeight = 125;
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
            this.yTop+=2;
        }else if(this.moveUp == false){
            this.yTop-=2;
        }

        this.count++;

    }

    /**Draws and colors ears with a peach color. Ears are the same at all ages.
     *
     * @param g2
     */
    public void draw(Graphics2D g2) {

        int earY = 35; //hardcoded but can change to percentage of width

        //to not repeat the code
        int frameHeight = HeadComponent.frameHeight;
        int frameWidth = HeadComponent.frameWidth;

        //allows for scaling of the image
        if (frameHeight < 1000) {

            earY = (int) (0.035 * frameHeight);
            this.earHeight = (int) (0.125 * frameHeight);

        }

        if (frameWidth < 1000) {

            this.earWidth = (int) (0.075 * frameWidth);

        }

        Ellipse2D.Double ear1 = new Ellipse2D.Double(this.xLeft, this.yTop + earY, this.earWidth, this.earHeight);
        Ellipse2D.Double ear2 = new Ellipse2D.Double(this.xLeft + Face.headWidth, this.yTop + earY, this.earWidth, this.earHeight);

        g2.setColor(this.earColor);
        g2.fill(ear1);
        g2.fill(ear2);

    }
}
