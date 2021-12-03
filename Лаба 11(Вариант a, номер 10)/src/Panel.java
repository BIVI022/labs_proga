import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {

    Timer timer;
    int width = 100;
    int height = 100;
    int x = 100;
    int y = 0;
    int speed = 10;
    boolean reverseDirection = false;

    Panel() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.drawOval(x, y, width, height);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println();
        if(y >= this.getHeight() - height) {
            reverseDirection = true;
            height = 70;
            width = 110;
        } else if(y <= 0) {
            reverseDirection = false;
            height = 70;
            width = 110;
        }

        if(y < this.getHeight() - this.getHeight() / 3 && y > this.getHeight() / 3) {
            width = 100;
            height = 100;
        }

        y += reverseDirection ? -speed : speed;

        repaint();
    }

}
