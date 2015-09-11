import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;


public class RapidRoll extends JFrame implements ActionListener{

    private Timer timer;
    private Random random;
    private RenderPanel panel;
    public static RapidRoll rapidRoll;
    public static int WIDTH=350,HEIGHT=600;
    private int SPACE=50;

    public static Ball ball;
    private ArrayList<Steps> stepsArrayList=new ArrayList<Steps>();




    public RapidRoll(){
        super("Rapid Roll");

        panel=new RenderPanel();
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(800, 100);
        this.setVisible(true);
        this.addKeyListener(new EventListener());


        timer=new Timer(20,this);
        random=new Random();

        timer.start();

    }

    private void addBar(){
        int sz=stepsArrayList.size();
        int ly;

        if (sz==0){
             ly=(Integer)0+SPACE;
        }else{
           ly=(Integer)((stepsArrayList.size()*SPACE)+SPACE);
        }

        int lx=random.nextInt(WIDTH-(Steps.getWIDTH()));

        stepsArrayList.add(new Steps(lx,ly,false));

    }

    private void addSpike(){
        int sz=stepsArrayList.size();
        int ly;

        if (sz==0){
            ly=(Integer)0+SPACE;
        }else{
            ly=(Integer)((stepsArrayList.size()*SPACE)+SPACE);
        }
        int lx=random.nextInt(WIDTH-(Steps.getWIDTH()*2));
        stepsArrayList.add(new Steps(lx,ly,true));

    }
    private void genRandomStep(int number){

        for (int i = 1; i <= number; i++) {
            if (random.nextBoolean()){
                addSpike();
            }else {
                addBar();
            }
        }

    }

    public void repaint(Graphics g){
        //System.out.println("painted comp");
        ball.paint(g);
        for (Steps step : stepsArrayList) {
            step.paint(g);
        }

    }


    public static void main(String[] args){
       rapidRoll= new RapidRoll();
        rapidRoll.genRandomStep(20);
        rapidRoll.ball=new Ball();

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        boolean onAstep=false;
        for (Steps step : stepsArrayList) {

            if(ball.onStep(step)){
                onAstep=true;
                ball.y-=1;
                step.y-=1;
            }else {

                step.y-=1;
            }
        }
        if(!onAstep){ ball.y++;  }

        for (int i = 0; i < stepsArrayList.size(); i++) {

            if (stepsArrayList.get(i).y<0){
                stepsArrayList.remove(i);
                //System.out.println("removed step");
                genRandomStep(1);
            }

        }

        panel.repaint();


    }
}
