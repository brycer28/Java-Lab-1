import java.awt.*;
import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        //create basic JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Making Change");
        frame.setSize(700, 700);

        //create registerPanel
        RegisterPanel r = new RegisterPanel();

        //add registerPanel
        frame.add(r);

        //boring
        frame.pack();
        frame.setVisible(true);
    }
}
