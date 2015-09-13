
import java.awt.*;

/**
 * Created by brian on 9/11/15.
 */
public class Ball extends Rectangle {

    private int RADIUS = 10;


    public Ball() {
        this.x = 200;
        this.y = 200;

    }

    public int getRADIUS() {
        return RADIUS;
    }


    /**
     * Checks if the ball is on a step
     *
     * @param step
     * @return boolean
     */
    public boolean onStep(Steps step) {


        if (
            //ball not past step right end
                this.x <= (step.x + step.width) &&
                        //ball past step left start
                        this.x >= step.x &&
                        //step top equals ball bottom
                        (step.y - step.height == this.y || step.y - step.height == this.y - 1)

                ) {

            if (step.isSpike) {
                System.out.println("\tGAME OVER \tBall on spike. SCORE:" + RapidRoll.score);
                RapidRoll.gameOver = true;

            } else {
                //System.out.println("Ball on step");
            }
            return true;
        } else {
            return false;
        }
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(this.x, this.y, RADIUS, RADIUS);

    }


}
