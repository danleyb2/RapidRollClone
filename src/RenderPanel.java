import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by brian on 9/11/15.
 */
public class RenderPanel extends JPanel {
    public RenderPanel(){


    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        RapidRoll.rapidRoll.repaint(g);


    }
}
