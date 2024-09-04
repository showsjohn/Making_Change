import javax.swing.*;
import java.awt.*;



public class PursePanel extends JPanel
{
    Purse purse;
    JPanel innerPanel;
    public boolean ready;

    public PursePanel()
    {
        setPreferredSize(new Dimension(1000, 600));
        innerPanel = new JPanel();
        innerPanel.setPreferredSize(new Dimension(1000, 600));
        this.add(innerPanel);
    }

    public void setPurse(Purse p)
    {
        purse = p;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ready)
        {
            innerPanel.removeAll();
            var cash = purse.getContents();
            var denoms = cash.keySet();
            System.out.println(purse);

            if (purse.getValue() == 0)
            {
                JLabel label = new JLabel();
                ImageIcon img = new ImageIcon("images/empty.png");
                label.setIcon(img);
                label.setBounds(300, 0, 500, 500);
                innerPanel.add(label);

            }


            int x, y, width, height;
            y = 50;
            x = 10;
            height = 100;

            for (var denom: denoms)
            {
                for (int i = 0; i < cash.get(denom); i++)
                {
                    if (denom.form() == Form.bill)
                    {
                        width = 234;
                    } else{
                        width = 100;
                    }

                    JLabel label = new JLabel();
                    ImageIcon img = new ImageIcon(new ImageIcon(denom.img()).getImage().getScaledInstance(width,height, Image.SCALE_FAST));
                    label.setIcon(img);
                    label.setBounds(x,y,width,height);
                    innerPanel.add(label);

                    if(denom.form() == Form.bill)
                    {
                        x += 248;

                    }
                    else
                    {
                        x += 110;
                    }
                    if (x >= 900)
                    {
                        x = 10;
                        y += 110;
                    }

                }


            }

        }
    }
}
