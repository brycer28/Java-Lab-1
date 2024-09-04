import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        final int imgWidth = 100;
        final int imgHeight = 50;
        int x = 0;
        int y = 0;

        for (Map.Entry<Register.Denomination, Integer> entry : purse.getDenoms().entrySet()) {
            Register.Denomination d = entry.getKey();

            int count = entry.getValue();
            String s = d.img();
            ImageIcon i = new ImageIcon(s);
            Image img = i.getImage();

            for (int j = 0; j < count; j++) {
                g2d.drawImage(img, x, y, imgWidth, imgHeight, this);
                x += imgWidth + 20;
                if (x > getWidth() - imgWidth) {
                    x = 10;
                    y += imgHeight + 20;
                }
            }
        }
    }
}

//just another terrible attempt
        /*String s = purse.purseToString();
        for (String line : s.split("\n")) {
            x += 10;
            y += 10;
            if (line.contains("Hundred")) {
                ImageIcon imgIcon = new ImageIcon("resized/hundred_note.png");
                Image i = imgIcon.getImage();
                g2d.drawImage(i, x, y, imgWidth, imgHeight, this);
            } else if (line.contains("Twenty")) {
                ImageIcon imgIcon = new ImageIcon("resized/twenty_note.png");
                Image i = imgIcon.getImage();
                g2d.drawImage(i, x, y, imgWidth, imgHeight, this);
            } else if (line.contains("Ten")) {
                ImageIcon imgIcon = new ImageIcon("resized/ten_note.png");
                Image i = imgIcon.getImage();
                g2d.drawImage(i, x, y, imgWidth, imgHeight, this);
            }  else if (line.contains("Five")) {
                ImageIcon imgIcon = new ImageIcon("resized/five_note.png");
                Image i = imgIcon.getImage();
                g2d.drawImage(i, x, y, imgWidth, imgHeight, this);
            }
            else if (line.contains("One Dollar")) {
                ImageIcon imgIcon = new ImageIcon("resized/one_note.png");
                Image i = imgIcon.getImage();
                g2d.drawImage(i, x, y, imgWidth, imgHeight, this);
            }else if (line.contains("Quarter")) {
                ImageIcon imgIcon = new ImageIcon("resized/quarter.png");
                Image i = imgIcon.getImage();
                g2d.drawImage(i, x, y, imgWidth, imgHeight, this);
            } else if (line.contains("Dime")) {
                ImageIcon imgIcon = new ImageIcon("resized/dime.png");
                Image i = imgIcon.getImage();
                g2d.drawImage(i, x, y, imgWidth, imgHeight, this);
            } else if (line.contains("Nickel")) {
                ImageIcon imgIcon = new ImageIcon("resized/nickel.png");
                Image i = imgIcon.getImage();
                g2d.drawImage(i, x, y, imgWidth, imgHeight, this);
            } else if (line.contains("Penny")) {
                ImageIcon imgIcon = new ImageIcon("resized/penny.png");
                Image i = imgIcon.getImage();
                g2d.drawImage(i, x, y, imgWidth, imgHeight, this);
            }*/

//another attempt that did not work either
//same issue - kept getting issues trying to create the pursepanel object
    /*
    public PursePanel(Purse p) {
        this.setPreferredSize(new Dimension(250, 500));
        this.setBackground(Color.ORANGE);

        JPanel labelHolder = new JPanel();
        String str = p.purseToString();
        for (String line : str.split("\n")) {
            if (line.contains("Hundred")) {
                JLabel l = new JLabel();
                l.setIcon(new ImageIcon("resized/hundred_note.png"));
                labelHolder.add(l);
            } else if (line.contains("Twenty")) {
                JLabel l = new JLabel();
                l.setIcon(new ImageIcon("resized/twenty_note.png"));
                labelHolder.add(l);
            } else if (line.contains("Ten")) {
                JLabel l = new JLabel();
                l.setPreferredSize(new Dimension(50 , 50));
                l.setIcon(new ImageIcon("resized/ten_note.png"));
                labelHolder.add(l);
            } else if (line.contains("Five")) {
                JLabel l = new JLabel();
                l.setIcon(new ImageIcon("resized/five_note.png"));
                labelHolder.add(l);
            } else if (line.contains("One Dollar Bill")) {
                JLabel l = new JLabel();
                l.setIcon(new ImageIcon("resized/one_note.png"));
                labelHolder.add(l);
            } else if (line.contains("Quarter")) {
                JLabel l = new JLabel();
                l.setIcon(new ImageIcon("resized/quarter.png"));
                labelHolder.add(l);
            } else if (line.contains("Dime")) {
                JLabel l = new JLabel();
                l.setIcon(new ImageIcon("resized/dime.png"));
                labelHolder.add(l);
            } else if (line.contains("Nickel")) {
                JLabel l = new JLabel();
                l.setIcon(new ImageIcon("resized/nickel.png"));
                labelHolder.add(l);
            } else {
                JLabel l = new JLabel();
                l.setIcon(new ImageIcon("resized/penny.png"));
                labelHolder.add(l);
            }
        }

        this.add(labelHolder);
    }

    public void setPurse(Purse p) {
        this.p = p;
    }

    //paintComponents holds logic to display purse contents
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
*/