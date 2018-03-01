import java.awt.event.*;
import javax.swing.*;

public class FrameViewer {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;
    private static final HeadComponent HEAD_COMPONENT = new HeadComponent();
    private static Timer earTimer;
    private static Timer eyebrowTimer;
    private static Timer mouthTimer;

    public static void main(String[] args){

        HEAD_COMPONENT.addMouseListener(new MousePressListener());

        JFrame fr = new JFrame();
        fr.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        fr.setTitle("Head Changer");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(HEAD_COMPONENT);
        fr.addKeyListener(new ArrowKeyListener());
        fr.setVisible(true);

        final int MILLISECS = 500;

        class EarTimerListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                HEAD_COMPONENT.moveEars();

            }
        }

        class EyebrowTimerListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

                HEAD_COMPONENT.moveEyebrows();

            }
        }

        class MouthTimerListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

                HEAD_COMPONENT.moveMouth();

            }
        }

        ActionListener eyebrowListener = new EyebrowTimerListener();

        eyebrowTimer = new Timer(MILLISECS, eyebrowListener);

        toggleTimer(eyebrowTimer);


        ActionListener earListener = new EarTimerListener();

        earTimer = new Timer(MILLISECS, earListener);

        toggleTimer(earTimer);


        ActionListener mouthListener = new MouthTimerListener();

        mouthTimer = new Timer(MILLISECS, mouthListener);

        toggleTimer(mouthTimer);

    }

    public static void toggleTimer(Timer t){

        if(t.isRunning()){
            t.stop();
        }else{
            t.start();
        }

    }

    public static class ArrowKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("hi");
            String key = KeyStroke.getKeyStrokeForEvent(e).toString();
            key = key.replace("pressed ", "");
            if(key.equals("DOWN")){
                toggleTimer(earTimer);
            }else if(key.equals("UP")){
                toggleTimer(eyebrowTimer);
            }else if(key.equals("RIGHT")){
                toggleTimer(mouthTimer);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }


    public static class MousePressListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            HEAD_COMPONENT.moveEyes(e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
