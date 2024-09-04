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

    /********************************************************
     * Function: setPurse
     * Args: Purse
     * Returns: void
     * Description: Sets 'purse' field to Arg
     ********************************************************/
    public void setPurse(Purse p)
    {
        purse = p;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ready)
        {
            // Remove all contents in innerPanel to avoid repainting old images
            innerPanel.removeAll();
            // Get a copy of the Purse's HashMap
            var cash = purse.getContents();
            var denoms = cash.keySet();

            // If input value is <= 0, display "empty" image
            if (purse.getValue() == 0)
            {
                JLabel label = new JLabel();
                ImageIcon img = new ImageIcon("images/empty.png");
                label.setIcon(img);
                label.setBounds(300, 0, 500, 500);
                innerPanel.add(label);
            }

            // Variables to hold position of images and their size
            int x, y, width, height;
            y = 50;
            x = 10;
            height = 100;

            // Loop through each Denomination in the HashMap
            for (var denom: denoms)
            {
                for (int i = 0; i < cash.get(denom); i++)
                {
                    if (denom.form() == Form.bill) // if denomination is a bill, set it wider than a coin
                    {
                        width = 234;
                    } else{
                        width = 100;
                    }
                    // create a label and icon image, and add the label to the innerPanel
                    JLabel label = new JLabel();
                    ImageIcon img = new ImageIcon(new ImageIcon(denom.img()).getImage().getScaledInstance(width,height, Image.SCALE_FAST));
                    label.setIcon(img);
                    label.setBounds(x,y,width,height);
                    innerPanel.add(label);

                    x += width + 14; // Increment x value to space out currency images

                    if (x >= 900) // If x >= 900, the image overflows the container. Reset x and increment y.
                    {
                        x = 10;
                        y += 110;
                    }
                }
            }

        }
    }
}
