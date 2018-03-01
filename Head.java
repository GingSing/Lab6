
import java.awt.*;

public class Head {

    private int xLeft;
    private int yTop;
    private int age;
    private int count;
    private boolean moveUp;
    private Ears ears = new Ears(this.xLeft, this.yTop);
    private Eyes eyes = new Eyes(this.xLeft, this.yTop);
    private Mouth mouth = new Mouth(this.xLeft, this.yTop);
    private Face face = new Face(this.xLeft, this.yTop);
    private Eyebrows eyebrows = new Eyebrows(this.xLeft, this.yTop);
    private Hair hair = new Hair(this.xLeft, this.yTop);
    private Nose nose = new Nose(this.xLeft, this.yTop);

    public Head(int xLeft, int yTop, int age) {

        this.xLeft = xLeft;
        this.yTop = yTop;
        this.age = age;
        this.count = 0;
        this.moveUp = true;
        this.ears = new Ears(this.xLeft, this.yTop);
        this.eyes = new Eyes(this.xLeft, this.yTop);
        this.mouth = new Mouth(this.xLeft, this.yTop);
        this.face = new Face(this.xLeft, this.yTop);
        this.eyebrows = new Eyebrows(this.xLeft, this.yTop);
        this.hair = new Hair(this.xLeft, this.yTop);
        this.nose = new Nose(this.xLeft, this.yTop);

    }

    public void moveEars(){
        this.ears.move();
    }

    public void moveEyes(double mouseX, double mouseY){

        this.eyes.moveEyes(mouseX, mouseY);

    }

    public void moveMouth(){
        this.mouth.move();
    }

    public void moveEyebrows(){
        this.eyebrows.move();
    }

    public void draw(Graphics2D g2){

        this.face.draw(g2);
        this.ears.draw(g2);
        this.eyes.draw(g2, this.age);
        this.eyebrows.draw(g2, this.age);
        this.hair.draw(g2, this.age);
        this.nose.draw(g2, this.age);
        this.mouth.draw(g2, this.age);

    }

}
