import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel
{
    Register register;
    JPanel inputPanel,titlePanel;
    JLabel title, dollarSign;
    JTextField input;
    PursePanel changePanel;

    public RegisterPanel()
    {
        register = new Register();
        inputPanel = new JPanel();
        titlePanel = new JPanel();

        changePanel = new PursePanel();
        input = new JTextField();
        dollarSign = new JLabel("$");
        dollarSign.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,40 ));
        title = new JLabel("Enter Amount");
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,40 ));

        titlePanel.setPreferredSize(new Dimension(1000, 60));
        inputPanel.setPreferredSize(new Dimension(1000, 200));
        inputPanel.setOpaque(false);


        input.setPreferredSize(new Dimension(400,100));
        input.setFont(new Font("Serif", Font.PLAIN, 40));
        input.addActionListener(new InputListener());


        titlePanel.add(title);
        inputPanel.add(dollarSign);
        inputPanel.add(input);
        this.add(titlePanel);
        this.add(inputPanel);
        this.add(changePanel);
    }

    private class InputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

            changePanel.setPurse(register.makeChange(Double.parseDouble(input.getText())));
            changePanel.ready = true;
            changePanel.revalidate();
            changePanel.repaint();
            revalidate();
            repaint();


        }
    }

}
