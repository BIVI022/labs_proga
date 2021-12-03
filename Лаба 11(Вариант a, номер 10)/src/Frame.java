import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

        Panel panel;

        Frame() {

            panel = new Panel();

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(700, 700);
            this.add(panel);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
}
