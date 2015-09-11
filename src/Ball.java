
import java.awt.*;

/**
 * Created by brian on 9/11/15.
 */
public class Ball extends Rectangle {

    private int RADIUS=10;



    public Ball(){
        this.x=200;
        this.y=200;

    }

    public int getRADIUS() {
        return RADIUS;
    }

    public boolean onStep(Steps step){

       if (this.x<=(step.x+step.width)-this.RADIUS && this.x>=step.x && step.y-step.height==this.y){
           if(step.isSpike){
               System.out.println("\tGAME OVER \tBall on spike step");
           }else {
               //System.out.println("Ball on step");
           }
        return true;
        }
        else {
            return false;
        }
    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.BLUE);
        graphics.fillRect(this.x,this.y,RADIUS,RADIUS);

    }


}
