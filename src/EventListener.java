import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by brian on 9/11/15.
 */
public class EventListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            {
                RapidRoll.ball.x-=10;
                if (RapidRoll.ball.x<0)
                    RapidRoll.ball.x=0;
                break;
            }

            case KeyEvent.VK_RIGHT:
            {

                RapidRoll.ball.x+=10;
                if (RapidRoll.ball.x>RapidRoll.WIDTH-RapidRoll.ball.getRADIUS())
                    RapidRoll.ball.x=RapidRoll.WIDTH-RapidRoll.ball.getRADIUS();
                break;
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
