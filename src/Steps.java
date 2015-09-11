import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by brian on 9/11/15.
 */
public class Steps extends Rectangle {

    private static final int WIDTH=70,HEIGHT=10;
    public boolean isSpike;



    public void paint(Graphics graphics) {
        if (!this.isSpike){
            graphics.setColor(Color.black);

        }else{
            graphics.setColor(Color.RED);
        }
        graphics.fillRect(this.x,this.y,this.width,this.height);


    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public Steps(int x,int y,boolean bs){
        this.x=x;
        this.y=y;
        this.width=WIDTH;
        this.height=HEIGHT;
        this.isSpike=bs;
    }

}
