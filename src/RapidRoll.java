import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;


public class RapidRoll extends JFrame implements ActionListener {

    private Timer timer;
    private Random random;
    private RenderPanel panel;
    public static RapidRoll rapidRoll;
    public static int WIDTH = 350, HEIGHT = 600;
    public static int score;
    public static boolean gameOver = false;

    private int SPACE = 50;

    public static Ball ball;
    private ArrayList<Steps> stepsArrayList = new ArrayList<Steps>();


    public RapidRoll() {
        super("Rapid Roll");
        panel = new RenderPanel();
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(800, 100);
        this.setVisible(true);
        this.addKeyListener(new EventListener());


        timer = new Timer(20, this);
        random = new Random();


    }

    private void addBar() {
        int sz = stepsArrayList.size();
        int ly;

        if (sz == 0) {
            ly = 0 + SPACE;
        } else {
            ly = (stepsArrayList.size() * SPACE) + SPACE;
        }
        int lx = random.nextInt(WIDTH - (Steps.getWIDTH()));
        stepsArrayList.add(new Steps(lx, ly, false));

    }

    private void addSpike() {
        int sz = stepsArrayList.size();
        int ly;

        if (sz == 0) {
            ly = (Integer) 0 + SPACE;
        } else {
            ly = (Integer) ((stepsArrayList.size() * SPACE) + SPACE);
        }
        int lx = random.nextInt(WIDTH - (Steps.getWIDTH() * 2));
        stepsArrayList.add(new Steps(lx, ly, true));

    }

    private void genRandomSteps(int number) {

        for (int i = 1; i <= number; i++) {
            if (random.nextBoolean()) {
                addSpike();
            } else {
                addBar();
            }
        }

    }

    private void genRandomStep() {
        if (random.nextBoolean()) {
            addSpike();
        } else {
            addBar();
        }
    }

    public void repaint(Graphics g) {
        ball.paint(g);
        for (Steps step : stepsArrayList) {
            step.paint(g);
        }

    }


    public static void main(String[] args) {
        rapidRoll = new RapidRoll();
        rapidRoll.startGame();

    }

    public void startGame() {

        gameOver = false;
        score = 0;
        stepsArrayList.clear();
        rapidRoll.genRandomSteps(12);
        rapidRoll.ball = new Ball();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        boolean onAstep = false;
        for (Steps step : stepsArrayList) {
            if (ball.onStep(step)) {
                ball.y -= 1;
                onAstep = true;
            }
            step.y -= 1;
        }
        if (ball.y > HEIGHT || ball.y < 0) {
            gameOver = true;
        }
        panel.repaint();
        if (gameOver) {
            timer.stop();
            return;
        }
        if (!onAstep) {
            ball.y++;
        }

        for (int i = 0; i < stepsArrayList.size(); i++) {

            if (stepsArrayList.get(i).y < 0) {
                stepsArrayList.remove(i);
                score++;
                //System.out.println("removed step");
                genRandomStep();
            }

        }

    }

    //Getters

    public Timer getTimer() {
        return timer;
    }

    public void paintScore(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("Sans", Font.BOLD, 20));
        g.drawString("GAME OVER!!", 50, RapidRoll.HEIGHT / 2 - 40);
        g.drawString("SCORE :" + RapidRoll.score, 60, RapidRoll.HEIGHT / 2 - 20);
        g.drawString("Press enter to start", 70, RapidRoll.HEIGHT / 2);
    }
}
