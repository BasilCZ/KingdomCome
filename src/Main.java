import battle.Battle;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        /*Battle battle = new Battle();
        battle.battle();*/

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        int x = Toolkit.getDefaultToolkit().getScreenSize().width/2-375;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height/2-375;
        System.out.println(x);
        System.out.println(y);
        frame.setBounds(x,y,750,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel up = new JPanel();
        up.setBounds(375,0,100,100);
        up.setBackground(Color.YELLOW);
        JPanel down = new JPanel();
        down.setBounds(375,600,100,100);
        down.setBackground(Color.RED);
        JPanel right = new JPanel();
        right.setBounds(600, 375,100,100);
        right.setBackground(Color.BLUE);
        JPanel left = new JPanel();
        left.setBounds(0,375,100,100);
        left.setBackground(Color.BLACK);
        left.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        left.setAlignmentY(JPanel.CENTER_ALIGNMENT);

        JPanel test = new JPanel();


        frame.add(left);
        frame.add(right);
        frame.add(up);
        frame.add(down);
        //frame.add(test);


        boolean playerUp = false;
        boolean playerDown = false;
        boolean playerRight = false;
        boolean playerLeft = false;






        try {
            Robot robot = new Robot();
            while(true){
                if(MouseInfo.getPointerInfo().getLocation().x < frame.getX()+50){
                    robot.mouseMove(frame.getX()+50,MouseInfo.getPointerInfo().getLocation().y);
                }
                if(MouseInfo.getPointerInfo().getLocation().x > frame.getX() + frame.getWidth()-50){
                    robot.mouseMove(frame.getX()+frame.getWidth()-50,MouseInfo.getPointerInfo().getLocation().y);
                }
                if(MouseInfo.getPointerInfo().getLocation().y < frame.getY()+50){
                    robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, frame.getY()+50);
                }
                if(MouseInfo.getPointerInfo().getLocation().y > frame.getY() + frame.getHeight()-50){
                    robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, frame.getY() + frame.getHeight()-50);
                }

                if(MouseInfo.getPointerInfo().getLocation().x < (frame.getWidth()+frame.getX())/2){
                    left.setBackground(Color.GREEN);
                    playerUp = false;
                    playerDown = false;
                    playerRight = false;
                    playerLeft = true;
                } else {
                    left.setBackground(Color.BLACK);
                }

                if(MouseInfo.getPointerInfo().getLocation().x > (frame.getWidth()+frame.getX())/2) {
                    right.setBackground(Color.GREEN);
                    playerUp = false;
                    playerDown = false;
                    playerRight = true;
                    playerLeft = false;
                } else {
                    right.setBackground(Color.BLUE);
                }

                if(MouseInfo.getPointerInfo().getLocation().y < (frame.getHeight()+frame.getX())/2){
                    up.setBackground(Color.GREEN);
                    playerUp = true;
                    playerDown = false;
                    playerRight = false;
                    playerLeft = false;
                } else {
                    up.setBackground(Color.YELLOW);
                }

                if(MouseInfo.getPointerInfo().getLocation().y > (frame.getHeight()+frame.getX())/2){
                    down.setBackground(Color.GREEN);
                    playerUp = false;
                    playerDown = true;
                    playerRight = false;
                    playerLeft = false;
                } else {
                    up.setBackground(Color.RED);
                }
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
}