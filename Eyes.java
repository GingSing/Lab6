
import java.awt.*;
import java.awt.geom.Ellipse2D;

import static java.awt.Color.black;
import static java.awt.Color.red;
import static java.awt.Color.white;

/**
 * Draws and colors eyes. Eyes are smaller for people that are older
 * because some have to squint to see things properly.
 */
public class Eyes {

    private int xLeft;
    private int yTop;
    private int eyeY;
    private int eyeX;
    private int eyeSpace;
    private int eyeRadius;
    private int pupilRadius;
    private double leftPupilX;
    private double leftPupilY;
    private double rightPupilX;
    private double rightPupilY;

    public Eyes(int xLeft, int yTop) {

        this.xLeft = xLeft;
        this.yTop = yTop;
        this.eyeY = 105;
        this.eyeX = 143;
        this.eyeSpace = 100;
        this.eyeRadius = 40;
        this.pupilRadius = 10;
        this.leftPupilX = 10;
        this.leftPupilY = 5;
        this.rightPupilX = 10;
        this.rightPupilY = 5;

    }

    public boolean checkInBounds(double mouseX, double mouseY){

        if(Math.sqrt((Math.pow((mouseX - (this.xLeft + this.eyeX)),2) + (Math.pow((mouseY - (this.yTop + this.eyeY)),2)))) < this.eyeRadius){

            return true;

        }

        return false;

    }

    public void moveEyes(double mouseX, double mouseY){

        int maxMovement = this.eyeRadius - this.pupilRadius;

        double d1 = Math.sqrt(Math.pow((mouseY - this.yTop - this.eyeY - this.eyeRadius), 2) + Math.pow((mouseX - this.xLeft - this.eyeX - this.eyeRadius),2));

        if(checkInBounds(mouseX, mouseY)){

            this.leftPupilX = mouseX - xLeft - pupilRadius - this.eyeX;
            this.leftPupilY = mouseY - yTop - pupilRadius - this.eyeY;

        }else{

            this.leftPupilX = (mouseX - this.xLeft - this.eyeX - this.eyeRadius)/ d1 * maxMovement;
            this.leftPupilY = (mouseY - this.yTop - this.eyeY - this.eyeRadius)/ d1 * maxMovement;

        }

    }

    /**
     * Draws and colors eyes. Ages above or equal to 50 have thinner lines for eyes.
     *
     * @param g2
     * @param age age determines the shape of the eyes
     */
    public void draw(Graphics2D g2, int age) {

        int frameHeight = HeadComponent.frameHeight;
        int frameWidth = HeadComponent.frameWidth;

        //scales the height and width based on the window
        if (frameHeight < 1000) {

//            this.rightPupilY = ((this.rightPupilY/10) * frameHeight);
//            this.leftPupilY = ((this.leftPupilY/10) * frameHeight);


            this.eyeY = (int) (0.105 * frameHeight);
            //this.eyeRadius = (int) (0.04 * frameHeight);
            this.pupilRadius = (int) (0.01 * frameHeight);

        }

        if (frameWidth < 1000) {

//            this.rightPupilX = ((rightPupilX/10) * frameWidth);
//            this.leftPupilX = ((rightPupilX/10) * frameWidth);


            this.eyeX = (int) (0.143 * frameWidth);
            this.eyeSpace = (int) (0.1 * frameWidth);
            //this.eyeRadius = (int) (0.04 * frameWidth);
            this.pupilRadius = (int) (0.01 * frameWidth);

        }

        if (age >= 50) {
            //eyes sometimes disappears if the size of the frame is too small
            this.eyeRadius -= 15;
            this.eyeY += 30;
        }

        Ellipse2D.Double eye1 = new Ellipse2D.Double(this.xLeft + this.eyeX, this.yTop + this.eyeY, this.eyeRadius, this.eyeRadius);
        Ellipse2D.Double eye2 = new Ellipse2D.Double(this.xLeft + this.eyeSpace + this.eyeX, this.yTop + this.eyeY, this.eyeRadius, this.eyeRadius);

        g2.setColor(white);
        g2.fill(eye1);
        g2.fill(eye2);

        Ellipse2D.Double pupil1 = new Ellipse2D.Double(this.leftPupilX + this.eyeX + this.xLeft, this.leftPupilY  + this.eyeY + this.yTop, this.pupilRadius, this.pupilRadius);
        Ellipse2D.Double pupil2 = new Ellipse2D.Double(this.rightPupilX + this.eyeX + this.xLeft + this.eyeSpace, this.rightPupilY  + this.eyeY + this.yTop , this.pupilRadius, this.pupilRadius);

        g2. setColor(red);
        g2.fill(pupil1);
        g2.fill(pupil2);

    }

}
