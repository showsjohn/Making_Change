import javax.swing.*;
import java.awt.*;

public class MakingChange
{
    public static void main(String[] args) {
        JFrame jframe = new JFrame("Making Change");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setPreferredSize(new Dimension(1000,1000));

        jframe.add(new RegisterPanel());
        jframe.pack();
        jframe.setVisible(true);

    }
}
