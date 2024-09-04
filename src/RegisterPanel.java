import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register = new Register();
    private JPanel inputPanel = new JPanel();
    private JTextField input = new JTextField(7);
    private PursePanel changePanel = new PursePanel();

    public RegisterPanel() {
        //set dimensions of RegisterPanel
        setLayout(new BorderLayout());

        inputPanel = new JPanel();
        inputPanel.add(new JLabel("Please enter the amount:"));
        inputPanel.add(input);
        add(inputPanel, BorderLayout.WEST);

        add(changePanel, BorderLayout.EAST);

        input.addActionListener(new InputListener());

        //first attempt at creating register panel
        /*
        inputPanel = new JPanel();
        inputPanel.setBackground(Color.CYAN);
        inputPanel.setPreferredSize(new Dimension(250, 500));

        //add input to inputPanel
        input = new JTextField();
        input.setBackground(Color.BLUE);
        input.setPreferredSize(new Dimension(50, 50));
        input.setFont(new Font("Serif", Font.PLAIN, 16));
        *//*input.addActionListener(new ActionListener()) {*//*

        //input label (UI)
        JLabel label = new JLabel("Enter Amount:");
        label.setFont(new Font("Serif", Font.PLAIN, 16));

        //add components to inputPanel
        inputPanel.add(label);
        inputPanel.add(input);

        //add inputPanel to obj
        this.add(inputPanel);

        //purse panel
        this.add(changePanel);*/
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double amt = Double.parseDouble(input.getText());
            try {
                if (amt < 0) {
                    changePanel.setPurse(new Purse());
                } else {
                    Purse p = Register.makeChange(amt);
                    changePanel.setPurse(p);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            }
        }
    }
}

